package Actividad;

import bstreelinklistinterfgeneric.LinkedBST;
import Exceptions.ItemDuplicated;

public class Prueba {
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

        
        System.out.println("Mínimo del árbol: " + bst.findMin()); // Esperado: 50
        System.out.println("Máximo del árbol: " + bst.findMax()); // Esperado: 700

    }
}