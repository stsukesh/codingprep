import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ArrayListPra {
          public static void main(String[] args){
                    ArrayList<Integer> intlist =new ArrayList<>();
                   
                    //Adding elements

                    // intlist.addAll(Arrays.asList(1,2,3));
                    intlist.addAll(0,(Arrays.asList(100,2000,3000)));
                    //System.out.println(intlist.toString());


                    //creating a arraylist from another collection

                    List<Integer> prime=new ArrayList<>(intlist);
                    prime.addAll(Arrays.asList(2,3,5,7));
                    System.out.println(prime);
                    
                    List<Integer> nextnumbrtdd=new ArrayList<>(intlist);
                    


                    
                    
          }

} 
