import java.util.Scanner;
import java.util.Vector;

public class Seating {

    public static void ReadInput(){
        Scanner in = new Scanner(System.in);
        String[] info = in.nextLine().split(" ");
        int numTables = Integer.parseInt(info[0]);
        int numPeople = Integer.parseInt(info[1]);
        int[] tables = new int[numTables];
        for(int i = 0; i < numTables; i++)
            tables[i] = in.nextInt();
        System.out.print(Solve(tables, numTables, numPeople));
    }

    static int Solve(int[] tables, int numTables, int numPeople){
        int min = tables[numTables-1] - tables[0];
        int[] set = new int[min];
        for(int i=0; i<set.length; i++) {
            set[i] = i + 1;
        }
        int left = 0;
        int right = min - 1;

        int max = 0;
        while(left <= right) {
            int dist = set[(right + left) / 2];
            int placed = 0;
            int current = tables[0];
            for(int i=0; i<tables.length; i++) {
                if(tables[i] - current >= dist) {
                    current = tables[i];
                    placed++;
                    if(placed == numPeople - 1)
                        break;
                }
            }
            if(placed == numPeople - 1) {
                max = Math.max(dist, max);
                left = ((right + left) / 2) + 1;
            }
            else {
                right = ((right + left) / 2) - 1;
            }
        }
        return max;
    }

    public static void main(String[] args){
        ReadInput();
    }
}