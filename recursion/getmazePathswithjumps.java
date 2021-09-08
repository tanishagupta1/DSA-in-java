import java.util.Scanner;

public class getmazePathswithjumps {
    static void getmazepathwithjumps(int sr,int sc,int dr,int dc,String sf,int count){
        if(sc==dc && sr==dr){
            System.out.println(sf);
            System.err.println(count+1);
            return;
        }
        
        //There are many options as the number of jumps differ at every sequence i.e the source changes 
        //Horizontal move
        for(int step=1;step<=dc-sc;step++){
        getmazepathwithjumps(sr, sc+step, dr, dc, sf+"h"+step,count++);
        }
        //Horizontal move
        for(int step=1;step<=dr-sr;step++){
            // sf+"v"+step this is a string
        getmazepathwithjumps(sr+step, sc, dr, dc, sf+"v"+step,count++);
        }
        //Diagonal move
        //Condition for both, horizontal and vertical will be checked
        // for ex: standing at 2,3 you can move only two steps either vertically or horizontally to reaxh 4,4
        for(int step=1;step<=dc-sc && step<=dr-sr;step++){
        getmazepathwithjumps(sr+step, sc+step, dr, dc, sf+"d"+step,count++);
        }

    
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        int dc=scn.nextInt();
        int dr=scn.nextInt();
       getmazepathwithjumps(1, 1, dr, dc, "",0);
        scn.close();
    }
}
