
//Blaise Bowman

public class List {

	private ListNode head;
	private ListNode next;
 
	public boolean isEmpty() {
		return (head == null);
	}

	// used to insert a String item to the end of the linked list
	void insertItem(String name) {
		ListNode new_ListNode = new ListNode(name);
		if (head == null) {
			head = new ListNode(name);
			return;
		}
		new_ListNode.next = null;
		ListNode last = head;
		while (last.next != null)
			last = last.next;
		last.next = new_ListNode;
		return;
	}
 

	public void insertItem(String name, int pos)
	{ 
		ListNode newNode = new ListNode(name);
		newNode.data = name;
		newNode.next = null;

		if (pos < 0) {
			throw new IndexOutOfBoundsException("Index " + pos + " is out of bounds!");
		}
		if (pos == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}

		ListNode current = head;
		int i = 0;

		while (--pos > 0) {
			newNode = newNode.next;
		}
		for (i = 0; i < pos; i++) {
			current = current.next;

			if (current == null) {
				break;
			}
		}

		newNode.next = current.next;
		current.next = newNode;
	} 

	
	
	boolean removeItem(String aname) {
		ListNode current = head;
		ListNode parent = null;
		while (current != null) {
			if (current.data.equals(aname)) {
				if (current != null && parent == null) {
					// Delete head.
					if (current.next != null) {
						// Move head to next value.
						head = current.next;
					} else {
						// Just set the head to null.
						head = null;
					}
				} else if (current != null) {
					// Delete current, link parent to child..
					parent.next = current.next;
				}
				return true;
			}
			parent = current;
			current = current.next;

		}
		return false;


	}
	
	void removeItem(int position) {
		// Complete this method
		ListNode current = head;
		ListNode parent = null;
		int index = 0;

		while (current != null && index < position) {
			parent = current;
			current = current.next;

			index++;

			if ((current == null || (position < 0))) {
				throw new IndexOutOfBoundsException("Index " + position + " is out of bounds!");
			}
		}

		if (current != null && parent == null) {
			// Delete head.
			if (current.next != null) {
				// Move head to next value.
				head = current.next;
			} else {
				// Just set the head to null.
				head = null;
			}
		} else if (current != null) {
			// Delete current, link parent to child..
			parent.next = current.next;
		}

	}



	boolean contains(String name) {

		ListNode current = head;
		// ListNode parent = null;
		while (current != null) {
			if (current.data.equals(name)) {
				return true;
			}
			// parent = current;
			current = current.next;

		}

		return false;
	}

	void clear() {
		head = null;
	}

	String get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		ListNode tmp = head;
		for (int k = 0; k < index; k++)
			tmp = tmp.next;

		if (tmp == null) {
			throw new IndexOutOfBoundsException();
		}
		return tmp.data;
	}

	int size() {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public String toString() {
		String result = "";
		ListNode c = head;
		while (c != null) {
			result += c.data + "\n";
			c = c.next;
			}
		return "List: " + result;

	}

	String toHTMLString() {
		ListNode c = head;
		String result = "<html>PlayList<br/>";
		while (c != null) {
			result = result + c.data + "<br/>";
			c = c.next;
		}
		result = result + "</html>";
		return result;
	}


	class ListNode {
		public String data;
		public ListNode next;
		public ListNode head;

		public ListNode() {
			data = "";
		}


		public ListNode(String name) {
			data = name;
		}

		public ListNode(String name, ListNode next) {
			data = name;
			next = null;
		}

		public ListNode(int i) {
			// TODO Auto-generated constructor stub
		}

		public void displayListNodeData() {
			System.out.println("{ " + data + " } ");
		}
	}

	}




/*
 * macarena.mp3 who_let_the_dogs_out.mp3 barbie_girl.mp3 call_me_maybe.mp3
 * chandelier.mp3 mmmbop.mp3
 */
