// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


package LeetCode.자료구조;

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
/*
class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry=sum/10;

        ListNode node = new ListNode(sum>=10 ? sum-10 : sum);
        ListNode res = node; // head

        // ListNode result = new ListNode();
        l1 = l1.next;
        l2 = l2.next;

        while(l1!=null && l2!=null) {
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            // System.out.printf("add : %d, carry : %d\n",sum%10, carry);
            node.next = new ListNode(sum>=10 ? sum-10 : sum);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null) {
            sum = l1.val + carry;
            carry = sum/10;
            // System.out.printf("add : %d, carry : %d\n",sum%10, carry);
            node.next = new ListNode(sum>=10 ? sum-10 : sum);
            node = node.next;
            l1 = l1.next;
        }

        while(l2!=null) {
            sum = l2.val + carry;
            carry = sum/10;
            node.next = new ListNode(sum>=10 ? sum-10 : sum);
            node = node.next;
            l2 = l2.next;
        }

        if (carry!=0) {
            node.next = new ListNode(1);
        }
        // System.out.printf("is null ? %d\n",node.next.next==null ? 1 : 0);

        return res;
    }
}*/

// head = node1(0 != null) -> node2 -> node3

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                node.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                node.next = new ListNode(sum);
                carry = 0;
            }

            node = node.next;
        }

        if (carry == 1) {
            node.next = new ListNode(1);
        }

        return result.next; ㄷㄷ
    }
}
*/


