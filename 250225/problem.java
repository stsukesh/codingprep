import java.util.Scanner;
public class problem{
          public Scanner sc= new Scanner(System.in);
          public static void main(String[] args) {
                    problem pro=new problem();
                    //pro.HSC();
                    //pro.middleNumber();
                    //pro.sgstAndCgst();
                    //pro.unitAndFirst();
                    pro.sumFractions();


                    
          }

          public void HSC(){
                    System.out.println("Enter the marks for the five subjects in HSC");
                    int M1,M2,M3,M4,M5;
                    M1=sc.nextInt();
                    M2=sc.nextInt();
                    M3=sc.nextInt();
                    M4=sc.nextInt();
                    M5=sc.nextInt();

                    int avg=(M1+M2+M3+M4+M5)/5;

                    System.out.println("Your average mark in HSC "+ avg);
          }
          public void middleNumber(){
                    System.out.println("Enter the 4 digit number :");
                    int number=sc.nextInt();
                    int middleDigits=(number/10)%100;
                    System.out.println("The middle Digits of the 4 digit number is "+middleDigits);

          }
          public void sgstAndCgst(){
                    short sgst=9;
                    short cgst=9;
                    System.out.println("Enter the price of the product :");
                    short price=sc.nextShort();
                    float sgstAmount = (sgst / 100.0f) * price;
                    float cgstAmount = (cgst / 100.0f) * price;
                    float totalAmount = price + sgstAmount + cgstAmount;
            
                    System.out.println("Total amount after Including taxes is: "+totalAmount);
          }
          public void unitAndFirst(){
                    System.out.println("Enter a three digit number");
                    int number=sc.nextInt();
                    int unitDigit=number%10;
                    int firstDigit=number/100;
                    System.out.println(firstDigit+" "+unitDigit);

          }
          public void sumFractions(){

                    System.out.println("Enter the first double number: ");
                    double num1 = sc.nextDouble();
                    System.out.println("Enter the second double number: ");
                    double num2 = sc.nextDouble();
            
                    // Extract fractional parts
                    double frac1 = num1 - (int)num1;
                    double frac2 = num2 - (int)num2;
            
                    // Sum of fractional parts
                    double sum = frac1 + frac2;
                    System.out.println("The sum is :"+sum);
          }
}