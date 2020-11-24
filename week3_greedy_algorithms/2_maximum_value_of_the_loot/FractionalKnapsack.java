import java.util.Scanner;
import java.text.*;
public class FractionalKnapsack {
	static int values[],weights[];static double vw[];
	
	static int partition(double vw[], int low, int high) 
    { 
        double pivot = vw[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (vw[j] < pivot) 
            { 
                i++; 
                double temp = vw[i]; 
                vw[i] = vw[j]; 
                vw[j] = temp; 
				int t = values[i]; 
                values[i] = values[j]; 
                values[j] = t;
				 t = weights[i]; 
                weights[i] = weights[j]; 
                weights[j] = t;
            } 
        } 
        double temp = vw[i+1]; 
        vw[i+1] = vw[high]; 
        vw[high] = temp; 
		int t = values[i+1]; 
        values[i+1] = values[high]; 
        values[high] = t;
		t = weights[i+1]; 
        weights[i+1] = weights[high]; 
        weights[high] = t;
		return i+1; 
    } 
    static void sort(double vw[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(vw, low, high); 
            sort(vw, low, pi-1); 
            sort(vw, pi+1, high); 
        } 
    } 
	
	
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
		
		int a[]=new int[vw.length];
		int v=0;
		for(int i=vw.length-1;i>=0;i--)
		{
			if(capacity==0)
				break;
			int f=Math.min(weights[i],capacity);
			value+=f*vw[i];
			weights[i]-=f;
			capacity-=f;
			
		}
        
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        values = new int[n];
        weights= new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
		
		vw=new double[values.length];
		
		for(int i=0;i<values.length;i++)
			vw[i]=(double)values[i]/(double)weights[i];
		  sort(vw,0,vw.length-1);
		  
		 DecimalFormat d=new DecimalFormat("#.####");
		 double z=Double.valueOf(d.format(getOptimalValue(capacity, values, weights)));
        System.out.println(z);
    }
} 
