package Actividad;

import bstreelinklistinterfgeneric.LinkedBST;
import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public class Prueba {
    //COMPARACION DE 2 AREAS
    public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> tree1, LinkedBST<E> tree2) {
        try {
            int area1 = tree1.areaBST();
            int area2 = tree2.areaBST();
            return area1 == area2;
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: Uno de los árboles está vacío.");
            return false;
        }
    }
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();
        int[] datos = {400, 100, 700, 50, 200, 75};

        try {
            for (int valor : datos) {
                bst.insert(valor);
            }
        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
        bst.showInOrder();    
        bst.showPreOrder();   
        bst.showPostOrder();  

        try {
        System.out.println("Mínimo del árbol: " + bst.findMin()); 
        System.out.println("Máximo del árbol: " + bst.findMax());   
        } catch (ItemNoFound e){
            System.out.println("Error: " + e.getMessage());
        }

        LinkedBST<Integer> bst1 = new LinkedBST<>();
        LinkedBST<Integer> bst2 = new LinkedBST<>();

        try {
            // Insertar datos en bst1
            bst1.insert(50);
            bst1.insert(30);
            bst1.insert(70);
            bst1.insert(20);
            bst1.insert(40);
            bst1.insert(60);
            bst1.insert(80);

            // Insertar datos en bst2
            bst2.insert(15);
            bst2.insert(10);
            bst2.insert(25);
            bst2.insert(5);
            bst2.insert(12);
            bst2.insert(22);
            bst2.insert(27);

            // Comparar áreas
            boolean result = sameArea(bst1, bst2);
            System.out.println("¿Los árboles tienen la misma área? " + result);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        LinkedBST<Integer> elarbol2 = new LinkedBST<>();
        try {
            elarbol2.insert(50);
            elarbol2.insert(30);
            elarbol2.insert(70);
            elarbol2.insert(20);
            elarbol2.insert(40);
            elarbol2.insert(60);
            elarbol2.insert(80);

            System.out.println("Representación del BST con parenthesize:");
            elarbol2.parenthesize();

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}