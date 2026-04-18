package com.example;

import com.example.interfaces.Magico;
import com.example.interfaces.Volador;

public class Dragon extends Criatura implements Volador, Magico {
    private boolean hechizoAprendido;

    public Dragon(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void volar() {
        System.out.printf("%s despliega sus alas y se eleva sobre la arena.%n", getNombre());
    }

    @Override
    public void aterrizar() {
        System.out.printf("%s aterriza con poder y prepara un ataque.%n", getNombre());
    }

    public void rugir() {
        System.out.printf("%s ruge y asusta a su enemigo, reduciendo su fuerza temporalmente.%n", getNombre());
    }

    public void ataqueAereo(Criatura objetivo) {
        System.out.printf("%s lanza un ataque aéreo devastador sobre %s.%n", getNombre(), objetivo.getNombre());
        int daño = getFuerza() + 8;
        objetivo.defender(daño);
    }

    @Override
    public void aprenderHechizo() {
        hechizoAprendido = true;
        System.out.printf("%s ha aprendido un hechizo ancestral de fuego.%n", getNombre());
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        if (!hechizoAprendido) {
            System.out.printf("%s no conoce hechizos todavía y lanza un golpe físico.%n", getNombre());
            atacar(objetivo);
            return;
        }
        int daño = getFuerza() * 2;
        System.out.printf("%s invoca fuego dracónico contra %s y causa %d de daño mágico.%n", getNombre(), objetivo.getNombre(), daño);
        objetivo.defender(daño);
    }

    @Override
    public void atacar(Criatura objetivo) {
        Arma arma = getArmaEquipada();
        if (arma != null) {
            arma.atacarConArma(this, objetivo);
            return;
        }
        System.out.printf("%s ataca con sus garras de dragón.%n", getNombre());
        int daño = getFuerza() + 5;
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int mitigado = Math.max(daño - 4, 0);
        System.out.printf("%s utiliza su escamas para mitigar el daño: %d -> %d.%n", getNombre(), daño, mitigado);
        recibirDaño(mitigado);
    }
}
