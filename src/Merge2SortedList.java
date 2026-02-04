/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */
// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Brute force: collect all values into array, sort, build new list
        java.util.ArrayList<Integer> values = new java.util.ArrayList<>();

        // Collect values from list1
        ListNode curr1 = list1;
        while (curr1 != null) {
            values.add(curr1.val);
            curr1 = curr1.next;
        }

        // Collect values from list2
        ListNode curr2 = list2;
        while (curr2 != null) {
            values.add(curr2.val);
            curr2 = curr2.next;
        }

        // Sort the values
        java.util.Collections.sort(values);

        // Build new sorted list
        if (values.isEmpty()) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create list1: 1->2->4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create list2: 1->3->4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = solution.mergeTwoLists(list1, list2);

        // Print result
        System.out.print("Merged list: ");
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();  // Output: Merged list: 1 1 2 3 4 4
    }
}

