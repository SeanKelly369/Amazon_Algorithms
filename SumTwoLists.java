
 // Solution that is not accepted on Leetcode

* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * 
 */
class SumTwoLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder val1 = new StringBuilder();
        StringBuilder val2 = new StringBuilder();
        while(l1 != null) {
            val1.append(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            val2.append(l2.val);
            l2 = l2.next;
        }
        val1.reverse();
        val2.reverse();
        
        StringBuilder sum = new StringBuilder();
        
        String tempSum = String.valueOf(Long.valueOf(val1.toString()) + 
                                    Long.valueOf(val2.toString()));
        sum.append(tempSum).reverse();        
        String result = sum.toString();
        

        ListNode dummyHead = new ListNode(0);
        ListNode l3 = dummyHead;
        for (int i = 0; i < result.length(); ++i) {
            int tempDigit = Integer.valueOf(String.valueOf(result.charAt(i)));
            ListNode newNode = new ListNode(tempDigit);
            l3.next = newNode;
            l3 = l3.next;
        }
        return dummyHead.next;
    }
}}
