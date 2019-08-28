import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Complete Tree.java, which implements the Binary Tree ADT using a linked structure 
//Blaise Bowman COP3530, Summer 2019

public class Tree {

	Node root;

	Tree() {
		root = null;
	}

	public Node getRoot() {
		return root;

	}

	public void setRoot(Node newRoot) {
		// Sets root to newRoot
		root = newRoot;

	}

	public boolean empty() {
		// Returns true if the tree is empty and returns false otherwise
		if (root == null) { // the tree is empty if the root is null
			return true;
		}
		return false;
	}

	public int count() {
		// Returns the number of nodes in the tree.
		// Uses function countNodes().
		return countNodes(root);
	}

	public int countNodes(Node N) {
		// Recursive function which returns the number of nodes
		// in the subtree rooted at N.
		if (N == null)
			return 0;
		else
			return 1 + countNodes(N.left) + countNodes(N.right);

	}



	public boolean equal(Tree T) {
		// Returns true if our tree equals tree T. Returns false otherwise.
		// Uses function equalNodes().
		if (equalNodes(root, T.root) == true) {
			return true;
		}
		return false;

	}

	public boolean equalNodes(Node N, Node M) {
		// Recursive function which returns true if the subtrees rooted
		// at N and M are equal. Returns false otherwise.

		if (N == null && M == null)
			return true; // both (sub)trees are empty
		else if (N != null && M == null)
			return false;
		else if (N == null && M != null)
			return false;

		else {
			if (M.data == N.data && equalNodes(N.left, M.left) && equalNodes(N.right, M.right))
				return true;
			else
				return false;
		}
	}

	public boolean search(int element) {
		// Returns true if element belongs in the tree. Returns false otherwise.

		// Uses function searchNodes().
		return searchNodes(root, element);
	}

	public boolean searchNodes(Node N, int element) {
		// Recursive function which returns true if element belongs to the
		// subtree rooted at N. Returns false otherwise.
		if (N == null) {
			return false; // if the node at which the subtree is rooted is empty
		}

		if (N.data == element) {
			return true; // if the element belongs to the root of the subtree
		}
		boolean rL = searchNodes(N.left, element); // left side of subtree
		boolean rR = searchNodes(N.right, element); // right side of subtree
		return rL || rR; // recursive calls to the left and right side of the
							// subtrees
	}

	public void printLDR() {
		// Prints the elements of the tree in in-order (LDR).
		// Uses function printLDRNodes().
		printLDRNodes(root);
	}

	public void printLDRNodes(Node N) {
		// Recursive function which prints the elements of the subtree
		// rooted at N in in-order (LDR).
		// Recursive function to perform in-order traversal of the tree
		if (N == null) {// return if the current node is empty
			return;
		}
		// Traverse the left subtree
		printLDRNodes(N.left);
		// Display the data part of the root (or current node)
		System.out.print(N.data + " ");
		// Traverse the right subtree
		printLDRNodes(N.right);
	}

	public void printLRD() {
		// Prints the elements of the tree in post-order (LRD).
		// Uses function printLRDNodes().
		printLRDNodes(root);
	}

	public void printLRDNodes(Node N) {
		// Recursive function which prints the elements of the subtree
		// rooted at N in post-order (LRD).
		if (N == null) { // return if the current node is empty
			return;
		}
		printLRDNodes(N.left); // recursion on left subtree.
		printLRDNodes(N.right); // recursion on right subtree
		System.out.print(N.data + " "); // Here dealing with the root.
	}

	public void printDLR() {
		// Prints the elements of the tree in pre-order (DLR).
		// Uses function printDLRNodes().
		printDLRNodes(root);
	}

	public void printDLRNodes(Node N) {
		// Recursive function which prints the elements of the subtree
		// rooted at N in pre-order (DLR).
		if (N == null) { // return if the current node is empty
			return;
		}
		System.out.print(N.data + " ");// prints the root.
		printDLRNodes(N.left);// recursion of left subtree.
		printDLRNodes(N.right); // recursion on right subtree.
	}

	public Tree copy() {
		// Returns a copy of our tree.
		// Uses function copyNodes().
		Tree cpTree = new Tree();
		Node cpNode = copyNodes(root);
		cpTree.setRoot(cpNode);
		return cpTree;
	}

	public Node copyNodes(Node N) {
		// Recursive function which returns a copy of the subtree rooted at N.
		if (N == null) {
			return null;
		}
		Node newNode = new Node();
		newNode.data = N.data; // sets the data of the newNode to the Node taken
								// as a parameter
		if (N.left != null) {
			newNode.left = copyNodes(N.left); // recursive call to the left side
												// of the subtree
		}
		if (N.right != null) {
			newNode.right = copyNodes(N.right); // recursive call to the right
												// side of the subtree
		}
		return newNode; // returns the newNode
	}

	public void leaves() {
		// Prints the leaves of our tree. The root is not a leave.
		// Uses function leavesNodes().
		leavesNodes(root);
	}

	public void leavesNodes(Node N) {
		// Recursive function which prints the leaves of the subtree
		// rooted at N.
		// base case
		if (N == null) {
			return;
		}
		if (N.left == null && N.right == null) {
			System.out.printf("%s ", N.data); // this is a leaf node,since it
												// does not have any children
		}
		leavesNodes(N.left); // recursion on the left side of the subtree
		leavesNodes(N.right); // recursion on the right side of the subtree
	}

	public void internal() {
		// Prints the internal nodes of our tree.
		// The root is not an internal node.
		// Uses function internalNodes().
		internalNodes(root);
	}

	public void internalNodes(Node N) {
		// Recursive function which prints the internal nodes of the
		// subtree rooted at N.
		// has to have at least one child
		Queue<Node> q = new LinkedList<Node>(); // establishes Queue in order to
												// keep track of nodes which
												// meet criteria
		q.add(root); // adds the root to the queue
		while (!q.isEmpty()) {// while the queue is not empty
			Node current = q.peek(); // checks the element at the front of the
									// queue
			q.remove(); // pops the element from the front of the queue
			boolean internal = false; // tracks if a node is internal
			// current node has left child
			if (current.left != null) {
				internal = true;
				q.add(current.left);
			}
			// current node has right child
			if (current.right != null) {
				internal = true;
				q.add(current.right);
			}
			if (internal == true) { // if the node has at least one child, it is
									// an internal node
				if (current.data == root.data) {
					//
				} else {
					System.out.print(current.data + " "); // print the internal
															// (current) node
				}
			}
		}

	}

	public void path(int element) {
		// Prints the path from root to element if element exists in the tree.
		// Uses function pathNodes().

		System.out.printf(" %s ", root.data);
		pathNodes(element, root.right);
		pathNodes(element, root.left);

	}

	public void pathNodes(int element, Node N) {
		Stack<Node> nodeStack = new Stack<>(); // creates a stack
		nodeStack.push(N);
		boolean present = true;

		Node topNodeRight;

		while (true) {
			Node topNode = nodeStack.peek();
			topNodeRight = topNode.right;

			if (topNode.left != null) {
				nodeStack.push(topNode.left);
				if (topNode.left.data == element) {
					break;
				}
			} else if (topNodeRight != null) {
				nodeStack.push(topNodeRight);
				if (topNodeRight.data == element) {
					break;
				}
			} else {
				Node lastPoppedNode;

				do {
					lastPoppedNode = nodeStack.pop();
					topNode = nodeStack.peek();
				} while (topNode.right == null);

				topNodeRight = topNode.right;

				nodeStack.push(topNodeRight);

				if (topNodeRight.data == element) {
					break;
				}

				if (lastPoppedNode == topNodeRight) {
					present = false;
					break;
				}
			}
		}
		if (present) { // if the element is present in the tree
			for (Node tempNode : nodeStack) {
				System.out.printf("%s ", tempNode.data);
			}
		} else {
			// System.out.println("Element is not present in the tree");
		}
	}

	public int height() {
		// Returns the height of the tree.
		// Uses function heightNodes().
		return heightNodes(root);
	}

	public int heightNodes(Node N) {
		// Recursive function which returns the height of the subtree
		// rooted at N.
		if (N == null) {
			return 0;
		} else {
			/* compute the Height of each subtree */
			int leftTreeHeight = heightNodes(N.left); // recursion on the left
														// side
													// of the subtree
			int rightTreeHeight = heightNodes(N.right); // recursion on the
														// right
													// side of the subtree

			if (leftTreeHeight > rightTreeHeight) // use the larger height, as
													// they are
											// not always the same
				return (leftTreeHeight + 1);
			else
				return (rightTreeHeight + 1);
		}

	}

	public void descendents(int element) {
		// Prints all the descendents of element if element exists in the tree.
		// Uses function descendentsNodes().
		descendentsNodes(root, element);
	}

	public void descendentsNodes(Node N, int element) {
		// Recursive function which prints all the descendents of element in
		// the subtree rooted at N.
		// Assumes element belongs in the subtree rooted at N.
		if (N == null) {
			return;
		}
		if (N.data == element) {
			System.out.printf("%s ", N.left.data);
			System.out.printf("%s ", N.right.data);
		}
		descendentsNodes(N.left, element);
		descendentsNodes(N.right, element);
	}

}

