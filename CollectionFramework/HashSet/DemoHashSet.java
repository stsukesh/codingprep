import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public class DemoHashSet{
          public static void main(String[] args){
                    Set<String> hs =new HashSet<>(Arrays.asList("Sukesh","Saran","Thiso"));
                   // hs.addAll(Arrays.asList("Sukesh","Saran","Thiso"));
                    hs.add("Sukesh");//removed coz of same value again entered
                   // System.out.println(hs);
                    
                    
                    Set<String> hs_extend=new HashSet<>(hs);
                    hs_extend.addAll(Arrays.asList("Ruku","Mark"));
                   //System.out.println(hs_extend);
                   
                   hs_extend.removeAll(Arrays.asList("Akshai"));
                 //  System.out.println(hs_extend);
                 
                 System.out.println(hs_extend.)


                   for(String s=)



                    
          }
}