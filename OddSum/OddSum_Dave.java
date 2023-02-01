import java.util.Scanner;

class OddSum_Dave {
    public static void main(String[] args) {
	Scanner getInput = new Scanner(System.in);
	System.out.print("Enter a number: ");
	int number = getInput.nextInt();
	int total = 0;

	for (int x = 0; x < number; x++) {
	    if (x % 2 != 0) {
		total += x;
	    }
	}

	System.out.printf("The sum of positive odd numbers less than %d is %d.\n", number, total);
    }
}
