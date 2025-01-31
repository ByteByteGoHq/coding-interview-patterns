/* Definition of ListNode:
class ListNode {
    val: number; 
    next: TNode;
    constructor(val: number, next: TNode = null){
        this.val = val;
        this.next = next;
    }
}
type TNode = ListNode | null;
*/

function linked_list_reversal_recursive(head: TNode): TNode {
    // Base cases.
    if (!head || !head.next)
        return head;
    // Recursively reverse the sublist starting from the next node.
    const new_head: TNode = linked_list_reversal_recursive(head.next);
    // Connect the reversed linked list to the head node to fully
    // reverse the entire linked list.
    head.next.next = head;
    head.next = null;
    return new_head;
}
