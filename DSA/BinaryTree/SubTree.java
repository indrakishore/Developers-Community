public class SubTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSubTree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data ){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        boolean leftAns = isSubTree(root.left, subRoot);
        boolean rightAns = isSubTree(root.right, subRoot);

        return leftAns || rightAns;
    }

    public static boolean isIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }
        if(!isIdentical(root.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(root.right, subRoot.right)){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubTree(root, subRoot));
    }
}
