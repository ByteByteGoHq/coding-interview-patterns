public class Solution
{
	public ListNode LinkedListReversal(ListNode head)
	{
		ListNode currentNode = head;
		ListNode prevNode = null;

		// Reverse the direction of each node's pointer until 'currentNode' is null.
		while (currentNode != null)
		{
			ListNode nextNode = currentNode.Next;
			currentNode.Next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}

		// 'prevNode' will be pointing at the head of the reversed linked list.
		return prevNode;
	}
}
