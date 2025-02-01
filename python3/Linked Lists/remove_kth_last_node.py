from ds import ListNode

"""
Definition of ListNode:
class ListNode:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""


def remove_kth_last_node(head: ListNode, k: int) -> ListNode:
    # If k is less than or equal to 0, no node needs to be removed.
    if k <= 0:
        return head
    # A dummy node to ensure there's a node before 'head' in case we 
    # need to remove the head node.
    dummy = ListNode(-1)
    dummy.next = head
    trailer = leader = dummy
    # Advance 'leader' k steps ahead.  
    for _ in range(k):
        leader = leader.next
        # If k is larger than the length of the linked list, no node 
        # needs to be removed.
        if not leader:
            return head
    # Move 'leader' to the end of the linked list, keeping 'trailer'
    # k nodes behind.
    while leader.next:
        leader = leader.next
        trailer = trailer.next
    # Remove the kth node from the end.
    trailer.next = trailer.next.next
    return dummy.next
