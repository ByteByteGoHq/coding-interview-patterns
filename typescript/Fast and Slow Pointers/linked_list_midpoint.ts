import { ListNode } from "./ds";

/* Definition of ListNode:
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number) {
        this.val = val;
        this.next = null;
    }
}*/


function linkedListMidpoint(head: ListNode | null): ListNode | null {
    let slow: ListNode | null = head;
    let fast: ListNode | null = head;
    // When the fast pointer reaches the end of the list, the slow
    // pointer will be at the midpoint of the linked list.
    while (fast !== null && fast.next !== null) {
        slow = slow!.next;
        fast = fast.next.next!;
    }
    return slow;
}
