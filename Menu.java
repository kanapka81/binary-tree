
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author blazejbyczkowski
 *
 */

public class Menu {

	public Menu() {

	}

	/**
	*	Displays a menu
	*/
	public void displayMenu() {
		System.out.println("1. Run automated test");
		System.out.println("2. Add student to the tree");
		System.out.println("3. Print tree in numerical order");
		System.out.println("4. Look for student's mark");
		System.out.println("5. Delete a student from the tree");
	}

	/**
	*	Takes input from the user and calls appropriate methods
	*/
	public void processUserChoice() {
		int wyjscie = -1;
		Tree binarytree = new Tree();
		displayMenu();
		int input = 0;
		do {
			Scanner s3 = new Scanner(System.in);
			Scanner s4 = new Scanner(System.in);
			
			try {
				System.out.println("Enter number to choose method:");
				input = s4.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input!");
				break;
			}

			switch (input) {
			case 1:
				test();
				break;
			case 2:

				try {
					System.out.println("Enter student name:");
					String name;
					name = s3.nextLine();
					System.out.println("Enter student mark:");
					int mark = Integer.parseInt(s3.nextLine());
					System.out.println("Enter student id:");
					int id = Integer.parseInt(s3.nextLine());
					binarytree.addToTree(name, mark, id);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input!");
					
				}
				break;
			case 3:
				binarytree.traverseInOrder(binarytree.getRoot());
				break;
			case 4:
				try {
					System.out.println("Enter student id:");
					int id = Integer.parseInt(s3.nextLine());
					binarytree.searchFor(id);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input!");
					
				}
				break;
			case 5:
				try {
					System.out.println("Enter student's id you would like to delete from the tree:");
					int id = Integer.parseInt(s3.nextLine());
					binarytree.deleteFromTree(id);
				} catch (NumberFormatException e) {
					System.out.println("Invalid input!");
					
				}
				break;
			case -1:
				wyjscie++;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}

		} while (wyjscie != 0);
	}

	/**
	*	Automated binary tree test
	*/
	public void test() {
		Tree binarytree = new Tree();

		System.out.println("Empty tree!");

		binarytree.addToTree("maniek", 2, 5);
		binarytree.addToTree("alek", 1, 2);
		binarytree.addToTree("fraiek", 3, 4);
		binarytree.addToTree("ezkiek", 6, 9);
		binarytree.addToTree("maniura", 51, 6);
		binarytree.addToTree("mandasdk", 2, 7);

		binarytree.traverseInOrder(binarytree.getRoot());
		if (binarytree.searchFor(6)) {
			System.out.println("Found student, id 6!");
		}
		binarytree.deleteFromTree(6);
		if (!binarytree.searchFor(6)) {
			System.out.println("Student id 6 deleted!");
		}
		System.out.println("Traverse in order:");
		binarytree.traverseInOrder(binarytree.getRoot());

		System.out.println("Traverse in pre-order:");
		binarytree.traversePreOrder(binarytree.getRoot());

		System.out.println("Traverse in post-order:");
		binarytree.traversePostOrder(binarytree.getRoot());

		System.out.println("------------------");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree binarytree = new Tree();
		Menu menu = new Menu();
		menu.processUserChoice();

	}
}
