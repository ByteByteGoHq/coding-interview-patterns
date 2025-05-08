public class Solution
{
	public ListNode RemoveKthLastNode(ListNode head, int k)
	{
		// A dummy node to ensure there's a node before 'head' in case we need to remove the head node.
		ListNode dummy = new ListNode(-1);
		dummy.Next = head;

		ListNode leader = dummy;
		ListNode trailer = dummy;

		// Advance 'leader' k steps ahead.
		for (int i = 0; i < k; i++)
		{
			leader = leader.Next;
			
			// If k is larger than the length of the linked list, no node needs to be removed.
			if (leader == null)
				return head;
		}

		// Move 'leader' to the end of the linked list, keeping 'trailer' k nodes behind.
		while (leader.Next != null)
		{
			leader = leader.Next;
			trailer = trailer.Next;
		}

		// Remove the kth node from the end.
		trailer.Next = trailer.Next.Next;
	
		return dummy.Next;
	}
}
