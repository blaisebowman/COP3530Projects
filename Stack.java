class Stack {
	private int count; // number of elements in the stack
	private int top; // top element of the stack.
	// top == -1 if the stack is empty
	private int MAXSIZE = 1000; // Physical size of the stack
	private int[] array;

	// constructor
	Stack() {
		this.array = new int[MAXSIZE];
		// this.count = count;
		this.top = -1;
	}

	// inspectors
	public boolean stackEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
		// Returns true if the stack is empty. Otherwise returns false.

	}

	public int stackTop() {
		// Returns the top element of the stack
		return array[top];
	}

	public int stackCount() { // Returns the number of elements in the stacks
		return top + 1;
	}

	public String toString() {
		// Returns the elements of the stack with the following format:
		// < E1 E2 E3 ... En> where E1 is at the bottom of the stack
		// and En is at the top of the stack.
		if (stackEmpty()) {
			return "< >";
		}
		StringBuffer out = new StringBuffer("<");
		for (int i = 0; i < top; i++)
			out.append(array[i] + " ");

		out.append(array[top] + ">");
		return out.toString();

	}

	public String printCharStack() {
		// Returns the elements of the stack with the following format:
		// < E1 E2 E3 ... En> where E1 is at the bottom of the stack
		// and En is at the top of the stack.
		// The elements are printed to the returning string as chars.
		// modifiers
		if (stackEmpty()) {
			return "\t< >";
		}
		String result = "\t< ";
		for (int i = 0; i < top; i++) {
			result += " " + (char) array[i] + " ";
		}
		result += (char) array[top] + " >";
		return result;
	}

	public void stackPush(int element) {
		// Pushes element to the top of the stack.

		if (this.count != this.MAXSIZE) {
			array[++top] = element;
		}

		else {
			System.out.println("The stack is full!");
		}

	}

	public boolean stackPop() {
		// Pops out the top element of the stack.
		// Returns true if the operation was successful.
		// Returns false otherwise.
		if (stackEmpty()) {
			return false;
		} else {
			top--;
			return true;
		}
	}
}
