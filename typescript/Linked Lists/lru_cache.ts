class DoublyLinkedListNode {
    key: number; val: number; 
    prev: DoublyLinkedListNode | null; 
    next: DoublyLinkedListNode | null;
    
    constructor(key: number, val: number) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    capacity: number;
    hashmap: Map<number, DoublyLinkedListNode>;
    head: DoublyLinkedListNode; tail: DoublyLinkedListNode;
    
    constructor(capacity: number) {
        this.capacity = capacity;
        // A hash map that maps keys to nodes.
        this.hashmap = new Map();
        // Initialize the head and tail dummy nodes and connect them to 
        // each other to establish a basic two-node doubly linked list.
        this.head = new DoublyLinkedListNode(-1, -1);
        this.tail = new DoublyLinkedListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    get(key: number): number {
        if (!this.hashmap.has(key))
            return -1;
        // To make this key the most recently used, remove its node and 
        // re-add it to the tail of the linked list.
        const node = this.hashmap.get(key)!;
        this.removeNode(node);
        this.addToTail(node);
        return node.val;
    }

    put(key: number, val: number): void {
        // If a node with this key already exists, remove it from the 
        // linked list.
        if (this.hashmap.has(key))
            this.removeNode(this.hashmap.get(key)!);
        const node = new DoublyLinkedListNode(key, val);
        this.hashmap.set(key, node);
        // Remove the least recently used node from the cache if adding 
        // this new node will result in an overflow.
        if (this.hashmap.size > this.capacity) {
            this.hashmap.delete(this.head.next!.key);
            this.removeNode(this.head.next!);
        }
        this.addToTail(node);
    }

    addToTail(node: DoublyLinkedListNode): void {
        const prevNode = this.tail.prev;
        node.prev = prevNode;
        node.next = this.tail;
        prevNode!.next = node;
        this.tail.prev = node;
    }

    removeNode(node: DoublyLinkedListNode): void {
        node.prev!.next = node.next;
        node.next!.prev = node.prev;
    }
}
