import java.util.*;

public class FibonacciSumLastDigit {
    private static int getFibonacciSumNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;
        int sum      = 1;

        for (int i = 0; i < n - 1; ++i) {
			current=current%10;
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
			
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

