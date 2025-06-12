public class RemoveDistinct {
          public static void main(String[] args){
                    String s="abccdeefggh";
                    String op="";

                    int n=s.length(),i=0;
                    while(i<n){
                              int j=i;
                              while(j<n && s.charAt(i)==s.charAt(j)){
                                        j++;
                              }

                              if(j-i==1){
                                        op+=s.charAt(i);
                              }


                              i=j;

                    }
                    System.out.println(op);

          }

}
