import java.util.HashMap;

public class Demo {
	public static void main(String[] args) {
		System.out.println(Fibonacci.fibonacci(223)); // ok, finish instantly
		System.out.println(Fibonacci.fibonacci(224)); // overflow long, finish instantly
		System.out.println(Fibonacci.fibonacci(1000)); // overflow long, finish instantly
		System.out.println(Fibonacci.fibonacci(5000)); // overflow long, finish instantly
		// still not stack overflow
		
		//long start = System.currentTimeMillis();
		
		
		//System.out.println(recursiveFibonacci(30)); // finish, 5.562 seconds :(
		//System.out.println(recursiveFibonacci(31)); // finish, 9.068 seconds :(
		//System.out.println(recursiveFibonacci(32)); // finish, 16.035 seconds :(
		
		
		//long end = System.currentTimeMillis();
		//System.out.println((end - start));
	}
	
	public static long recursiveFibonacci(int n){
		
		System.out.println("enter: " + n);
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}
}
