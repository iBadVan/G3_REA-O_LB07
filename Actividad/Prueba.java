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



    }
}