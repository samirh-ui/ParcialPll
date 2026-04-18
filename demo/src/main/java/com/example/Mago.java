package com.example;

import com.example.interfaces.Magico;

public class Mago extends Criatura implements Magico {
    private boolean hechizoAprendido;

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void aprenderHechizo() {
        hechizoAprendido = true;
        System.out.printf("%s aprende un hechizo de rayo de energía.%n", getNombre());
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        if (!hechizoAprendido) {
            System.out.printf("%s no conoce hechizos y lanza un ataque básico.%n", getNombre());
            atacar(objetivo);
            return;
        }
        int daño = getFuerza() * 3;
        System.out.printf("%s lanza un hechizo de rayo contra %s y causa %d de daño mágico.%n", getNombre(), objetivo.getNombre(), daño);
        objetivo.defender(daño);
    }

    public void invocarEscudo() {
        System.out.printf("%s invoca un escudo arcano para reducir el daño recibido esta ronda.%n", getNombre());
    }

    @Override
    public void atacar(Criatura objetivo) {
        System.out.printf("%s ataca con un bastón mágico contra %s.%n", getNombre(), objetivo.getNombre());
        int daño = getFuerza() + 3;
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int mitigado = Math.max(daño - 2, 0);
        System.out.printf("%s conjura una barrera y reduce el daño a %d.%n", getNombre(), mitigado);
        recibirDaño(mitigado);
    }
}
