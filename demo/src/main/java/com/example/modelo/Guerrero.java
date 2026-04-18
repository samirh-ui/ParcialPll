package com.example.modelo;

public class Guerrero extends Criatura {

    public Guerrero(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    public void embestida(Criatura objetivo) {
        System.out.printf("%s carga contra %s con una embestida poderosa.%n", getNombre(), objetivo.getNombre());
        int daño = getFuerza() + 6;
        objetivo.defender(daño);
    }

    @Override
    public void atacar(Criatura objetivo) {
        Arma arma = getArmaEquipada();
        if (arma != null) {
            arma.atacarConArma(this, objetivo);
            return;
        }
        System.out.printf("%s ataca con su espada y experiencia en combate.%n", getNombre());
        int daño = getFuerza() + 4;
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int mitigado = Math.max(daño - 3, 0);
        System.out.printf("%s levanta su escudo y se defiende, reduciendo el daño a %d.%n", getNombre(), mitigado);
        recibirDaño(mitigado);
    }
}