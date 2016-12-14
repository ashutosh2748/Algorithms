package lcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lcs {
	
	static int counter=0;
	static int counterb=0;
	static Stack<Character> stack=new Stack<Character>();
	static String S1="GAATTCAGTTA";
	static String S2="GGATCGA";
	static int array[][];
	
	public static void main(String[] args){
		int m=S1.length();
		int n=S2.length();
		array=new int[m+1][n+1];
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array[i].length;j++)
				array[i][j]=-1;
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array[i].length;j++)
				{
				array[i][0]=0;
				array[0][j]=0;
				}
		
		
		System.out.println("Lcs bruteforce:");
		System.out.println("Length:"+findlcs(m,n));
		System.out.println("counter:"+counter);
		System.out.println("Lcs Memoised:");

		System.out.println("Length:"+findlcsbetter(m,n));
		
		System.out.println("MeMoised array Trace");
		
		for(int i=0;i<array.length;i++)
			{for(int j=0;j<array[i].length;j++)
				{
				System.out.printf("%d\t",array[i][j]);
			
				}
			System.out.println();
			}
		
		System.out.println();
		
	//	System.out.println(array.toString());
		System.out.println("String Subsequence");
		for(int i=0;i<stack.size();i++)
		System.out.printf("\t%s",stack.pop());
		System.out.println("\ncounter:"+counterb);
		System.out.println(getresult());

		
	}

	private static String getresult() {
		// TODO Auto-generated method stub
		for(int i=array.length-1;i>0;)
			for(int j=array[i].length-1;j>0;)
				{
				if(array[i][j]==array[i-1][j]||array[i][j]==array[i][j-1])
				{
					if(array[i-1][j]>array[i][j-1])i--;
					else j--;
				}
				
					
				else {
					i--;
					j--;
					stack.push(S1.charAt(i));
					
				}
				}
		return stack.toString();
	}

	private static int findlcs(int m, int n) {
		// TODO Auto-generated method stub
		counter++;
		if (n == 0)
				return 0;
				
				else if( m== 0) 
				return 0;
				else if (S1.charAt(m-1) == S2.charAt(n-1)){
					

					return findlcs(m -1, n -1) + 1;

				}
				
				else
				return Math.max(findlcs(m, n -1), findlcs(m -1, n) );
		
				//return null;
	}
	
	
	private static int findlcsbetter(int m, int n) {
		// TODO Auto-generated method stub
		counterb++;
		if (n == 0)
			return 0;
			
			else if( m== 0) 
			return 0;
			else 			 
					if(array[m][n]<0)
				{
				
				if (S1.charAt(m-1) == S2.charAt(n-1)){
					
					
					array[m][n]=findlcsbetter(m-1, n-1) + 1;
					//return res;
				}
				
				else
				{
					array[m][n]=Math.max(findlcsbetter(m, n -1), findlcsbetter(m -1, n) );
					//return res;
					//stack.add('*');
				}
				
				}
		
				 return array[m][n];
		
				//return null;
	}
	
	

}
