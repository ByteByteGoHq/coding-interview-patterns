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

function linkedListIntersection(head_A: LLNode, head_B: LLNode): LLNode {
    let ptr_A = head_A, ptr_B = head_B;
    // Traverse through list A with 'ptr_A' and list B with 'ptr_B' 
    // until they meet.
    while (ptr_A !== ptr_B) {
        // Traverse list A -> list B by first traversing 'ptr_A' and 
        // then, upon reaching the end of list A, continue the 
        // traversal from the head of list B.
        ptr_A = ptr_A !== null ? ptr_A.next : head_B;
        // Simultaneously, traverse list B -> list A.
        ptr_B = ptr_B !== null ? ptr_B.next : head_A;
    }
    // At this point, 'ptr_A' and 'ptr_B' either point to the 
    // intersection node or both are null if the lists do not 
    // intersect. Return either pointer.
    return ptr_A;
}
