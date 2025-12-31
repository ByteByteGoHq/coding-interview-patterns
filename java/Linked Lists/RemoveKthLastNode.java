import DS.ListNode;

/*
    // Definition of ListNode:
    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }
    }
 */


public class RemoveKthLastNode {
    public static ListNode removeKthLastNode(ListNode head, int k) {
        // A dummy node to ensure there's a node before 'head' in case we
        // need to remove the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode trailer = dummy;
        ListNode leader = dummy;
        // Advance 'leader' k steps ahead.
        for (int i = 0; i < k; i++) {
            leader = leader.next;
            // If k is larger than the length of the linked list, no node
            // needs to be removed.
            if (leader == null) {
                return head;
            }
        }
        // Move 'leader' to the end of the linked list, keeping 'trailer'
        // k nodes behind.
        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }
        // Remove the kth node from the end.
        trailer.next = trailer.next.next;
        return dummy.next;
    }
}
