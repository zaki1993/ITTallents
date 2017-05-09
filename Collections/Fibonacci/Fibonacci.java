import java.util.HashMap;

public class Fibonacci {
	private static HashMap<Integer, Long> fibonacciTable = new HashMap<>();
	
	public static long fibonacci(int n){
			
		if(fibonacciTable.containsKey(n)){
			return fibonacciTable.get(n);
		}
		
		fibonacciTable.put(n, findFibonacci(n));
		return fibonacciTable.get(n);
	}
	
	
	private static long findFibonacci(int n){
		
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
