// Definition of ListNode:
class ListNode {
    val: number; 
    next: LLNode;
    constructor(val: number, next: LLNode = null){
        this.val = val;
        this.next = next;
    }
}
type LLNode = ListNode | null;

function linkedListReversal(head: LLNode): LLNode {
    let currNode: LLNode = head;
    let prevNode: LLNode = null;
    // Reverse the direction of each node's pointer until 'currNode' 
    // is null.
    while (currNode !== null){
        const nextNode: LLNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    // 'prevNode' will be pointing at the head of the reversed linked 
    // list.
    return prevNode;
}

