/* Definition of ListNode:
class ListNode {
    val: number; next: ListNode | null;
    constructor(val: number) {
        this.val = val;
        this.next = null;
    }
}    
*/

function linkedListLoopNaive(head: ListNode): boolean {
    const visited: Set<ListNode> = new Set();
    let curr: ListNode | null = head;
    while (curr !== null) {
        // Cycle detected if the current node has already been visited.
        if (visited.has(curr))
            return true;
        visited.add(curr);
        curr = curr.next;
    }
    return false;
}
