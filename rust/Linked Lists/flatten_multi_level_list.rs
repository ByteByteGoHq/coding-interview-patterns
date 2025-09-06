#[derive(Debug)]
struct MultiLevelListNode {
    val: i32,
    next: Option<Box<MultiLevelListNode>>,
    child: Option<Box<MultiLevelListNode>>,
}

impl MultiLevelListNode {
    fn new(val: i32) -> Self {
        MultiLevelListNode {
            val,
            next: None,
            child: None,
        }
    }
}

fn flatten_multi_level_list(
    head: Option<Box<MultiLevelListNode>>,
) -> Option<Box<MultiLevelListNode>> {
    if head.is_none() {
        return None;
    }
    let mut head = head;
    let mut tail = head.as_mut().unwrap();
    // Find the tail of the linked list at the first level.
    while let Some(ref next) = tail.next {
        tail = tail.next.as_ref().unwrap();
    }
    let mut curr = head.as_mut().unwrap();
    // Process each node at the current level. If a node has a child linked list,
    // append it to the tail and then update the tail to the end of the extended
    // linked list. Continue until all nodes at the current level are processed.
    while let Some(ref mut current) = curr.next {
        if let Some(child) = current.child.take() {
            tail.next = Some(child);
            // Update tail to the end of the child list
            while let Some(ref next) = tail.next {
                tail = tail.next.as_ref().unwrap();
            }
        }
        curr = current;
    }
    head
}
