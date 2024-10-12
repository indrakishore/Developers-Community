/* 
Problem Statement:
Given an array of k sorted linked lists, merge them into one sorted linked list. If the input list is empty or contains only empty lists, return null.

Example:
Input:
lists = [[1->4->5], [1->3->4], [2->6]]
Output:
[1->1->2->3->4->4->5->6]

Approach:
Divide and Conquer: Recursively divide the array of linked lists into two halves and merge them.
Merge Two Lists: Use a helper function to merge two sorted linked lists by comparing node values.
Time Complexity: O(n log k), where n is the total number of nodes and k is the number of linked lists.
Space Complexity: O(log k) due to recursion depth.
Steps:
If lists is empty, return null.
Recursively merge linked lists using the helper mergeKListsHelper.
Use the merge function to merge two lists by comparing nodes one by one.
This approach efficiently merges k lists with minimal time complexity.
*/



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}
