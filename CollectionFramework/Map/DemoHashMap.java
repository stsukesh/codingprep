
import java.util.HashMap;
import java.util.Map;
public class DemoHashMap{
          public static void main(String[] args){
                    Map<Integer,String> md= new HashMap<> ();
                    md.put(1,"Super");
                    md.put(2,"Super");
                    md.put(3,"Super");
                    md.put(4,"Super");
                    md.put(6,"Super");



                for(Map.Entry<Integer,String> n:md.entryset()){
                    System.out.println(n.getKey());

                }
                }


          }
}