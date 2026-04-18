package com.example;

import com.example.modelo.Arma;
import com.example.modelo.Dragon;
import com.example.modelo.Guerrero;
import com.example.modelo.Mago;
import com.example.simulador.Simulador;

public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Hércules", 40, 8);
        Dragon dragon = new Dragon("Fénix", 35, 7);
        Mago mago = new Mago("Merlín", 28, 6);

        guerrero.equiparArma(new Arma("Espada Larga", 4, 1));
        dragon.equiparArma(new Arma("Garra de Dragón", 3, 2));

        System.out.println("=== Batalla 1: Guerrero vs Dragon ===");
        Simulador.simularBatalla(guerrero, dragon);

        System.out.println("\n=== Batalla 2: Dragon vs Mago ===");
        Dragon dragon2 = new Dragon("Azrael", 32, 6);
        Mago mago2 = new Mago("Galadriel", 30, 7);
        Simulador.simularBatalla(dragon2, mago2);
    }
}
