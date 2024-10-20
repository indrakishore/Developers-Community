

// Problem Statement:
// Find the height (or depth) of a binary tree using level order traversal (breadth-first search).
// The height of a binary tree is defined as the number of edges on the longest path from the root to a leaf node.
// The root node is considered to be at height 0.
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left, right;

    // Constructor to create a new Node with a given key value
    Node(int val) {
        key = val;
        left = null;
        right = null;
    }
}

class Height {

    // Function to calculate the height of the binary tree using level order traversal
    static int findHeight(Node root) {
        // Base case: if the tree is empty, return 0
        if (root == null) return 0;

        int depth = 0;  // Variable to store the height of the tree

        // Queue to perform level order traversal
        Queue<Node> q = new LinkedList<>();

        // Start by adding the root node to the queue, followed by a null marker
        q.add(root);
        q.add(null);  // Null marks the end of each level in the tree

        // Perform level order traversal to calculate height
        while (!q.isEmpty()) {
            Node curr = q.poll();  // Remove the front element from the queue

            // If a null is encountered, it signifies the end of a level
            if (curr == null) {
                depth++;  // Increase the depth (i.e., height) by 1 as a level is completed

                // If there are more nodes left to process in the queue, add a null marker for the next level
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                // Add the left and right children of the current node to the queue if they exist
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return depth;  // Return the height (depth) of the binary tree
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5   
        Node root = new Node(1);  // Root node
        root.left = new Node(2);  // Left child of root
        root.right = new Node(3);  // Right child of root
        root.left.left = new Node(4);  // Left child of node 2
        root.left.right = new Node(5);  // Right child of node 2

        // Print the height of the tree
        System.out.println(findHeight(root));  // Expected output: 3
    }
}
