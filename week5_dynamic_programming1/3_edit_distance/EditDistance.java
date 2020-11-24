import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
	  
    int n=s.length();int m=t.length();
	s=" "+s;t=" "+t;
	int d[][]=new int[n+1][m+1];
	for(int i=0;i<=n;i++)
		d[i][0]=i;
	for(int i=0;i<=m;i++)
		d[0][i]=i;
	int ins,del,mat,mismat=0;
	for(int j=1;j<=m;j++)
	{
		for(int i=1;i<=n;i++)
		{
			ins=d[i][j-1]+1;
			del=d[i-1][j]+1;
			mat=d[i-1][j-1];
			mismat=d[i-1][j-1]+1;
			if(s.charAt(i)==t.charAt(j))
				d[i][j]=Math.min(Math.min(ins,del),mat);
			else
				d[i][j]=Math.min(Math.min(ins,del),mismat);
		}
	}
    return d[n][m];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
