package fibonacci;

/*     
 * Output at one typical time 
 
Value of n 50
Starttime in milliseconds 0
Fibonacci brute
12586269025
Brute Counter
40730022147
Time taken by bruteforce 119976
Fibonacci Memoised
12586269025
Memoised Counter
99
Time taken by memoised 1

*/


public class Fibonacci {
	
	static long result[]=new long[500];
	static long counterbrute=0;
	static long counter=0;
	public static void main(String[] args) {
			for(int i=0;i<500;i++)
			result[i]=-1;
		result[0]=0;
		result[1]=1;
		int n=50;
		long starttime=System.currentTimeMillis();	
		System.out.printf("Value of n %d\n",n);
		System.out.printf("Starttime in milliseconds %d",0);
		System.out.print("\nFibonacci brute\n");
		System.out.println(FibonacciBrute(n));
		System.out.print("Brute Counter\n");
		System.out.println(counterbrute);
		long bruteforcetime=System.currentTimeMillis();
		System.out.printf("Time taken by bruteforce %d\n",bruteforcetime-starttime);
		System.out.print("Fibonacci Memoised\n");
		System.out.println(FibonacciMemoised(n));
		long memoisetime=System.currentTimeMillis()-bruteforcetime;
		System.out.print("Memoised Counter\n");
		System.out.println(counter);
		System.out.printf("Time taken by memoised %d",memoisetime);

	}

	private static long FibonacciMemoised(int n) {
		// TODO Auto-generated method stub
		counter++;
		if(result[n]<0){
						if(n==0){
							return 0;
						}
			if(n==1){
				return 1;
				}
			else 
				{
				result[n]= FibonacciMemoised(n-1)+FibonacciMemoised(n-2);
					}
					}
			
		return result[n];
		
	}

	
	private static long FibonacciBrute(int n) {
		counterbrute++;
		if(n==0)return 0;
		if(n==1)return 1;
		else return (FibonacciBrute(n-1)+FibonacciBrute(n-2));
	}
	
	

}