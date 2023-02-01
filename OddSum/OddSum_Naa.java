import java.util.Scanner;

class OddSum_Naa {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter any number: ");
	int number = input.nextInt();
	int i, sum = 0;

	for (i = 0; i < number; i++) {
	    if (i % 2 != 0) {
		sum = sum + i;
	    }
	}

	System.out.println("Sum of all odd numbers between 0 to " + number + " is equal to " + sum);
	input.close();
    }
}
