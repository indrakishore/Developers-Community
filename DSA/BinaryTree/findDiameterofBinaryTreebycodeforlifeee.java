
/*
PROBLEM STATEMENT: 

Given the root of the Binary Tree, return the length of it diameter,
the diameter of a binary tree is the longest distance between any two 
nodes of that tree. this path may or may not pass throught the root.


Brute Force Approach:
To find the diameter of a binary tree
Think every node as a potential Curving Point of the diameter path.

This Curving Point is the node along the diameter path that holds the maximum height and 
from where the path curves uphill and downhill.

Diameter = Height of the left subtree + Height of the right subtree + 1


Optimised Approach:
create diameter to store the maximum diameter encountered. at every node take
the maximum of this variable and the current diameter

create recursive function calculateHeight

recursively start traversing from the root, considering the current node to be
a potential curving point and for each node

return the maximum diameter



*/       
import java.util.*;

// Node structure for the binary tree
class Node {
    int data;
    Node left, right;

    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    // Global variable to store the diameter
    private int diameter = 0;

    // Function to calculate the height of a subtree
    private int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calculate the diameter at the current node and update the global variable
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Function to find the diameter of a binary tree
    public int diameterOfBinaryTree(Node root) {
        // Start the recursive traversal from the root
        calculateHeight(root);

        // Return the maximum diameter found during traversal
        return diameter;
    }
}

// Main function
public class findDiameterofBinaryTreebycodeforlifeee {
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calculate the diameter of the binary tree
        int diameter = solution.diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }
}
