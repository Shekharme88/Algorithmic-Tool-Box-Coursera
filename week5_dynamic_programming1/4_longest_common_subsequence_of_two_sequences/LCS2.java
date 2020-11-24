import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
		int n=a.length;int m=b.length;
	int pos=0,count=0,cnt=0;
	int d[][]=new int[n][m];
	/*for(int i=0;i<n;i++)
		d[i][0]=i;
	for(int i=0;i<m;i++)
		d[0][i]=i;
	int ins,del,mat,mismat=0;
	for(int j=1;j<m;j++)
	{
		for(int i=1;i<n;i++)
		{
			ins=d[i][j-1]+1;
			del=d[i-1][j]+1;
			mat=d[i-1][j-1];
			mismat=d[i-1][j-1]+1;
			if(a[i]==b[j])
			{
				d[i][j]=Math.min(Math.min(ins,del),mat);
				
				if(i>pos)
				{
					cnt++;
					if(cnt==1)
					 pos=i;
				}
				

			}
			else
				d[i][j]=Math.min(Math.min(ins,del),mismat);
		}
		if(cnt>0)
		{
			count++;
			cnt=0;
		}
		
	} return count;*/
for(int j=0;j<m;j++)
	{
		for(int i=0;i<n;i++)
		{
			if (i == 0 || j == 0)
				d[i][j] = 0;

			else if (a[i - 1] == b[j - 1])
				d[i][j] = d[i - 1][j - 1] + 1;

			else
				d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
		}
	}
	return d[n-1][m-1];
		
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		//for(int z=0;z<10;z++){
        int n = scanner.nextInt();
		//int n=4;
        int[] a = new int[n+1];
		//int a[]={0,0,1,3,5};
        for (int i = 1; i <=n; i++) {
            a[i] = scanner.nextInt();
		   //a[i]=(int)(Math.random()*10)%6;
		   //System.out.print(a[i]+" ");
        }
		//System.out.println();
		a[0]=0;
        int m = scanner.nextInt();
		//int m=3;
        int[] b = new int[m+1];
		//int b[]={0,5,3,5};
        for (int i = 1; i <=m; i++) {
            b[i] = scanner.nextInt();
			//b[i]=(int)(Math.random()*10)%6;
			//System.out.print(b[i]+" ");
        }
		//System.out.println();
		b[0]=0;
        int x=lcs2(a, b); int y=lcs2(b,a);
		if(x==y)
        System.out.println(x);
		else
		{
			System.out.println(Math.max(x,y));
		}
		//}
    }
	
}

