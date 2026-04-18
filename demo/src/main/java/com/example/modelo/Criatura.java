package com.example.modelo;

public abstract class Criatura {
    private final String nombre;
    private int salud;
    private final int fuerza;
    private Arma armaEquipada;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(salud, 1);
        this.fuerza = Math.max(fuerza, 1);
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void equiparArma(Arma arma) {
        if (arma == null) {
            return;
        }
        this.armaEquipada = arma;
        System.out.printf("%s ha equipado un arma: %s.%n", nombre, arma.getNombre());
    }

    public void desequiparArma() {
        if (armaEquipada != null) {
            System.out.printf("%s desequipa su arma: %s.%n", nombre, armaEquipada.getNombre());
        }
        armaEquipada = null;
    }

    public boolean estaViva() {
        return salud > 0;
    }

    public void recibirDaño(int daño) {
        salud = Math.max(salud - daño, 0);
        System.out.printf("%s ahora tiene %d salud.%n", nombre, salud);
    }

    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int daño);
}
