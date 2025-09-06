use std::cell::RefCell;
use std::rc::Rc;

#[derive(Debug)]
struct ListNode {
    val: i32,
    next: Option<Rc<RefCell<ListNode>>>,
}

impl ListNode {
    fn new(val: i32) -> Rc<RefCell<Self>> {
        Rc::new(RefCell::new(ListNode { val, next: None }))
    }
}

fn linked_list_intersection(
    head_a: Option<Rc<RefCell<ListNode>>>,
    head_b: Option<Rc<RefCell<ListNode>>>,
) -> Option<Rc<RefCell<ListNode>>> {
    let mut ptr_a = head_a.clone();
    let mut ptr_b = head_b.clone();
    // Traverse through list A with 'ptr_a' and list B with 'ptr_b'
    // until they meet.
    while ptr_a != ptr_b {
        // Traverse list A -> list B by first traversing 'ptr_a' and
        // then, upon reaching the end of list A, continue the
        // traversal from the head of list B.
        ptr_a = if let Some(node) = ptr_a {
            node.borrow().next.clone()
        } else {
            head_b.clone()
        };
        // Simultaneously, traverse list B -> list A.
        ptr_b = if let Some(node) = ptr_b {
            node.borrow().next.clone()
        } else {
            head_a.clone()
        };
    }
    // At this point, 'ptr_a' and 'ptr_b' either point to the
    // intersection node or both are null if the lists do not
    // intersect. Return either pointer.
    ptr_a
}
