import { ListNode } from './ds';

/* Definition of ListNode:
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number){
        this.val = val;
        this.next = null;
    }
}*/

function linkedListReversalRecursive(head: ListNode | null): ListNode | null {
    // Base cases.
    if (!head || !head.next)
        return head;
    // Recursively reverse the sublist starting from the next node.
    const newHead: ListNode | null = linkedListReversalRecursive(head.next);
    // Connect the reversed linked list to the head node to fully
    // reverse the entire linked list.
    head.next.next = head;
    head.next = null;
    return newHead;
}
