import java.util.*;

public class DotProduct {
	static int partition(int a[], int low, int high) 
    { 
        int pivot = a[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (a[j] < pivot) 
            { 
                i++; 
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        } 
        int temp = a[i+1]; 
        a[i+1] = a[high]; 
        a[high] = temp; 
		return i+1; 
    } 
    static void sort1(int b[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition1(b, low, high); 
            sort1(b, low, pi-1); 
            sort1(b, pi+1, high); 
        } 
		
    } 
	static int partition1(int b[], int low, int high) 
    { 
        int pivot = b[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (b[j] < pivot) 
            { 
                i++; 
                int temp = b[i]; 
                b[i] = b[j]; 
                b[j] = temp; 
            } 
        } 
        int temp = b[i+1]; 
        b[i+1] = b[high]; 
        b[high] = temp; 
		return i+1; 
    } 
    static void sort(int a[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(a, low, high); 
            sort(a, low, pi-1); 
            sort(a, pi+1, high); 
        } 
		
    } 
    private static long maxDotProduct(int[] a, int[] b) 
	{
        sort(a,0,a.length-1);
		sort1(b,0,b.length-1);
		int i=0;
		
        long result = 0;int pos=0;
        for (i = a.length-1; i>=0; i--) 
	    {
			
			
			
            result +=a[i]*b[i];
			
        }
		
        return result;
    }
	

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

