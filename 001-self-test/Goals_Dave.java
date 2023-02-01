import java.util.Scanner;


class Goals_Dave {
    public static void main(String[] args) {
	Scanner getInput = new Scanner(System.in);
	System.out.print("Enter any integer: ");
	int goals = getInput.nextInt();
	System.out.print("Enter an error value: ");
	int errors = getInput.nextInt();

	System.out.println((goals > 10 && errors == 0) ? "Wow" : "Oh well");

	getInput.close();
    }
}
