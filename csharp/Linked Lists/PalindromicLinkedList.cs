public class Solution
{
	public bool PalindromicLinkedList(ListNode head)
	{
		// Find the middle of the linked list and then reverse the second half of the
		// linked list starting at this midpoint.
		ListNode mid = findMiddle(head);
		ListNode secondHead = reverseList(mid);

		// Compare the first half and the reversed second half of the linked list.
		ListNode ptr1 = head;
		ListNode ptr2 = secondHead;
		bool result = true;

		while (result && ptr2 != null)
		{
			if (ptr1.Val != ptr2.Val)
				result = false;

			ptr1 = ptr1.Next;
			ptr2 = ptr2.Next;
		}

        return result;
	}

	// From the 'Reverse Linked List' problem.
	private ListNode reverseList(ListNode head)
	{
		ListNode prevNode = null;
		ListNode currentNode = head;

		while(currentNode != null)
		{
			ListNode nextNode = currentNode.Next;
			currentNode.Next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}

		return prevNode;
	}

	// From the 'Linked List Midpoint' problem.
	private ListNode findMiddle(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.Next != null)
		{
			slow = slow.Next;
			fast = fast.Next.Next;
		}

		return slow;
	}
}
