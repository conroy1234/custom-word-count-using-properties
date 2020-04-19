public class RecursionAndLoop {
public static void main(String [] ars) {
	System.out.println(calculateFactorial(23));
}

public static int calculateFactorial(int number) {
    return number == 1 ? 1 : number * calculateFactorial(number - 1);
 }
}

