import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) {
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
        str += t.toString();  
      }
      return str; 
   }
   
   public void fixHTML() {
      Stack<String> stack = new Stack<>(); 
      HTMLTag val = tags.remove();
      if(val.isSelfClosing()) {
         tags.add(val);  
      } 
         else if(val.isOpening()) { //is true
         
      } else { //isClosing Scenario
         
      }
      
   }
   
}
