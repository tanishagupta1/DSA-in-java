import java.util.ArrayList;
import java.util.Scanner;

public class keypadwordscombination {

    static String[] codes = { ",:", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> result = gkp(s);
        System.out.println(result);
        System.out.println(result.size());
        sc.close();
    }
    // for example str is 687 corresponding to pqrs,vwx,tu respectively
    // 6 in first call
    // 87 in first call vwx,tu
    // ArrayList for storing ans from substring -sres
    // [vt,vu,wt,wu,xt,xu] for 87
    // adding the character p,q,r,s individually to all the mentioned result will
    // give the answer
    // for storing the final result : myres

    static ArrayList<String> gkp(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseres = new ArrayList<>();
            baseres.add("");
            return baseres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> sres = gkp(ros);
        // ch - '0' gives a integer after converting the character
        String wordsforch = codes[ch - '0'];

        ArrayList<String> myres = new ArrayList<>();
        for (String i : sres) {
            for (int j = 0; j < wordsforch.length(); j++) {
                char charincodes = wordsforch.charAt(j);
                myres.add(i + charincodes);
            }
        }
        return myres;
    }
}
