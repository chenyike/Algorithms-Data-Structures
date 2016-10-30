import java.util.ArrayList;


public class NodeList<T> {
	
	public T data;
	public NodeList<T> next;
	
	// constructor
	public NodeList(T data, NodeList<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public static NodeList<Integer> ReverseSubNodeList(NodeList<Integer> L, int s, int f) {
		// TODO Auto-generated constructor stub
		NodeList<Integer> preNode = new NodeList<Integer>(0,L);
		if (L == null) {
			return null;
		}
		
		for (int i = 0; i < s-1; i++) {
			preNode = preNode.next;
		}
		
		NodeList<Integer> nodeS = preNode.next;
		
		if (nodeS == null) {
			return L;
		}
		
		for (int i = s; i < f; i++) {
			NodeList<Integer> toMove = nodeS.next;
			nodeS.next = toMove.next;
			toMove.next = preNode.next;
			preNode.next = toMove;
		}
		
		return L;
	}
	
	
	
	public static NodeList<Integer> findLoop(NodeList<Integer> L) {
		NodeList<Integer> i1 = L; // slow interator
		NodeList<Integer> i2 = L; // fast interator
		NodeList<Integer> i3 = L; // interator 3 counts the loop length
		// return null
		
		while (i1 != null && i2 != null && i2.next != null) {
			if (i1 == i2) {
				// return the beginning node of the loop
				// 1 2 3 4
				i3 = i1.next;
				int loopLength = 1;
				while (i3 != i1) {
					i3 = i3.next;
					loopLength++; // total length of the loop
				}
				
				i1 = L;
				for (int i = 0; i < loopLength; i++) {
					i1 = i1.next;
				}
				
				i2 = L;
				while (i1 != i2) {
					i1 = i1.next;
					i2 = i2.next;
				}
				return i1;
				
//				int len = 0;
//				print(len++) // 1
//				
//				int len = 0;
//				print(++len) // 0
//				print(++len) // 1
//				print(len++) // 3
				
			}
			
			i1 = i1.next;
			i2 = i2.next.next;
		}
		
		return null;
	}
	
	
	
	
	public static NodeList<Integer> cycleHead(NodeList<Integer> L) {
		NodeList<Integer> slowIterator = L;
		NodeList<Integer> fastIterator = L;
		
		while (slowIterator != null & fastIterator != null && fastIterator.next != null) { //question here???
			if (slowIterator != fastIterator) {
				slowIterator = slowIterator.next;
				fastIterator = fastIterator.next.next;
			}
			slowIterator = slowIterator.next;
			int length = 1;
			while(slowIterator != fastIterator) {
				slowIterator = slowIterator.next;
				length ++;
			}
			
			NodeList<Integer> i1 = L;
			NodeList<Integer> i2 = L;
			
			i2 = advanceDiffStep(i2, length);
			
			NodeList<Integer> startNode = isOverLapped(i1,i2);
			return startNode;
		}
		
		return null;
	}
	
	
	
	
	
	public static int calLength(NodeList<Integer> L) {
		NodeList<Integer> i = L;
		int n = 0;
		while(i != null) {
			i = i.next;
			n++;
		}
		return n;
	}
	
	public static int lengthBeforeCycle(NodeList<Integer> L,  NodeList<Integer> cycleHead) {
		NodeList<Integer> iterator = L;
		int length = 0;
		while(iterator != cycleHead) {
			iterator = iterator.next;
			length ++;
		}
		return length;	
	}
	
	public static NodeList<Integer> advanceDiffStep(NodeList<Integer> L, int diff) {
		NodeList<Integer> iterator = L;
		for(int i= 0; i < diff; i ++) {
			iterator = iterator.next;
		}
		return iterator;
	}
	
	public static NodeList<Integer> isOverLapped(NodeList<Integer> L1, NodeList<Integer> L2) {
		NodeList<Integer> iterator1 = L1;
		NodeList<Integer> iterator2 = L2;
		while(iterator1 != null && iterator2 != null) {
			if(iterator1 == iterator2) {
				return iterator1;
			}
			iterator1 = iterator1.next;
			iterator2 = iterator2.next;
		}
		return null;
	}
	

	public static NodeList<Integer> overLappingList(NodeList<Integer> L1, NodeList<Integer> L2) {		
		// 1. if neither of them has a cycle, determine whether they have an overlapping node or not
		if (cycleHead(L1) == null && cycleHead(L2) == null) {
			int length1 = calLength(L1);
			int length2 = calLength(L2);
			int diff = length1 - length2;
			if(length1 > length2) {
				NodeList<Integer> nodeL1 = advanceDiffStep(L1, diff);
				NodeList<Integer> overLappedNode = isOverLapped(nodeL1, L2);
				return overLappedNode;
			}
			else {
				NodeList<Integer> nodeL2 = advanceDiffStep(L2, diff);
				NodeList<Integer> overLappedNode = isOverLapped(nodeL2, L1);
				return overLappedNode;
			}
		}
		
		
		// 2. If one of them has a cycle and the other one does not, then they do not have overlapping nodes
		if (cycleHead(L1) != null && cycleHead(L2) == null) {
			return null;
		}
		
		if (cycleHead(L1) == null && cycleHead(L2) != null) {
			return null;
		}
		
		
		// 3. if they both have cycles, then they must be sharing the same cycle, and they must have overlapping nodes
		if (cycleHead(L1) != null && cycleHead(L2) != null) {
			// 3a if they merge before the cycle, return that node
			// 3b if they merge right at the beginning of the cycle return any node in the loop
			NodeList<Integer> startCycleNode = cycleHead(L1);
			int diff = lengthBeforeCycle(L1, startCycleNode) - lengthBeforeCycle(L2, startCycleNode);
			if(diff > 0) {
				NodeList<Integer> i1 = advanceDiffStep(L1,diff);
				NodeList<Integer> i2 = L2;
				while(i1 != null && i2 != null) {
					i1 = i1.next;
					i2 = i2.next;
				}
				
				return i1 == startCycleNode ? startCycleNode: i1;
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}