package main;

import pizza.Pizza;
import pizza.PizzaDelgada;
import pizza.PizzaIntegral;
import pizza.PizzaGruesa;
import excepciones.ExcepcionParametrosInvalidos;
import pizza.Tamano;

public class Main {
    public static void main(String[] args) {
        try {
            Pizza pizza1 = new PizzaDelgada(); // Selección del tipo de pizza
            Tamano tamano1 = Tamano.MEDIANA;
            // Preparar pizza con el tamaño especificado
            pizza1.prepararPizza(tamano1);

            Pizza pizza2 = new PizzaIntegral(); // Selección del tipo de pizza
            Tamano tamano2 = Tamano.PEQUENA;
            // Preparar pizza con el tamaño especificado
            pizza2.prepararPizza(tamano2);

            Pizza pizza3 = new PizzaGruesa(); // Selección del tipo de pizza
            Tamano tamano3 = Tamano.MEDIANA;
            // Preparar pizza con el tamaño especificado
            pizza3.prepararPizza(tamano3);

        } catch (ExcepcionParametrosInvalidos e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}