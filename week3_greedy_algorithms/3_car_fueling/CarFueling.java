import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
		int numr=0,curr=0;
		while(curr<=stops.length-2)
		{
			int lastr=curr;
			while(curr<=stops.length-2&&stops[curr+1]-stops[lastr]<=tank)
			{
				curr+=1;
			}
			if(curr==lastr)
				return -1;
			if(curr<=stops.length-2)
				numr+=1;
		}
        return numr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
		stops[0]=0;stops[n+1]=dist;
        for (int i = 1; i <=n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
