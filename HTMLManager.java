import java.util.*;

public class HTMLManager {
   private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
      tags = new LinkedList<>(); 
      if(html == null) {
         throw new IllegalArgumentException(); 
      } else {
         while(!html.isEmpty()) {
            tags.add(html.remove()); 
         }
      }
   
   }
   public Queue<HTMLTag> getTags() {
      return tags;   
   }
   
   public String toString() {
      String str = "";
      for(HTMLTag t: tags) {
         str += t.toString().trim();  
      }
      return str; 
   }
   
   public void fixHTML() {
      Stack<HTMLTag> stack = new Stack<>();
      int size = tags.size();
      for(int i = 0; i < size; i++) { 
         HTMLTag val = tags.remove();
         if(val.isSelfClosing()) {
            tags.add(val);  
         } 
         else if(val.isOpening()) { //is true
            stack.push(val);
            tags.add(val);  
         
         } else if(val.isClosing()){ //isClosing Scenario
            //HTMLTag stackPeek = stack.peek();
            if(!stack.isEmpty() && val.matches(stack.peek())) {
               tags.add(val);
               stack.pop();  
            } else if (!stack.isEmpty() && !val.matches(stack.peek())) {
               HTMLTag matchFix = val.getMatching();
               tags.add(matchFix);
               stack.pop();
            } 
            //else if(!val.matches(stack.peek())){
               //HTMLTag matchFix = val.getMatching();
               //tags.add(matchFix);
               //stack.pop();
                 
            //}
                  
         }
      }
   }
   
}
