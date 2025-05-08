public class LRUCache
{
	private readonly int _capacity;
	private readonly Dictionary<int, DoublyLinkedListNode> _hashMap;
	private readonly DoublyLinkedListNode _head;
	private readonly DoublyLinkedListNode _tail;

	public LRUCache(int capacity)
    {
		_capacity = capacity;

		// A hash map that maps keys to nodes
		_hashMap = new Dictionary<int, DoublyLinkedListNode>();
		
		// Initialize the head and tail dummy nodes and connect them to 
		// each other to establish a basic two-node doubly linked list.
		_head = new DoublyLinkedListNode(-1, -1);
		_tail = new DoublyLinkedListNode(-1, -1);		
		_head.Next = _tail;
		_tail.Prev = _head;
	}

	public int Get(int key)
	{
		if (!_hashMap.ContainsKey(key))
			return -1;

		// To make this key the most recently used, remove its node and 
		// re-add it to the tail of the linked list.
		removeNode(_hashMap[key]);
		addToTail(_hashMap[key]);

		return _hashMap[key].Val;
	}

	public void Put(int key, int value)
	{
		// If a node with this key already exists, remove it from the linked list.
		if (_hashMap.ContainsKey(key))
			removeNode(_hashMap[key]);

		DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
		_hashMap[key] = node;

		// Remove the least recently used node from the cache if adding
		// this new node will result in an overflow.
		if (_hashMap.Count > _capacity)
		{
			_hashMap.Remove(_head.Next.Key);
			removeNode(_head.Next);
		}

		addToTail(node);
	}

	private void addToTail(DoublyLinkedListNode node)
	{
		DoublyLinkedListNode prevNode = _tail.Prev;
		
		node.Prev = prevNode;
		node.Next = _tail;

		prevNode.Next = node;
		_tail.Prev = node;
	}

	private void removeNode(DoublyLinkedListNode node)
	{
		node.Prev.Next = node.Next;
		node.Next.Prev = node.Prev;
	}
}
