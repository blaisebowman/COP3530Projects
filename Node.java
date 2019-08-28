
//Source Code provided with COP3530 Project 3 Description 
//Blaise Bowman COP3530, Summer 2019

class Node {
	int data;
	Node left;
	Node right;

	Node() {
		data = 0;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setData(int newData) {
		data = newData;
	}

	public void setLeft(Node newLink) {
		left = newLink;
	}

	public void setRight(Node newLink) {
		right = newLink;
	}

}

