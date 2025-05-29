public class FrequencyOfChar {
          public static void main(String[] args){
                    String s="aaabbcccd";
                    int[] hash=new int[26];


                    for(int i=0;i<s.length();i++){
                              int temp=(int)s.charAt(i)-'a';
                              hash[temp]+=1;
                    }
                    char find='c';
                    int i=find-'a';
                    System.out.println(hash[i]);
          }
          
}
