import java.util.Scanner;

//Third step is to complete the following Project3.java file 
//This program tests our Tree.java implementation
//Blaise Bowman COP3530, Summer 2019
//
public class Project3 {

	public static void main(String args[]) {
		Tree T1 = new Tree();
		Scanner scan = new Scanner(System.in);
		Node N55 = new Node();
		N55.setData(55);
		T1.setRoot(N55);

		Node N60 = new Node();
		N60.setData(60);

		Node N20 = new Node();
		N20.setData(20);

		N55.setLeft(N60);
		N55.setRight(N20);


		Node N85 = new Node();
		N85.setData(85);
		Node N70 = new Node();
		N70.setData(70);
		N60.setLeft(N85);
		N60.setRight(N70);


		Node N15 = new Node();
		N15.setData(15);
		Node N75 = new Node();
		N75.setData(75);
		N85.setLeft(N15);
		N85.setRight(N75);


		Node N50 = new Node();
		N50.setData(50);
		Node N65 = new Node();
		N65.setData(65);
		N70.setLeft(N50);
		N70.setRight(N65);


		Node N10 = new Node();
		N10.setData(10);
		Node N30 = new Node();
		N30.setData(30);
		N20.setLeft(N10);
		N20.setRight(N30);

		Node N25 = new Node();
		N25.setData(25);
		Node N80 = new Node();
		N80.setData(80);
		N10.setLeft(N25);
		N10.setRight(N80);


		Node N35 = new Node();
		N35.setData(35);
		Node N5 = new Node();
		N5.setData(5);
		N30.setLeft(N35);
		N30.setRight(N5);
		///////////////////////////////
		// HARD-CODING ABOVE///////////
		// Running Example//////////////
		// Test-Code Below//////////////
		// Uncomment to test program //
		//////////////////////////////
		String f1 = "Checking function size():";
		String z1 = "The size of the binary tree T1 is: ";
		String f2 = "Checking function height():";
		String z2 = "The height of the binary tree T1 is: ";
		String f3 = "Checking function leaves():";
		String z3 = "The leaves of the binary tree T1 are:";
		String f4 = "Checking function internal()";
		String z4 = "The internal nodes of the binary tree T1 are:";
		String f5 = "Checking functions printLDR(), printDLR(), and printLRD()";
		String z52 = "The nodes of the binary tree T1 in in-order traversal are:";
		String z53 = "The nodes of the binary tree T1 in pre-order traversal are:";
		String z54 = "The nodes of the binary tree T1 in post-order traversal are:";
		String f6 = "Checking function search()";
		String z6 = "Enter element to search: ";
		String z61 = " belongs in the binary Tree T1";
		String z62 = " does not belong in the binary Tree T1";
		String f7 = "Checking function path()";
		String z7 = "Enter element to find path for:";
		String z71 = "The path from the root of T1 to node ";
		String z72 = " is:";
		String f8 = "Checking function descendents()";
		String z8 = "Enter element to find descendents for: ";
		String z81 = "The descendents of ";
		String z82 = " in T1 are: ";
		String f9 = "Checking function copy()";
		String z9 = "Let T2 be a copy of T1";
		String z91 = "The nodes of binary tree T2 in in-order traversal are: ";
		String f10 = "Checking function equal()";
		String z10 = "Let data part of node 80 be 90 in binary tree T1";
		String z11 = "Binary Trees T1 and T2 are not equal";
		String z12 = "Let data part of node 80 be 80 in binary tree T1";
		String z13 = "Binary trees T1 and T2 are equal";

		System.out.println(f1);
		printFmt(f1);
		System.out.println('\n' + z1 + T1.countNodes(T1.root));
		newPoint();

		System.out.println(f2);
		printFmt(f2);
		System.out.println('\n' + z2 + T1.height());
		newPoint();

		System.out.println(f3);
		printFmt(f3);
		System.out.println('\n' + z3);
		T1.leavesNodes(N55);
		newPoint();

		System.out.println('\n' + f4);
		printFmt(f4);
		newPoint();
		System.out.println(z4);
		T1.internalNodes(N55);

		newPoint();
		newPoint();
		System.out.println(f5);
		printFmt(f5);
		newPoint();
		System.out.print("  Enter 1 (in-order traversal of T1)," + '\n' + '\t' + "2 (pre-order traversal of T1),"
				+ '\n'
				+ '\t'
				+ "3 (post-order traversal of T1): ");
		int choice = scan.nextInt();
		if (choice == 1) {
			System.out.println(z52);
			T1.printLDR();
		} else if (choice == 2) {
			System.out.println(z53);
			T1.printDLR();
		} else if (choice == 3) {
			System.out.println(z54);
			T1.printLRD();
		} else {
			System.out.println("That is not an option. Please enter 1,2, or 3.");
		}

		newPoint();
		newPoint();
		System.out.println(f6);
		printFmt(f6);
		System.out.print('\n' + z6);
		int z = scan.nextInt();
		T1.search(z);
		System.out.print(z);
		if (T1.search(z) == true) {
			System.out.print(z61);
		} else {
			System.out.print(z62);
		}

		newPoint();
		newPoint();

		System.out.println(f7);
		printFmt(f7);
		System.out.print('\n' + z7);
		int x = scan.nextInt();
		System.out.print(z71);
		System.out.print(x);
		System.out.print(z72);
		T1.path(x);

		newPoint();
		newPoint();

		System.out.println(f8);
		printFmt(f8);
		newPoint();
		System.out.print(z8);
		int y = scan.nextInt();
		System.out.print(z81);
		System.out.print(y);
		System.out.print(z82 + '\n');
		T1.descendents(y);

		newPoint();
		newPoint();

		System.out.println(f9);
		printFmt(f9);
		newPoint();
		System.out.println(z9);
		System.out.println(z91);
		Tree T2 = new Tree();
		T2 = T1.copy();
		T2.printLDR();

		newPoint();
		newPoint();

		System.out.println(f10);
		printFmt(f10);
		newPoint();
		System.out.println(z10);
		N80.setData(90);
		if (T1.equal(T2)) {
			System.out.println(z13);
		} else {
			System.out.println(z11);
		}
		System.out.println(z12);
		N80.setData(80);
		if (T1.equal(T2)) {
			System.out.println(z13);
		} else {
			System.out.println(z11);
		}

	}

	public static void printFmt(String a) {
		for (int i = 0; i < a.length(); i++) {
			System.out.print("-");
		}

	}

	public static void newPoint() {
		System.out.print('\n');
	}

}




