
public class regex {
    public static void main(String[] args) {
        String s = "Au@su%keS^h";
        System.out.println(s.replace("[@%^]", ""));
       // System.out.println(s.replaceAll("[^a-zA-Z]", ""));
    }
}