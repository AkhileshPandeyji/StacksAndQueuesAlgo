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

		@SuppressWarnings("unused")
		private Node getNodeAt(int idx) {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}

		public void reversePI() {
			if (this.size == 0) {
				System.out.println("List is empty");
				return;
			}
			Node prev;
			Node curr;
			for (prev = null, curr = this.head; curr != null;) {
				Node n = curr.next;
				curr.next = prev;
				prev = curr;
				curr = n;
			}
			this.tail = this.head;
			this.head = prev;
		}

		public int kthFromLast(int k) {
			Node fast;
			Node temp;
			int i;

			for (i = 0, fast = this.head; i < k; i++) {
				fast = fast.next;
			}

			for (temp = this.head; fast != this.tail; fast = fast.next) {
				temp = temp.next;
			}

			return temp.data;

		}

		public int mid() {
			Node f = head;
			Node s = head;

			while (f.next != null && f.next.next != null) {
				f = f.next.next;
				s = s.next;
			}

			return s.data;
		}

		public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
			LinkedList ml = new LinkedList();

			Node one = l1.head;
			Node two = l2.head;
			while (one != null && two != null) {
				if (one.data < two.data) {
					ml.addLast(one.data);
					one = one.next;
				} else {
					ml.addLast(two.data);
					two = two.next;
				}
			}

			while (one != null) {
				ml.addLast(one.data);
				one = one.next;
			}

			while (two != null) {
				ml.addLast(two.data);
				two = two.next;
			}

			return ml;
		}

		public static Node midNode(Node head, Node tail) {
			Node fast = head;
			Node slow = head;

			while (fast != tail && fast.next != tail) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}

		public static LinkedList mergeSort(Node head, Node tail) {

			if (head == tail) {
				LinkedList baseList = new LinkedList();
				baseList.addLast(head.data);
				return baseList;
			}

			Node mid = midNode(head, tail);

			LinkedList left = mergeSort(head, mid);
			LinkedList right = mergeSort(mid.next, tail);
			LinkedList ml = mergeTwoSortedLists(left, right);
			return ml;
		}

		public void removeDuplicates() {
			LinkedList res = new LinkedList();

			while (this.size() > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (res.size() == 0 || val != res.tail.data) {
					res.addLast(val);
				}
			}

			this.head = res.head;
			this.tail = res.tail;
			this.size = res.size;
		}

		public void oddEven() {
			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();

			while (this.size > 0) {
				int val = this.getFirst();
				this.removeFirst();
				if (val % 2 != 0) {
					odd.addLast(val);
				} else {
					even.addLast(val);
				}
			}

			while (even.size > 0) {
				int val = even.getFirst();
				even.removeFirst();
				odd.addLast(val);
			}

			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		}

		public void kReverse(int k) {
			LinkedList group = new LinkedList();
			LinkedList value = new LinkedList();
			int i = 0;

			while (this.size > 0) {
				i = 0;
				while (i < k && this.size > 0) {
					int val = this.getFirst();
					this.removeFirst();
					group.addLast(val);
					i++;
				}
				if (group.size == k) {
					while (group.size > 0) {
						int val = group.getLast();
						group.removeLast();
						value.addLast(val);
					}
				} else {
					while (group.size > 0) {
						int val = group.getFirst();
						group.removeFirst();
						value.addLast(val);
					}
				}
			}

			this.head = value.head;
			this.tail = value.tail;
			this.size = value.size;

		}

		public boolean IsPalindrome() {
			LinkedList reverse = new LinkedList();
			Node mid = LinkedList.midNode(this.head, this.tail);

			reverse.head = mid.next;
			reverse.tail = this.tail;
			reverse.size = this.size / 2;

			mid.next = null;
			reverse.reversePI();

			Node t1 = this.head;
			Node t2 = reverse.head;

			boolean isPalindrome = true;

			while (t1 != null && t2 != null) {
				if (t1.data == t2.data) {
					isPalindrome = true;
				} else {
					isPalindrome = false;
					break;
				}
				t1 = t1.next;
				t2 = t2.next;
			}

			reverse.reversePI();
			mid.next = reverse.head;
			return isPalindrome;
		}

		public void fold() {
			LinkedList ans = new LinkedList();
			LinkedList rev = new LinkedList();

			Node mid = LinkedList.midNode(this.head, this.tail);

			rev.head = mid.next;
			rev.tail = this.tail;
			rev.size = this.size / 2;

			mid.next = null;
			rev.reversePI();

			Node t1 = this.head;
			Node t2 = rev.head;

			while (t1 != null || t2 != null) {
				if (t1 != null) {
					ans.addLast(t1.data);
					t1 = t1.next;
				}
				if (t2 != null) {
					ans.addLast(t2.data);
					t2 = t2.next;
				}

			}

			rev.reversePI();
			mid.next = rev.head;

			this.head = ans.head;
			this.tail = ans.tail;
			this.size = ans.size;
		}

		public static int addTwoListsHelper(Node l1n, int plv1, Node l2n, int plv2, LinkedList ans) {
			if (plv1 == 0 && plv2 == 0) {
				return 0;
			}
			if (plv2 > plv1) {
				int carry = addTwoListsHelper(l1n, plv1, l2n.next, plv2 - 1, ans);
				int val = carry + l2n.data;
				ans.addFirst(val % 10);
				return val / 10;
			} else if (plv1 > plv2) {
				int carry = addTwoListsHelper(l1n.next, plv1 - 1, l2n, plv2, ans);
				int val = carry + l1n.data;
				ans.addFirst(val % 10);
				return val / 10;
			} else {
				int carry = addTwoListsHelper(l1n.next, plv1 - 1, l2n.next, plv2 - 1, ans);
				int val = carry + l1n.data + l2n.data;
				ans.addFirst(val % 10);
				return val / 10;
			}
		}

		public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
			LinkedList ans = new LinkedList();
			int carry = addTwoListsHelper(one.head, one.size, two.head, two.size, ans);
			if (carry > 0) {
				ans.addFirst(carry);
			}
			return ans;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n1 = Integer.parseInt(br.readLine());
	    LinkedList l1 = new LinkedList();
	    String[] values1 = br.readLine().split(" ");
	    for (int i = 0; i < n1; i++) {
	      int d = Integer.parseInt(values1[i]);
	      l1.addLast(d);
	    }

	    int n2 = Integer.parseInt(br.readLine());
	    LinkedList l2 = new LinkedList();
	    String[] values2 = br.readLine().split(" ");
	    for (int i = 0; i < n2; i++) {
	      int d = Integer.parseInt(values2[i]);
	      l2.addLast(d);
	    }

	    LinkedList sum = LinkedList.addTwoLists(l1, l2);

	    int a = Integer.parseInt(br.readLine());
	    int b = Integer.parseInt(br.readLine());

	    l1.display();
	    l2.display();
	    sum.display();
	    sum.addFirst(a);
	    sum.addLast(b);
	    sum.display();
	}
}
