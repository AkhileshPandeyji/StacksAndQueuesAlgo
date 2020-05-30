package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinkedListCustom {
	public static class Node {
		int data;
		Node next;
	}

	public static class LinkedList {
		Node head;
		Node tail;
		int size;

		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;

			if (this.size == 0) {
				this.head = this.tail = temp;
			} else {
				this.tail.next = temp;
				this.tail = temp;
			}
			size++;
		}

		public int size() {
			return this.size;
		}

		public void display() {
			for (Node i = this.head; i != null; i = i.next) {
				System.out.print(i.data + " ");
			}
			System.out.println();
		}

		public void removeFirst() {
			if (this.size == 0) {
				System.out.println("List is empty");
			} else if (this.size == 1) {
				this.head = null;
				this.tail = null;
				this.size = 0;
			} else {
				this.head = this.head.next;
				this.size--;
			}
		}

		public int getFirst() {
			if (this.size == 0) {
				System.out.println("List is empty");
				return -1;
			}
			return this.head.data;
		}

		public int getLast() {
			if (this.size == 0) {
				System.out.println("List is empty");
				return -1;
			}
			return this.tail.data;
		}

		public int getAt(int idx) {
			if (this.size == 0) {
				System.out.println("List is empty");
				return -1;
			} else if (idx < this.size) {
				Node i;
				int count;
				for (i = this.head, count = 0; count != idx; count++, i = i.next) {
				}
				return i.data;
			} else {
				System.out.println("Invalid arguments");
				return -1;
			}

		}

		public void addFirst(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			if (this.size == 0) {
				this.head = this.tail = temp;
			} else {
				temp.next = this.head;
				this.head = temp;
			}
			this.size++;
		}

		public void addAt(int idx, int val) {
			if (idx == 0) {
				this.addFirst(val);
			} else if (idx == this.size) {
				this.addLast(val);
			} else if (idx > this.size) {
				System.out.println("Invalid arguments");
				return;
			} else {
				Node temp = new Node();
				temp.data = val;

				Node i;
				int count = 0;
				for (i = this.head, count = 0; count < idx - 1; count++, i = i.next) {
				}

				temp.next = i.next;
				i.next = temp;
				this.size++;
			}

		}

		public void removeLast() {
			if (this.size == 0) {
				System.out.println("List is empty");
			} else if (this.size == 1) {
				this.head = null;
				this.tail = null;
				this.size = 0;
			} else {
				int count;
				Node i;
				for (i = this.head, count = 0; count < this.size - 2; count++, i = i.next) {
				}
				this.tail = i;
				i.next = null;
				this.size--;
			}
		}

		public void removeAt(int idx) {
			if (idx == 0) {
				removeFirst();
			} else if (idx == this.size - 1) {
				removeLast();
			} else if (idx < 0 || idx >= this.size) {
				System.out.println("Invalid arguments");
				return;
			} else {
				int count;
				Node i;
				Node prev;
				for (i = this.head, prev = null, count = 0; count < idx; count++) {
					prev = i;
					i = i.next;
				}

				prev.next = i.next;
				i.next = null;
				this.size--;
			}
		}

		public void reverseDI() {
			if (this.size == 0) {
				System.out.println("List is empty");
			} else {
				Node temp;
				int i;
				int j;
				for (j = this.size - 1; j >= 1; j--) {
					i = 0;
					for (temp = this.head; i < j; i++) {

						int t = temp.data;
						temp.data = temp.next.data;
						temp.next.data = t;

						temp = temp.next;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList list = new LinkedList();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("addLast")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				list.addLast(val);
			} else if (str.startsWith("size")) {
				System.out.println(list.size());
			} else if (str.startsWith("display")) {
				list.display();
			} else if (str.startsWith("removeFirst")) {
				list.removeFirst();
			} else if (str.startsWith("getFirst")) {
				int val = list.getFirst();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("getLast")) {
				int val = list.getLast();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("getAt")) {
				int idx = Integer.parseInt(str.split(" ")[1]);
				int val = list.getAt(idx);
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("addFirst")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				list.addFirst(val);
			} else if (str.startsWith("addAt")) {
				int idx = Integer.parseInt(str.split(" ")[1]);
				int val = Integer.parseInt(str.split(" ")[2]);
				list.addAt(idx, val);
			} else if (str.startsWith("removeLast")) {
				list.removeLast();
			} else if (str.startsWith("removeAt")) {
				int idx = Integer.parseInt(str.split(" ")[1]);
				list.removeAt(idx);
			} else if (str.startsWith("reverseDI")) {
				list.reverseDI();
			}
			str = br.readLine();
		}
	}
}
