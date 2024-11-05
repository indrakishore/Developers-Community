// problem :- Vertical order Traversal of a Binary Tree

// approach :- 
// use a HashMap to store all nodes at a particular vertical level
// hd to keep track of level
// min and max to get minimum and maximum levels in tree
// queue to keep track of node and its level

// solution :-

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class VerticalOrderTraversal {
    public static class Node {
        int data;
        Node left , right;

        public Node (int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Pair {
        Node node;
        int level;

        public Pair (Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void verticalTraversal (Node root) {
        if (root == null) return;

        Map<Integer , List<Integer>> map = new HashMap<>();
        int hd = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root ,  hd));

        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node n = p.node;
            hd = p.level;

            map.putIfAbsent(hd, new ArrayList<>()).add(n.data);

            if (n.left != null) q.add(new Pair(n.left, hd-1));
            if (n.right != null) q.add(new Pair(n.right, hd+1));

            min = Math.min(min , hd);
            max = Math.max(max , hd);
        }

        for (int i = min; i <= max; i++) {
            List<Integer> lst = map.get(i);
            for (int key : lst) {
                System.out.println(key);
            }
        }
    }
}
