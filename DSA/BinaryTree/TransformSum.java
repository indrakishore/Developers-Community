public class TransformSum {
    static class Node {
        int data;
        Node left, right;
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int transformSumTree(Node root){
        if(root == null){
            return 0;
        }
        
        int leftChild = transformSumTree(root.left);
        int rightChild = transformSumTree(root.right);

        int data = root.data;
        root.data = root.left.data + leftChild + root.right.data + rightChild;
        return data;
    } 
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(transformSumTree(root));

    }
}
