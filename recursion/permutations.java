import java.util.Scanner;

public class permutations {
    static void printpermutations(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String lpart = ques.substring(0, i);
            String rpart = ques.substring(i + 1);
            String restofstring = lpart + rpart;
            printpermutations(restofstring, asf + ch);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String str = sc.next();
        System.out.println("The permutations of "+str +" are: ");
        printpermutations(str, "");
        sc.close();
    }
}
