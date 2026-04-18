package com.example.simulador;

import com.example.interfaces.Magico;
import com.example.interfaces.Volador;
import com.example.modelo.Arma;
import com.example.modelo.Criatura;
import com.example.modelo.Dragon;
import com.example.modelo.Guerrero;
import com.example.modelo.Mago;

public class Simulador {
    public static void simularBatalla(Criatura atacante, Criatura defensor) {
        int ronda = 1;
        while (atacante.estaViva() && defensor.estaViva()) {
            System.out.printf("\n--- Ronda %d ---\n", ronda);
            ejecutarAccion(atacante, defensor, ronda);
            if (!defensor.estaViva()) {
                System.out.printf("%s ha ganado la batalla.%n", atacante.getNombre());
                break;
            }

            ejecutarAccion(defensor, atacante, ronda);
            if (!atacante.estaViva()) {
                System.out.printf("%s ha ganado la batalla.%n", defensor.getNombre());
                break;
            }

            mostrarEstado(atacante);
            mostrarEstado(defensor);
            ronda++;
        }
    }

    private static void ejecutarAccion(Criatura atacante, Criatura defensor, int ronda) {
        if (atacante instanceof Dragon) {
            Dragon dragon = (Dragon) atacante;
            if (ronda % 3 == 0) {
                dragon.volar();
                dragon.ataqueAereo(defensor);
                return;
            }
            dragon.lanzarHechizo(defensor);
            return;
        }

        if (atacante instanceof Mago) {
            Mago mago = (Mago) atacante;
            if (ronda % 2 == 0) {
                mago.invocarEscudo();
            }
            mago.lanzarHechizo(defensor);
            return;
        }

        if (atacante instanceof Guerrero) {
            Guerrero guerrero = (Guerrero) atacante;
            if (ronda % 2 == 0) {
                guerrero.embestida(defensor);
                return;
            }
            guerrero.atacar(defensor);
            return;
        }

        if (atacante instanceof Magico) {
            ((Magico) atacante).lanzarHechizo(defensor);
            return;
        }

        if (atacante instanceof Volador) {
            ((Volador) atacante).volar();
            atacante.atacar(defensor);
            return;
        }

        atacante.atacar(defensor);
    }

    private static void mostrarEstado(Criatura criatura) {
        System.out.printf("%s - Salud: %d\n", criatura.getNombre(), criatura.getSalud());
    }
}
