import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<String> namesList = new ArrayList<>();
	ArrayList<String> flavoursList = new ArrayList<>();
	ArrayList<Integer> quantitiesList = new ArrayList<>();
	ArrayList<String> idList = new ArrayList<>();
	ArrayList<Integer> subtotalList = new ArrayList<>();
	
	public Main() {
		Integer chosenNumber = 0;
		
		do {
			printGreetings();
			chosenNumber = chooseNumber();
			
			if(chosenNumber == 1) {
				menu1();
			}else if(chosenNumber == 2) {
				menu2();
			}else if(chosenNumber == 3) {
				menu3();
			}
		}while(chosenNumber != 4);
		
		System.out.println("\nGoodbye!");
	}
	
	void printGreetings() {
		System.out.println("Creamy Dream");
		System.out.println("================");
		System.out.println("1. Add new Ice Cream to Cart");
		System.out.println("2. Checkout Cart");
		System.out.println("3. View Cart");
		System.out.println("4. Exit");
	}
	
	Integer chooseNumber() {
		int choose = 0;
		
		System.out.print(">> ");
		choose = scan.nextInt();
		scan.nextLine();
		
		return choose;
	}
	
	void menu1() {
		String name = "";
		
		do {
			System.out.print("Enter the ice cream's name [4-25 alphabet]: ");
			name = scan.nextLine();
		}while(name.length() < 4 || name.length() > 25);
		
		String flavour = "";
		
		do {
			System.out.print("Enter the flavour's name [Chocolate | Vanilla | Strawberry] [case sensitive]: ");
			flavour = scan.nextLine();
		}while(!flavour.equals("Chocolate") && !flavour.equals("Vanilla") && !flavour.equals("Strawberry"));
		
		int quantity = 0;
		
		do {
			System.out.print("Enter the quantity [> 0]: ");
			quantity = scan.nextInt();
			scan.nextLine();
		}while(quantity <= 0);
		
		System.out.println();
		
		String alphabet = String.valueOf(name.charAt(0)) + String.valueOf(name.charAt(1));
		String x = alphabet.toUpperCase();
		
		Random randomNumber = new Random();
		
		int number1 = randomNumber.nextInt(10);
		String y1 = String.valueOf(number1);
		
		int number2 = randomNumber.nextInt(10);
		String y2 = String.valueOf(number2);
		
		String randoIdNumber = x + "-" + y1 + y2;
		
		namesList.add(name);
		flavoursList.add(flavour);
		quantitiesList.add(quantity);
		idList.add(randoIdNumber);
	}
	
	void menu2() {
		if(namesList.isEmpty()) {
			System.out.println("No Ice cream added yet...\nPress Enter to continue...");
			scan.nextLine();
		}else {
			int subtotal = 0;
			int total = 0;
			
			for(int i = 0; i < namesList.size(); i++) {
				if(flavoursList.get(i).equals("Chocolate")) {
					subtotal = quantitiesList.get(i) * 5;
				}else if(flavoursList.get(i).equals("Strawberry")) {
					subtotal = quantitiesList.get(i) * 7;
				}else if(flavoursList.get(i).equals("Vanilla")) {
					subtotal = quantitiesList.get(i) * 10;
				}
				
				subtotalList.add(subtotal);
				total += subtotal;
			}
			System.out.println("\nInvoice");
			System.out.println("=======");
			
			for(int i = 0; i < namesList.size(); i++) {
				System.out.println("ID: " + idList.get(i));
				System.out.println("Name: " + namesList.get(i));
				System.out.println("Flavour: " + flavoursList.get(i));
				System.out.println("Quantity: " + quantitiesList.get(i));
				
				if(flavoursList.get(i).equals("Chocolate")) {
					System.out.println("Price: $5");
				}else if(flavoursList.get(i).equals("Strawberry")) {
					System.out.println("Price: $7");
				}else if(flavoursList.get(i).equals("Vanilla")) {
					System.out.println("Price: $10");
				}
				
				System.out.println("Subtotal: $" + subtotalList.get(i));
				System.out.println("=================================");
			}
			
			System.out.println("Total Price: $" + total + "\n");
			
			int payment = 0;
			
			do {
				System.out.print("Input your payment: $");
				payment = scan.nextInt();
				scan.nextLine();
			}while(payment < total);
			
			int change = payment - total;
			
			System.out.println("Your change is: $" + change);
			System.out.println("Thank you for your purchase we hope to see you next time!\n");
			
			idList.clear();
			namesList.clear();
			flavoursList.clear();
			quantitiesList.clear();
		}
	}
	
	void menu3() {
		if(namesList.isEmpty()) {
			System.out.println("\nNo Ice cream added yet...\nPress enter to continue...\n");
			scan.nextLine();
		}else {
			for(int i = 0; i < namesList.size() - 1; i++) {
				for (int j = 0; j < namesList.size() - i - 1; j++) {
					if(quantitiesList.get(j).compareTo(quantitiesList.get(j + 1)) < 0) {
						Collections.swap(idList, j, j + 1);
						Collections.swap(namesList, j, j + 1);
						Collections.swap(flavoursList, j, j + 1);
						Collections.swap(quantitiesList, j, j + 1);
					}
				}
			}
		
		
			System.out.println("|ID        |Name                     |Flavour        |Quantity  |");
			
			for(int i = 0; i < namesList.size(); i++) {
				System.out.printf("|%-10s" + "|%-25s" + "|%-15s" + "|%-10d|\n", idList.get(i), namesList.get(i), flavoursList.get(i), quantitiesList.get(i));
			}
			
			System.out.println("\nPress Enter to continue...\n");
		}
	}
	

	public static void main(String[] args) {
		new Main();
	}

}
