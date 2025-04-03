public class Inheritance {
          public static void main(String[] args){
                    A obj= new A(){
                              public void neaw(){
                                        System.out.print("hello");
                              }
                    };
                    obj.neaw();
          }
          
}
class A{
          public void neaw(){}
          public void show(){
                    System.out.println("hello sukesh A");
          }
}
class B extends A{
          
          public void show(){
                    super.show();
                    //System.out.println("hello sukesh B");
          }
}
