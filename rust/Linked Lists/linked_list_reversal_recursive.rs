#[derive(Debug)]
struct ListNode {
    val: i32,
    next: Option<Box<ListNode>>,
}

impl ListNode {
    fn new(val: i32) -> Self {
        ListNode { val, next: None }
    }
}

fn linked_list_reversal_recursive(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    // Base cases.
    if head.is_none() || head.as_ref().unwrap().next.is_none() {
        return head;
    }
    // Recursively reverse the sublist starting from the next node.
    let mut current = head.unwrap();
    let next = current.next.take();
    let new_head = linked_list_reversal_recursive(next);
    // Connect the reversed linked list to the head node to fully
    // reverse the entire linked list.
    if let Some(mut next_node) = new_head {
        next_node.next = Some(current);
        Some(next_node)
    } else {
        Some(current)
    }
}
