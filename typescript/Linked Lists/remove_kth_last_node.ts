/* Definition of ListNode: */
// class ListNode {
//     val: number; 
//     next: LLNode;
//     constructor(val: number){
//         this.val = val;
//         this.next = null;
//     }
// }
// type LLNode = ListNode | null;

function removeKthLastNode(head: LLNode, k: number): LLNode {
    // If k is less than or equal to 0, no node needs to be removed.
    if (k <= 0) 
        return head;
    // A dummy node to ensure there's a node before 'head' in case we 
    // need to remove the head node.
    let dummy: LLNode = new ListNode(-1);
    dummy.next = head;
    let trailer: LLNode = dummy, leader: LLNode = dummy;
    // Advance 'leader' k steps ahead.  
    for (let i = 0; i < k; i++){
        leader = leader.next;
        // If k is larger than the length of the linked list, no node 
        // needs to be removed.
        if (leader === null) 
            return head;
    }
    // Move 'leader' to the end of the linked list, keeping 'trailer'
    // k nodes behind.
    while (leader.next !== null){
        leader = leader.next;
        trailer = trailer.next;
    }
    // Remove the kth node from the end.
    trailer.next = trailer.next.next;
    return dummy.next;
}