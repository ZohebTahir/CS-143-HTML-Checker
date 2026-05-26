import java.util.*;

public class HTMLManager {
   private Queue<HTMLTag> tags;
   // values added to tags queue
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
   // tags returned 
   public Queue<HTMLTag> getTags() {
      return tags;   
   }
   // returns values in string form 
   public String toString() {
      String str = "";
      for(HTMLTag t: tags) {
         str += t.toString().trim();  
      }
      return str; 
   }
   // fixes any missing or extra HTML tags 
   public void fixHTML() {
      Stack<HTMLTag> stack = new Stack<>();
      int size = tags.size();
      for(int i = 0; i < size; i++) { 
         HTMLTag val = tags.remove();
         //returned to queue
         if(val.isSelfClosing()) {
            tags.add(val);  
         }
         //returned to queue/ saved on stack 
         else if(val.isOpening()) {
            tags.add(val); 
            stack.push(val);
              
         }
         //if matching, aligned in queue 
         else if(val.isClosing()){ 
            if(!stack.isEmpty() && val.matches(stack.peek())) {
               tags.add(val);
               stack.pop();  
            }
            //if not matching, val "fixed" and aligned in queue/ removed from stack
            else if (!stack.isEmpty() && !val.matches(stack.peek())) {
               //adds matching closing tag to opening tag, discarded otherwise 
               HTMLTag matchFix = val.getMatching(); 
               if(!matchFix.isOpening()) {
                  tags.add(matchFix);
                  stack.pop();
               }
            } 
                  
         }
      }
      //Residual tags processed 
      while(!stack.isEmpty()) {
         HTMLTag sMatchFix = stack.pop().getMatching(); 
         tags.add(sMatchFix);
      }
   }
   
}
