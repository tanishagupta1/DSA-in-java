import java.util.Scanner;

public class encodings {
    // asf means answer so far
    // Question : 1->a
    // 2->b
    // 3->c
    // for ex: 123 are decoded as abc, lc,aw
    static void printencodings(String s, String asf) {
        if (s.length() == 0) {
            System.out.println(asf);
            return;
        } else if (s.length() == 1) {
            char ch = s.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chn = ch - '0';
                char charcode = (char) ('a' + chn - 1); // for ex to get i (105) 97 + 9 -1
                System.out.println(asf + charcode);
            }
        }
        // For strings with length greater than or equal to two
        else {
            char ch = s.charAt(0);
            String ros = s.substring(1);
            // For the case when 1st charater is selected example: in 12345 1 is selected
            if (ch == '0') {
                return;
            } else {
                int chn = ch - '0';
                char charcode = (char) ('a' + chn - 1);
                printencodings(ros, asf + charcode);
            }
            // For the case when first two characters are selected example: in 12345 12 is
            // selected
            String firsttwochar = s.substring(0, 2); // 12
            String reststring = s.substring(2); // 345
            int chft = Integer.parseInt(firsttwochar);
            if (chft == '0') {
                return;
            } else {
                if(chft<=26){
                char charcode = (char) ('a' + chft - 1); // for ex to get i (105) 97 + 9 -1
                printencodings(reststring, asf + charcode);
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printencodings(str,"");
        scn.close();
    }
}
