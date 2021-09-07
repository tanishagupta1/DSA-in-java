import java.util.ArrayList;
import java.util.Scanner;

//Question is if a person is standing on nth stair and can only take 1,2,3 steps to come down
public class getstairspath {

    static ArrayList<String> getways(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
        }
        if (n < 0) {
            return res;
        }

        ArrayList<String> path1 = getways(n - 1);
        ArrayList<String> path2 = getways(n - 2);
        ArrayList<String> path3 = getways(n - 3);

        for (String s : path1) {
            res.add("1" + s);
        }
        for (String s : path2) {
            res.add("2" + s);
        }
        for (String s : path3) {
            res.add("3" + s);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> answer = new ArrayList<>();
        answer = getways(n);
        System.out.println(answer);
        sc.close();
    }
}
