import java.util.*;

public class LCM {
  private static long gcd(long a, long b) {
   if(a%b==0||b==0)
    return b;
else return  gcd(b,a%b);
    
    
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();
long gc=0,lcm=0;
    if(a>b)
    gc=gcd(a, b);
    else
    gc=gcd(b,a);
lcm=a*(b/gc);
System.out.println(lcm);
  }
}
