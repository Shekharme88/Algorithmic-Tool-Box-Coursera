import java.util.Scanner;

public class Fibonacci {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
     if (n <= 1)
      System.out.println(n);
else{
    long prev=0,curr=1,fib=0;
    for(int i=2;i<=n;i++)
    {
       fib=prev+curr;
       prev=curr;
       curr=fib;

    }

    System.out.println(fib);
}
  }
}
