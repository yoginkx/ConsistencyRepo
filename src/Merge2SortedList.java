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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Merge2SortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Brute force: collect all values into ArrayList
        List<Integer> values = new ArrayList<>();

        // Traverse list1 and add values
        ListNode curr = list1;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        // Traverse list2 and add values
        curr = list2;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        // Sort the values
        Collections.sort(values);

        // Build new sorted linked list
        if (values.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(values.get(0));
        ListNode tail = head;
        for (int i = 1; i < values.size(); i++) {
            tail.next = new ListNode(values.get(i));
            tail = tail.next;
        }

        return head;
    }
}
