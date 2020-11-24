import java.util.*;
public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;
		if(n==2)
			return (numbers[0]*numbers[1]);
	    long l=-1,sl=-1;

        for (int first = 0; first < n; ++first) {

            if(numbers[first]>=l)
			{
				sl=l;
				l=numbers[first];
			}
			else if(numbers[first]>=sl)
				sl=numbers[first];
        }
		max_product=l*sl;
        return max_product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }
}
    
