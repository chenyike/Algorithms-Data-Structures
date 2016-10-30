
public class ListNode1<T> {
	
	// instance variables
	public ListNode1<T> next;
	public T data;
	
	// constructor
	public ListNode1(T data, ListNode1<T> next) {
		this.next = next;
		this.data = data;
	}
	
	public static <T> void addNode(ListNode1<T> curNode, ListNode1<T> newNode) {
		newNode.next = curNode.next;
		curNode.next = newNode;
	}
	
	public static <T extends Comparable<T>> ListNode1<T> merge(ListNode1<T> L1, ListNode1<T> L2) {
		
		ListNode1<T> dummyHead = new ListNode1<T>(null, null);
		while (L1 != null && L2 != null) {
			if (L1.data < L2.data) {
				L1 = L1.next;
			}
			else {
				L2.next = L1;
			}
		}
		return;
	}
	
	public void append(ListNode1<T> newNode) {
		newNode.next = this.next;
		this.next = newNode;
	}
	
	public static <T> void deleteAfter(ListNode1<T> preNode) {
		if (preNode.next == null) {
			return;
		}
		preNode.next = preNode.next.next;
	}
	
	public void deleteNext() {
		if (this.next == null) {
			return;
		}
		this.next = this.next.next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		ListNode1<Integer> list = new ListNode1<Integer>(0, null);
		
		// non-static
		list.append(new ListNode1<Integer>(1, null));
		
		// static
		ListNode1.addNode(new ListNode1<Integer>(1, null), list);
		
		ListNode1<Integer> l1 = new ListNode1<Integer>(0, null);
		ListNode1<Integer> l2 = new ListNode1<Integer>(0, null);
		ListNode1.merge(l1, l2);
	}

}
