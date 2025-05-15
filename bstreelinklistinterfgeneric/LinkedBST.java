package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import Exceptions.ExceptionIsEmpty;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    class Node {
        public E data;
        public Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(data, root);
    }

    private Node insert(E data, Node node) throws ItemDuplicated {
        if (node == null)
            return new Node(data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = insert(data, node.left);
        else if (cmp > 0)
            node.right = insert(data, node.right);
        else
            throw new ItemDuplicated("Elemento duplicado: " + data);
        return node;
    }

    @Override
    public E search(E data) throws ItemNoFound {
        return search(data, root);
    }

    private E search(E data, Node node) throws ItemNoFound {
        if (node == null)
            throw new ItemNoFound("Elemento no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            return search(data, node.left);
        else if (cmp > 0)
            return search(data, node.right);
        else
            return node.data;
    }



}