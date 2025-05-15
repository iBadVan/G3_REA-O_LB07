package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

import java.util.LinkedList;
import java.util.Queue;

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
    
    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El árbol está vacío");
        root = delete(data, root);
    }
    private Node delete(E data, Node node) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = delete(data, node.left);
        else if (cmp > 0)
            node.right = delete(data, node.right);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = findMin(node.right);
            node.data = min.data;
            node.right = delete(min.data, node.right);
        }
        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }


    //INORDEN
    public void showInOrder() {
    System.out.print("In-Orden: ");
    inOrder(root);
    System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    //PREORDER
    public void showPreOrder() {
    System.out.print("Pre-Orden: ");
    preOrder(root);
    System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //POSTORDER
    public void showPostOrder() {
    System.out.print("Post-Orden: ");
    postOrder(root);
    System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // ENCONTRAR EL MINIMO

    public E findMin() throws ItemNoFound {
        if (isEmpty()) {
            throw new ItemNoFound("El árbol está vacío");
        }
        return findMinNode(root);
    }

    private E findMinNode(Node node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El subárbol está vacío");
        }
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return search(current.data);
    }

    //ENCONTRAR EL MAXIMO

    public E findMax() throws ItemNoFound {
        if (isEmpty()) {
            throw new ItemNoFound("El árbol está vacío");
        }
        return findMaxNode(root);
    }

    private E findMaxNode(Node node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El subárbol está vacío");
        }
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return search(current.data);
    }

    //METODO PARA ELIMINAR ALL IN
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío, no hay nodos para eliminar.");
        }
        root = null; 
    }

    //CONTAR TODOS LOS NODOS
    public int countAllNodes() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El árbol está vacío.");
        return countAllNodes(root);
    }

    private int countAllNodes(Node node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    //CONTAR SIN HOJAS
    public int countNodes() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El árbol está vacío.");
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    //Encontrar nodo x iterativo
    private Node findNodeIterative(E x) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data.equals(x)) return current;
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return null;
    }

    //Metodo de ALTURA
    public int height(E x) {
        Node subRoot = findNodeIterative(x);
        if (subRoot == null) return -1;
        return heightIterative(subRoot);
    }

    //Calculo iterativo de ALTURA
    private int heightIterative(Node node) {
        if (node == null) return -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int height = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return height;
    }

    //ENCONTRAR AMPLITUD
    public int amplitude(int nivel) {
        int h = height(root.data);  
        if (nivel < 0 || nivel > h) {
            return 0; 
        }
        return countNodesAtLevel(root, nivel);
    }
    //contar cant nodos segun nivel
    private int countNodesAtLevel(Node node, int nivel) {
        if (node == null) return 0;
        if (nivel == 0) return 1;
        return countNodesAtLevel(node.left, nivel - 1) + countNodesAtLevel(node.right, nivel - 1);
    }

}