import { ListNode } from './ds';

/* Definition of ListNode:
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number){
        this.val = val;
        this.next = null;
    }
}*/

function removeKthLastNode(head: ListNode | null, k: number): ListNode | null {
    // A dummy node to ensure there's a node before 'head' in case we 
    // need to remove the head node.
    let dummy: ListNode | null = new ListNode(-1);
    dummy.next = head;
    let trailer: ListNode | null = dummy;
    let leader: ListNode | null = dummy;
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
        trailer = trailer!.next;
    }
    // Remove the kth node from the end.
    trailer!.next = trailer!.next!.next;
    return dummy.next;
}