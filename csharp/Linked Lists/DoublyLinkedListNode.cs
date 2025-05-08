public class DoublyLinkedListNode
{
    public DoublyLinkedListNode(int key, int val)
    {
        Key = key;
        Val = val;
        Prev = null;
        Next = null;
    }

    public int Key { get; set; }

    public int Val { get; set; }

    public DoublyLinkedListNode Prev { get; set; }

    public DoublyLinkedListNode Next { get; set; }
}
