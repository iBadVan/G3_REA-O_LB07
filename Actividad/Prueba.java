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
    }
}