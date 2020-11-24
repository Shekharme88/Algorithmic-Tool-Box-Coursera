import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
		int numc=0;
        int minnumcoins[]=new int[m+1];
		minnumcoins[0]=0;
		int coins[]={0,1,3,4};
		for(int n=1;n<=m;n++)
		{
			minnumcoins[n]=Integer.MAX_VALUE;
			for(int i=1;i<=3;i++)
			{
				if(n>=coins[i])
				{
					numc=minnumcoins[n-coins[i]]+1;
					if(numc<minnumcoins[n])
						minnumcoins[n]=numc;
				}
			}
		}
        return minnumcoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

