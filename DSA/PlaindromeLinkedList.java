// Protocol.java
// Problem Statement:
// Given a singly linked list, determine if it is a palindrome. A linked list is considered a palindrome 
// if it reads the same backward as forward.

// Approach:
// 1. Traverse the linked list and store the values of the nodes in an ArrayList.
// 2. Use two pointers, one starting from the beginning and the other from the end of the ArrayList.
// 3. Compare the values at these pointers until they meet in the middle.
// 4. If all values are equal, the linked list is a palindrome; otherwise, it is not.

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right && list.get(left).equals(list.get(right))) {
            left++;
            right--;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean result = solution.isPalindrome(head);
        System.out.println("Is the given linked list a palindrome? " + result);
    }
}
