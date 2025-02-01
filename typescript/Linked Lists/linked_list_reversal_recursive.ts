/* Definition of ListNode:
class ListNode {
    val: number; 
    next: LLNode;
    constructor(val: number, next: LLNode = null){
        this.val = val;
        this.next = next;
    }
}
type LLNode = ListNode | null;
*/

function linkedListReversalRecursive(head: LLNode): LLNode {
    // Base cases.
    if (!head || !head.next)
        return head;
    // Recursively reverse the sublist starting from the next node.
    const newHead: LLNode = linkedListReversalRecursive(head.next);
    // Connect the reversed linked list to the head node to fully
    // reverse the entire linked list.
    head.next.next = head;
    head.next = null;
    return newHead;
}
