package algorithm;

/**
 * @author ZC_Wu 汐
 * @date 2025/6/1 14:11
 * @description
 */
public class A2Solution {
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

        A2Solution a2Solution = new A2Solution();
        ListNode numlistNode = a2Solution.addTwoNumbers(listNode, listNode3);
        System.out.println(numlistNode);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 1;
        int l1sum = 0;
        int l2sum = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l1.val != 0) {
                l1sum += l1.val * i;
                l1 = l1.next;
            }
            if (l2 != null && l2.val != 0) {
                l2sum += l2.val * i;
                l2 = l2.next;
            }
            i *= 10;
        }
        sum = l1sum + l2sum;
        String numStr = Integer.toString(sum);
        int[] res = new int[numStr.length()];
        int l = 0;
        for (int k = numStr.length()-1; k >= 0; k--, l++) {
            res[l] = Character.getNumericValue(numStr.charAt(k));
        }
        return buildListFromArray(res);
    }
    public static ListNode buildListFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1); // 虚拟头节点
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next; // 返回真正的头节点
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}