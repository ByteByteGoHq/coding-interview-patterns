#[derive(Debug)]
struct ListNode {
    val: i32,
    next: Option<Box<ListNode>>,
}

impl ListNode {
    fn new(val: i32) -> Self {
        ListNode {
            val,
            next: None,
        }
    }
}

fn linked_list_reversal(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut curr_node = head;
    let mut prev_node = None;

    // Reverse the direction of each node's pointer until 'curr_node'
    // is null.
    while let Some(mut current) = curr_node {
        let next_node = current.next.take();
        current.next = prev_node;
        prev_node = Some(current);
        curr_node = next_node;
    }

    // 'prev_node' will be pointing at the head of the reversed linked
    // list.
    prev_node
}