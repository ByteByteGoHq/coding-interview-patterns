public class MultiLevelListNode
{
    public MultiLevelListNode(
        int val, MultiLevelListNode next = null, MultiLevelListNode child = null)
    {
        Val = val;
        Next = next;
        Child = child;
    }

    public int Val { get; set; }

    public MultiLevelListNode Next { get; set; }
    
    public MultiLevelListNode Child { get; set; }
}
