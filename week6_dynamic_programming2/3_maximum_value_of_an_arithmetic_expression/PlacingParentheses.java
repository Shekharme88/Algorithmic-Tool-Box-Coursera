import java.util.Scanner;

public class PlacingParentheses {
	static long m[][],M[][];static int d[];static char op[];
	
	public static void MinandMax(int i,int j)
	{
		long min=Long.MAX_VALUE;
		long max=Long.MIN_VALUE;
		for(int k=i;k<j;k++)
		{
			long a=eval(M[i][k],M[k+1][j],op[k]);
			long b=eval(M[i][k],m[k+1][j],op[k]);
			long c=eval(m[i][k],M[k+1][j],op[k]);
			long e=eval(m[i][k],m[k+1][j],op[k]);

			min=Math.min(min,Math.min(a,Math.min(b,Math.min(c,e))));
			max=Math.max(max,Math.max(a,Math.max(b,Math.max(c,e))));
		}
		m[i][j]=min;
	    M[i][j]=max;
		
	}
	/*static void display(long M[][])
	{
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=6;j++)
				System.out.print(M[i][j]+" ");
			System.out.println();
		}
		
	}*/
    public static long getMaximValue(String exp) {
	  d=new int[(exp.length()+1)/2+1];
	  op=new char[(exp.length()-1)/2+1];
	  int c1=0,c2=0;
      for(int i=0;i<exp.length();i++)
	  {
		  if(i%2==0)
			  d[++c1]=Integer.parseInt(String.valueOf(exp.charAt(i)));
		  else
			  op[++c2]=exp.charAt(i);
	  }
	  m=new long[c1+1][c1+1];
	  M=new long[c1+1][c1+1];
	  for(int i=1;i<=c1;i++)
	  {
		  m[i][i]=d[i];
		  M[i][i]=d[i];
	  }
	  for(int s=1;s<c1;s++)
	  {
		  for(int i=1;i<=c1-s;i++)
		  {
			  int j=i+s;
			  MinandMax(i,j);
		  }
	  }
		 //display(M); 
      return M[1][c1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

