public class CollatzFunction {
	static int calls = 0;
	static int n;

	public static void main(String[] args) {
		CollatzFunction ob = new CollatzFunction();
	//int base = printNumber(1);
	System.out.println(calculateFactorial(1));
	}
	
	 public static int calculateFactorial(int number) {
		 if(number <=100) {
				System.out.println(number+ " ");					
				calculateFactorial(number+1);			
			}
		 if (number % 2 != 0) {
			 number = 3 + 1;
				System.out.println(" add " + n);
			} else {
				number = number / 2;
				System.out.println(" add " + n);
			}
	        return number % 2 != 0 ? 1 : number  + calculateFactorial(number +1);
	    }
	
	
	
	public static int printNumber(int number) {
		
		if(number <=100) {
			System.out.println(number+ " ");					
			printNumber(number+1);			
		}
		return number;	
		
		
	}
	public static int num(int num) {
		if(num >0 ) {
			System.out.println(num);
			num=num(num--);
		}
		return num;
	}
	public static int collatza(Integer n) {
		int x = 0;
		if (n > 1) {
			num(n);
			System.out.println(num(n));
			if (n % 2 != 0) {
				n = 3 + 1;
				System.out.println(" add " + n);
			} else {
				n = n / 2;
			}
			System.out.println(" even  "+n);
			x++;
		}
		return n;

	}
	
	
	
	public static int x(int n) {
		if (n % 2 == 0) {
			
			n = n / 2;
			System.out.println(" add " + n);
		} else {
			n = 3 + 1;
			System.out.println(n);
		}
		
		return n;
	}
	
	
	
	
	public static int collatz(Integer n) {
		int x = 0;
		while (n > 1) {
			System.out.println(n);
			if (n % 2 != 0) {
				n = 3 + 1;
				System.out.println(" add " + n);
			} else {
				n = n / 2;
			}
			System.out.println(" even  "+n);
			x++;
		}
		return n;

	}

	public static int getRecursiveResults(int n) {
		int result = count(n);
		// System.out.println(result);
		if (result == 5) {
			System.out.println(" the result is 5");
		}
		return result;
	}

	public static int count(int x) {
		int n=0;
		if (x % 2 != 0) {
			
			n= count(3 + 1);
		} else {
			n= count(x / 2);
			
		}
		return count(n- 1);
	}
	
	public static int countAdd(Integer n) {
		
		if (n % 2 != 0) {
			n = 3 + 1;
			if (n <= 0) {
				System.exit(0);
			}
		} else {
			return n / 2;
		}
		return count(n - 1);
	}


}
