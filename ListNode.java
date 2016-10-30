
public class ListNode<T> {

	// instance variables
	public T data;
	public  ListNode<T> next;
	
	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	
	//searh a node
	public static ListNode<Integer> search( ListNode<Integer> L, int key){
		while(L != null && L.data != key){
			L = L.next;
		}
		return L;
	}
	
	//insert a node
	public static void insertAfter(ListNode<Integer> node, ListNode<Integer> newNode){
		newNode.next = node.next;
		node.next = newNode;
	}
	
	//delete a node
	public static void deleteList(ListNode<Integer> aNode){
		aNode.next = aNode.next.next;
	}
	
	
	
	public static ListNode<Integer> merge(ListNode<Integer> L1, ListNode<Integer> L2) {
		ListNode<Integer> dummyHead = new ListNode<Integer>(0,null);
		ListNode<Integer> tail = dummyHead;
		while(L1 != null && L2 != null) {
			if (L1.data > L2.data) {
				tail.next = L2;
				L2 = L2.next;
			}
			else {
				tail.next = L1;
				L1 = L1.next;
			}
			tail = tail.next;
		}
		
		if (L1 != null ) {
			tail.next = L1;
		}
		
		if (L2 != null) {
			tail.next = L2;
		}		
		return dummyHead.next;
	}
	
	
	public static void main(String[] args) {
		ListNode<Integer> L1 = new ListNode<Integer>(1,null);
		ListNode<Integer> tail = L1;
		ListNode<Integer> L2 = new ListNode<Integer>(2,null);
		ListNode<Integer> L2_tail = L2;
		for (int i = 3; i <= 7; i += 2) {
			tail.next = new ListNode<Integer>(i,null);
			tail = tail.next;
		}
		for (int i = 4; i <= 8; i += 2) {
			L2_tail .next = new ListNode<Integer>(i,null);
			L2_tail = L2_tail.next;
		}
		
		ListNode<Integer> L3 = merge(L1, L2);
			

		
		while(L3 != null) {
			System.out.println(L3.data);
			L3 = L3.next;
		}
		
	}
	
	
}
