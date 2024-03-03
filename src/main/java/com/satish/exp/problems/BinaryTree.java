package com.satish.exp.problems;

import lombok.Data;

public class BinaryTree {
    private Node root;

    @Data
    public static class Node {
        private int data;
        private Node left, right;
        public Node(int data){
            this.data=data;
        }

        @Override
        public int hashCode(){
            return data;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            if(obj == null || obj.getClass() != this.getClass())
                return false;
            Node node = (Node) obj;
            if(node.data == this.data && node.left.equals(this.left) && node.right.equals(this.right))
                return false;
            return true;
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(6);
        tree.root.left.left.right.left = new Node(7);

        System.out.println(maxDepth(tree.root));
    }

    private static int maxDepth(Node node){
        if(node == null)
            return 0;
        System.out.println("data: " + node.data);
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private static int findNodeDepth(Node node, int data){
        if(node == null)
            return -1;
        if(node.data == data)
            return 0;
        return 0;
    }


}
