public class Diameter {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Approach 1 -> // Time complexity will be O(N^2)

        // public static int height(Node root) {
        // if (root == null) {
        // return 0;
        // }

        // int LeftHeight = height(root.left);
        // int RightHeight = height(root.right);

        // int maxHeight = Math.max(LeftHeight, RightHeight) + 1;
        // return maxHeight;
        // }

        // // Approach 1 -> calculate recursively

        // public static int diameterOfBinaryTree(Node root) {
        // if (root == null) {
        // return 0;
        // }

        // int LeftDiamater = diameterOfBinaryTree(root.left);
        // int rightDiameter = diameterOfBinaryTree(root.right);
        // int leftHeight = height(root.left);
        // int rightHeight = height(root.right);

        // int self = leftHeight + rightHeight + 1;

        // return Math.max(self, Math.max(LeftDiamater, rightDiameter));
        // }

        // Approach 2 -> O(N)
        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root) {
            // Base case: If the node is null, diameter and height are 0
            if (root == null) {
                return new Info(0, 0);
            }

            // Recursively get the left and right subtree info
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            // Calculate the diameter: maximum of:
            // 1. The diameter of the left subtree
            // 2. The diameter of the right subtree
            // 3. The path passing through the root, which is the sum of heights of left and
            // right subtrees + 1
            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

            // Calculate the height: maximum height of the left or right subtree + 1
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            // Return the current Info object with the calculated diameter and height
            return new Info(diam, ht);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(diameterOfBinaryTree(root));
    }
}
