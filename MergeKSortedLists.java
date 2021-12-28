
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
      Queue<Integer> queue = new PriorityQueue<>();
        
        for(ListNode node: lists) {
            while(node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        
        if (queue.isEmpty()) {
            return null;
        }
        
        ListNode result = new ListNode(queue.poll());
        ListNode copy = result;
        
        while(!queue.isEmpty()) {
            copy.next = new ListNode(queue.poll());
            copy = copy.next;
        }
        
        return result;
    }
}
