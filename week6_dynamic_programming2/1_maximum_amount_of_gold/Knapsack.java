import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int value[][]=new int[W+1][w.length];
		for(int i=0;i<w.length;i++)
			value[0][i]=0;
		for(int i=0;i<W+1;i++)
			value[i][0]=0;
		for(int i=1;i<w.length;i++)
		{
			for(int j=1;j<=W;j++)
			{
				value[j][i]=value[j][i-1];
				if(w[i]<=j)
				{
					int val=value[j-w[i]][i-1]+w[i];
					if(value[j][i]<val)
						value[j][i]=val;
				}
			}
		}
		return value[W][w.length-1];
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n+1];
		w[0]=0;
        for (int i = 1; i < n+1; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

