import { ListNode } from './ds';

/* Definition of ListNode:
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number){
        this.val = val;
        this.next = null;
    }
}*/

function linkedListReversal(head: ListNode | null): ListNode | null {
    let currNode: ListNode | null = head;
    let prevNode: ListNode | null = null;
    // Reverse the direction of each node's pointer until 'currNode' 
    // is null.
    while (currNode !== null){
        const nextNode: ListNode | null = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    // 'prevNode' will be pointing at the head of the reversed linked 
    // list.
    return prevNode;
}

