import { ListNode } from './ds';

/* Definition of ListNode:
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number){
        this.val = val;
        this.next = null;
    }
}*/

function palindromicLinkedList(head: ListNode | null): boolean {
    // Find the middle of the linked list and then reverse the second half of the
    // linked list starting at this midpoint.
    const mid = findMiddle(head);
    const secondHead = reverseList(mid);
    // Compare the first half and the reversed second half of the list
    let ptr1 = head, ptr2 = secondHead;
    let res = true;
    while (ptr2) {
        if (ptr1!.val !== ptr2.val) {
            res = false;
        }
        ptr1 = ptr1!.next, ptr2 = ptr2.next;
    }
    return res;
}

// From the 'Reverse Linked List' problem.
function reverseList(head: ListNode | null): ListNode | null {
    let prevNode: ListNode | null = null;
    let currNode: ListNode | null = head;
    while (currNode) {
        const nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    return prevNode;
}

// From the 'Linked List Midpoint' problem.
function findMiddle(head: ListNode | null): ListNode | null {
    let slow: ListNode | null = head;
    let fast: ListNode | null = head;
    while (fast && fast.next) {
        slow = slow!.next;
        fast = fast.next!.next;
    }
    return slow;
}
