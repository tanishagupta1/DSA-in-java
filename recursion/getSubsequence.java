import java.util.ArrayList;
import java.util.Scanner;


public class getSubsequence {
    // subsequence for abc = ---, --c,-b-,-bc,a--,ab-, a-c,abc
    // Expectation : the String bc will give subsequence ---, --c,-b-,-bc
    // Faith : This will help to find subsequence for abc
    // Faith+ Expectation = gss(bc) + a +gss(bc)
    static ArrayList<String> gss(String s) {
        if (s.length()==0) {
            ArrayList<String> baseresult = new ArrayList<>();
            baseresult.add("");
            return baseresult;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> res = gss(ros);
        ArrayList<String> myres = new ArrayList<>();
        for (String string : res) {
            myres.add("" + string);
        }
        for (String string : res) {
            myres.add(ch + string);
        }
        return myres;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> finalres = gss(str);
        System.out.println(finalres);
        sc.close();
    }
}
