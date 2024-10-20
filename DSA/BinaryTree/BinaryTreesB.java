public class BinaryTreesB{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        // here we will return the root of the binary trees
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
    } 
    // Time complexity of this code is O(N);

    //Pre - order subtree Traversal
    //Step1 -> print the root Node 
    // Step 2 -> Print the subh leftTree
    // Step 3 -> Print the subh right Tree.
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //Time complexity of this code is - O(N);

    //Inorder SubTree
    // Step1 -> Print the left Subtree
    // Step 2 -> Print the root
    // Step 3 -> Print the right subtree
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }

    // Postorder Tree Traversals
    //Step1 -> Print the left subtree
    // Step2 -> Print the right subtree
    // Step 3 -> Print the root

    public static void Postorder(Node root){
        if(root == null){
            return;
        }

        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data +" ");
    }
    // Time complexity of this code will be O(N);

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // preOrder(root);

        // inOrder(root);

        Postorder(root);
    }
}
