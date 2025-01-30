/*  Coding questions 
1.Imagine you‟re on a quest to discover never-ending loops. Create a program that 
demonstrates two types of endless journeys: one using a for loop and another using a 
while loop. How will you set up these loops to keep running forever, showcasing their 
infinite nature?*/

public class infiniteloop {
    public static void main(String[] args) {
infiniteWhileLoop();
        infiniteWhileLoop();

    }
    public static void infiniteForLoop() {
        for (;;) {
            System.out.println("For loop is running...");

        }
    }

    public static void infiniteWhileLoop() {
        while (true) {
            System.out.println("While loop is running...");
        }
    }
}
//you can use "ctrl+c" in the terminal to terminate the loop