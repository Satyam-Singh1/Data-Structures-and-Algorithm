class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        int length = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }


        curr.next = head;

        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = curr;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

       
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
