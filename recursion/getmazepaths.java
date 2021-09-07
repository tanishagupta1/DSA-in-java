import java.util.ArrayList;
import java.util.Scanner;

public class getmazepaths {

    static ArrayList<String> getmazepath(int srow, int scolumn, int drow, int dcolumn) {
        //here srow and scloumn are for source and drow and dcolumn are for destination 
        
        
        if (scolumn==dcolumn && srow==drow) {
            ArrayList<String> bres = new ArrayList<>();
             bres.add("");
             return bres;
        }
        ArrayList<String> vpaths =new ArrayList<>();
        ArrayList<String> hpaths = new ArrayList<>();
        //we cannot move horizaontally if we are in last column
        if(scolumn<dcolumn){
           hpaths=getmazepath(srow, scolumn + 1, drow, dcolumn);
        }
        //we cannot move vertically if we are in last row
        if(srow<drow){
             vpaths=getmazepath(srow + 1, scolumn, drow, dcolumn);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String string : vpaths) {
            res.add("v" + string);
        }
        for (String string : hpaths) {
            res.add("h" + string);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        System.out.println(getmazepath(sr, sc,dr,dc));
        scn.close();
    }
}
