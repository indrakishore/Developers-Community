// File: protocol.java

/*
 * Problem Statement:
 * Given the root of a binary tree, the task is to find its maximum depth.
 * The maximum depth of a binary tree is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 * Write a function that returns the maximum depth of the binary tree.
 */

/*
 * Approach:
 * 1. If the root is null (i.e., the tree is empty), the depth is 0.
 * 2. Use a recursive approach:
 *    - If a node is null, return 0 (base case).
 *    - Recursively calculate the maximum depth of the left and right subtrees.
 *    - The depth of the current node is 1 plus the maximum of the depths of the left and right subtrees.
 * 3. This recursive solution will calculate the maximum depth by exploring all nodes of the binary tree.
 */

 import java.util.Scanner;

 // Definition of a TreeNode in the binary tree
 class TreeNode {
     int val;  // Value of the node
     TreeNode left;  // Reference to the left child
     TreeNode right;  // Reference to the right child
 
     // Constructor to initialize the node's value
     TreeNode(int val) {
         this.val = val;
         left = null;
         right = null;
     }
 }
 
 public class protocol {
 
     // Function to find the maximum depth of the binary tree
     public static int maxDepth(TreeNode root) {
         // Base case: if the current node is null, return 0
         if (root == null) {
             return 0;
         }
 
         // Recursively calculate the depth of the left and right subtrees
         int leftDepth = maxDepth(root.left);
         int rightDepth = maxDepth(root.right);
 
         // Return 1 plus the maximum of the left and right subtree depths
         return 1 + Math.max(leftDepth, rightDepth);
     }
 
     // Helper function to create a binary tree based on user input
     public static TreeNode createTree() {
         Scanner scanner = new Scanner(System.in);
 
         System.out.print("Enter value of node (-1 for no node): ");
         int value = scanner.nextInt();
 
         // If user enters -1, return null (no node)
         if (value == -1) {
             return null;
         }
 
         // Create the current node
         TreeNode node = new TreeNode(value);
 
         // Recursively create left and right subtrees
         System.out.println("Enter left child of " + value);
         node.left = createTree();
 
         System.out.println("Enter right child of " + value);
         node.right = createTree();
 
         return node;
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Create the binary tree by taking input from the user
         System.out.println("Create the binary tree:");
         TreeNode root = createTree();
 
         // Call the maxDepth function to calculate the maximum depth of the tree
         int depth = maxDepth(root);
 
         // Print the result
         System.out.println("The maximum depth of the binary tree is: " + depth);
 
         scanner.close();  // Close the scanner to avoid resource leaks
     }
 }
 