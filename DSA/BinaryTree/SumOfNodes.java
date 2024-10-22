public class SumOfNodes {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(sumNodes(root));
    }
}
