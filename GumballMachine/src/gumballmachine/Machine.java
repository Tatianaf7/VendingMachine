package gumballmachine;

import java.util.Scanner;

public class Machine {

	public static void main(String[] args) {
		
		//Create two vending machines.
		GumballMachine gmachine = new Machine(). new GumballMachine();
		SodaMachine smachine = new Machine(). new SodaMachine();
		
		Scanner input = new Scanner(System.in);
		
		
		int intUserInput = 0;
		String strUserInput = null;
		
		//Create menu.
		do {
			System.out.println("1. Use Gumball Machine: ");
			System.out.println("2. Use Soda Machine: ");
			System.out.println("3. Exit");
			strUserInput = input.nextLine();
			try {
				intUserInput = Integer.parseInt(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("You must enter a integer number!");
			}
			
		
		
			switch (intUserInput){
			case 1:
				//Create menu to use GumBall Machine.
				while(true) {
					System.out.print("(V)end, (R)efill or (E)xit: ");
					String choice = input.nextLine();
					
					if (choice.toLowerCase().equals("v")) {
					System.out.println(gmachine.Dispense());
				}
					else if (choice.toLowerCase().equals("r")) {
						System.out.print("Enter amount to refill: ");
						int amount = input.nextInt();
						input.nextLine();
						gmachine.refill(amount);
						System.out.println("Refilled...");
					}
					else if (choice.toLowerCase().equals("e")) {
						break;
					}
					else {
						System.out.println("Invalid Choice");
				}
				}
				break;
			case 2:
				//Create menu to use Soda Machine.
				while(true) {
					System.out.print("(V)end, (R)efill or (E)xit: ");
					String choice = input.nextLine();
					
					if (choice.toLowerCase().equals("v")) {
					System.out.println(smachine.Dispense());
				}
					else if (choice.toLowerCase().equals("r")) {
						System.out.print("Enter amount to refill: ");
						int amount = input.nextInt();
						input.nextLine();
						smachine.refill(amount);
						System.out.println("Refilled...");
					}
					else if (choice.toLowerCase().equals("e")) {
						break;
					}
					else {
						System.out.println("Invalid Choice");
				}
			} 
		
				break;
				
			case 3:
				System.out.println("Thank you for using the Vending Machine!");
				input.close();
				break;
			default:
				System.out.println("Invalid menu option entered. Try again.");
		}
	} while (intUserInput != 3);
		
}
		
		
		
		
		
		
		
		


interface VendingMachine {
	void refill(int count);
	String Dispense();
	boolean isEmpty();
}


//Create GumballMachine class.
class GumballMachine implements VendingMachine 

{
	int productCount = 0;
	
	public void refill(int count) {
		productCount += count;
	}

	@Override
	public String Dispense() {
		if (productCount == 0)
			return "Machine is empty, no product dispensed";
		productCount --;
		String color = "";
		switch ((int) (Math.random() * 4)) {
		case 0: color = "Red"; break;
		case 1: color = "Yellow"; break;
		case 2: color = "Orange"; break;
		case 3: color = "Green"; break;
		}
		return color + " gumball!";
	}
	
	
	
	public boolean isEmpty() {
		return productCount == 0;
	}
}

//Create SodaMachine class.
class SodaMachine implements VendingMachine 

	{
		int productCount = 0;
		
		public void refill(int count) {
			productCount += count;
		}

		@Override
		public String Dispense() {
			if (productCount == 0)
				return "Machine is empty, no product dispensed";
			productCount --;
			String soda = "";
			switch ((int) (Math.random() * 4)) {
			case 0: soda = "Grape"; break;
			case 1: soda = "Cherry"; break;
			case 2: soda = "Orange"; break;
			case 3: soda = "Watermelon"; break;
			}
			return soda + " soda!";
		}
		
		
		
		public boolean isEmpty() {
			return productCount == 0;
		}

		
	}}
