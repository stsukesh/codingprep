import java.util.Scanner;

public class WashingMachineFuzzy {
    public static void main(String[] args) {
        Scanner vangu = new Scanner(System.in);
        System.out.println("Enter the weight to be loaded:");
        int weight = vangu.nextInt();
        System.out.println("Enter the water level (L, M, H):");
        char waterlevel = vangu.next().charAt(0);
        waterlevel = Character.toUpperCase(waterlevel);

        if (weight < 0) {
            System.out.println("INVALID INPUT");
        } else if (weight == 0) {
            System.out.println("Time Estimated is 0 minutes");
        } else if (weight > 7000) {
            System.out.println("OVERLOADED");
        } else {
            switch (waterlevel) {
                case 'L':
                    if (weight > 0 && weight <= 2000) {
                        System.out.println("Time Estimated: 25 minutes");
                    } else {
                        System.out.println("INVALID INPUT");
                    }
                    break;
                case 'M':
                    if (weight > 2000 && weight <= 4000) {
                        System.out.println("Time Estimated: 35 minutes");
                    } else {
                        System.out.println("INVALID INPUT");
                    }
                    break;
                case 'H':
                    if (weight > 4000 && weight <= 7000) {
                        System.out.println("Time Estimated: 45 minutes");
                    } else {
                        System.out.println("INVALID INPUT");
                    }
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }

        vangu.close();
    }
}