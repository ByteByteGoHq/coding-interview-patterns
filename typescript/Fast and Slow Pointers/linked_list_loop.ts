/* Definition of ListNode: 
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number) {
        this.val = val;
        this.next = null;
    }
}    
*/

function linkedListLoop(head: ListNode): boolean {
    let slow: ListNode | null = head;
    let fast: ListNode | null = head;
    // Check both 'fast' and 'fast.next' to avoid null pointer
    // exceptions when we perform 'fast.next' and 'fast.next.next'.
    while (fast !== null && fast.next !== null) {
        slow = slow!.next;
        fast = fast.next.next!;
        if (fast == slow)
            return true;
    }
    return false;
}