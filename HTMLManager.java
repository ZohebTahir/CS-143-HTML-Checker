import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) {
      if (html == null) {
         throw new IllegalArgumentException();
      } else {
      while(!html.isEmpty()){
         tag.add(html.remove());
      }
        }      
  }
  
  public Queue<HTMLTag> getTags() {
      return tags;
  }
}
