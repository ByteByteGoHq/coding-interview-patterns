using ds.ListNode;

/*
	Definition of ListNode:
	class ListNode : IComparable<ListNode>
	{
		public ListNode(int val, ListNode next = null)
		{
			Val = val;
			Next = next;
		}

		public int Val { get; set; }

		public ListNode Next { get; set; }

		// Define a custom comparator for 'ListNode', enabling the min-heap 
		// to prioritize nodes with smaller values.
		public int CompareTo(ListNode other)
		{
			return this.Val - other.Val;
		}
	}
*/

public class Solution
{
	public ListNode CombineSortedLinkedLists(ListNode[] lists)
	{
		PriorityQueue<ListNode, ListNode> heap = new();

		// Push the head of each linked list into the heap.
		foreach (ListNode head in lists)
			if (head != null)
				heap.Enqueue(head, head);

		// Set a dummy node to point to the head of the output linked list.
		ListNode dummy = new ListNode(-1);

		// Create a pointer to iterate through the combined linked list as
		// we add nodes to it.
		ListNode curr = dummy;

		while (heap.Count > 0)
		{
			// Pop the node with the smallest value from the heap and add it 
			// to the output linked list
			ListNode smallestNode = heap.Dequeue();
			curr.Next = smallestNode;
			curr = curr.Next;

			// Push the popped node's subsequent node to the heap.
			if (smallestNode.Next != null)
				heap.Enqueue(smallestNode.Next, smallestNode.Next);
		}

		return dummy.Next;
	}
}
