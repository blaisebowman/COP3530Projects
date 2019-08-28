
import java.util.Scanner;

class Project2 {
	// BLAISE BOWMAN

	public static void main(String args[]) {
		String infixExp; // infix expression to be read
		String postfixExp = ""; // postfix expression to be computed
		Stack S = new Stack(); // stack for converting the infix expression
		// to postfix notation
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an infix  expression: ");
		infixExp = scan.nextLine();
		Stack a = new Stack();
		

		for (int i = 0; i < infixExp.length(); i++) { // runs through the length
														// of the infix
														// expression
			char curr = infixExp.charAt(i); // the current char of the infix
											// expression


			if (Character.isDigit(curr)) { //if the character is a digit (0 to 9)
				postfixExp += curr; //appends the current character to the output String (postfixExp)
				System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
			}

			else if (curr == 42 || curr == 43 || curr == 45 || curr == 47) {
				// if the current character is an operator

				if (a.stackEmpty() == true) {
					// if the current character is an operator (nested above)
					// AND the stack is
					// empty, push the operator onto the stack
					a.stackPush(curr);
					System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
				}
				else {
					/*
					 * if the stack is not empty, pop operators of greater or
					 * equal precedence from the stack and append them to
					 * postfixExp
					 */
					boolean b = true;
					int j = 0;
					int u = 0;
					while (b == true) {
						if (a.stackEmpty()) {
							a.stackPush(curr);
							System.out.printf("%-8s %-8s %-8s\n", " " + " ", postfixExp, a.printCharStack());
							u = 0;
							b = false;
							break;
						}

						else if (a.stackTop() == 40) {
							// if the stack becomes empty or you encounter a "("
							// when popping from the stack.3
							a.stackPush(curr);
							System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
							u = 0;
							break;
						}

						else if (!(a.stackEmpty()) && (a.stackTop() == 42 || a.stackTop() == 43 || a.stackTop() == 45
								|| a.stackTop() == 47)) {
							if (curr == 42) { // 42 is the ASCII value for *
								if (a.stackTop() == 42) {
									postfixExp += (char) a.stackTop();

									a.stackPop();
									if (j == 0)
										System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp,
												a.printCharStack());
									else
										System.out.printf("%-8s %-8s %-8s\n", " " + ": ", postfixExp,
												a.printCharStack());
								}
								else {
									a.stackPush(curr); // all other operators
														// would have lower
														// precedence

									System.out.printf("%-8s %-8s %-8s\n", curr + ": " + " ", postfixExp,
											a.printCharStack());
									break;
								}
								j++;
							}

							else if (curr == 43) { // 43 is the ASCII value for
													// +

								if (a.stackTop() == 42 || a.stackTop() == 47 || a.stackTop() == 43) {
									postfixExp += (char) a.stackTop();
									a.stackPop();
									if (u == 0)
										System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp,
												a.printCharStack());
									else
										System.out.printf("%-8s %-8s %-8s\n", " " + " ", postfixExp,
												a.printCharStack());
								} else if (a.stackTop() == 45) {
									a.stackPush(curr);
									System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
									break;
								}
								u++;
							} else if (curr == 45) { // 45 is the ASCII value
														// for -
								if (a.stackTop() != 45) {
									postfixExp += (char) a.stackTop();
									a.stackPop();
									if (j == 0)
										System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp,
												a.printCharStack());
									else
										System.out.printf("%-8s %-8s %-8s\n", " " + " ", postfixExp,
												a.printCharStack());

								} else {// there are no operators of lower
										// precedence, by definition, so no
										// pushing would occur
									a.stackPush(curr);
									j++;
								}
							} else if (curr == 47) { // 47 is the ASCII value
														// for /
								if (a.stackTop() == 42 || a.stackTop() == 47) {
									postfixExp += (char) a.stackTop();
									a.stackPop();
									if (j == 0)
										System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp,
												a.printCharStack());
									else
										System.out.printf("%-8s %-8s %-8s\n", " " + " ", postfixExp,
												a.printCharStack());
								} else if (a.stackTop() == 43 || a.stackTop() == 45) {
									a.stackPush(curr);
									System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
									break;
								}
								j++;
							}
						}
					}
				}
			}
			
			else if (curr == 40) { // push each "(" onto the stack
				a.stackPush(curr);
				System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
			}
			else if (curr == 41) { // if the current character is a ")"
				int j = 0;
				while (true) {
					if (a.stackTop() == 42 || a.stackTop() == 43 || a.stackTop() == 45 || a.stackTop() == 47) {
						postfixExp += (char) a.stackTop();
						a.stackPop();
						if (j != 0) {
							System.out.printf("%-8s %-8s %-8s\n", " " + ": ", postfixExp, a.printCharStack());
						} else {
							System.out.printf("%-8s %-8s %-8s\n", curr + ": ", postfixExp, a.printCharStack());
						}
					}
					else if (a.stackTop() == 40) {
						a.stackPop();
						System.out.printf("%-8s %-8s %-8s\n", " " + " ", postfixExp, a.printCharStack());
						break;
					}
					j++;
				}
			}
			else if (i == infixExp.length() - 1) {
				/*
				 * while (!a.stackEmpty()) { System.out.println("\t" +
				 * postfixExp + a.printCharStack()); postfixExp +=
				 * a.printCharStack(); a.stackPop(); }
				 */
			}
		}
		while (!a.stackEmpty()) {// after you read the last char in the infix
									// expression you add the remainder of the
									// stack to the postfix expression
			char d = (char) a.stackTop();
			if (!(a.stackTop() == 40 || a.stackTop() == 41)) {
			postfixExp += d;
			}
			a.stackPop(); // pops of the stack
			System.out.printf("%-8s %-8s %-8s\n", " " + " ", postfixExp, a.printCharStack());
		}

		System.out.println("\n" + "The expression in postfix notation is " + postfixExp);
}
}
