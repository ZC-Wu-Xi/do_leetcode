package algorithm;

import java.nio.file.Path;

/**
 * @author ZC_Wu 汐
 * @date 2025/6/1 15:42
 * @description
 */
public class A2Solution2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(7);
        ListNode listNode6 = new ListNode(8);
        ListNode listNode7 = new ListNode(9);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        int v=0;
        A2Solution2 a2Solution2 = new A2Solution2();
        ListNode numlistNode = a2Solution2.addTwoNumbers(listNode, listNode3);
        System.out.println(numlistNode);

        ListNode numlistNode2 = a2Solution2.addTwoNumbers2(listNode, listNode3);
        System.out.println(numlistNode2);
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @param v 是否进位
     * @return
     */
    int v = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && v == 0) return null;
        int v1 = 0;
        int v2 = 0;
        if (l1 != null) v1 = l1.val;
        if (l2 != null) v2 = l2.val;
        int val = v1 + v2 + v;
        ListNode node = null;
        node = new ListNode(val % 10);
        v = val / 10;
        node.next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null);
        return node;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}
