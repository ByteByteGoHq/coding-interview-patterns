// Definition of ListNode:
class ListNode {
    val: number; 
    next: TNode;
    constructor(val: number, next: TNode = null){
        this.val = val;
        this.next = next;
    }
}
type TNode = ListNode | null;

function linked_list_reversal(head: TNode): TNode {
    let curr_node: TNode = head;
    let prev_node: TNode = null;
    // Reverse the direction of each node's pointer until 'curr_node' 
    // is null.
    while (curr_node !== null){
        const next_node: TNode = curr_node.next;
        curr_node.next = prev_node;
        prev_node = curr_node;
        curr_node = next_node;
    }
    // 'prev_node' will be pointing at the head of the reversed linked 
    // list.
    return prev_node;
}

