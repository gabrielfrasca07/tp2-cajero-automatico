package model;

import java.util.ArrayList;

public class CuentaBancaria {

    private final String numeroCuenta;
    private double saldo;
    private String titular;
    private boolean activa;
    private ArrayList<String> historialTransacciones;

    public CuentaBancaria() {
        this.numeroCuenta = "";
        this.saldo = 0;
        this.titular = "";
        this.activa = true;
        this.historialTransacciones = new ArrayList<>();
    }

    public CuentaBancaria(String numeroCuenta, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.activa = true;
        this.historialTransacciones = new ArrayList<>();
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean isActiva() {
        return activa;
    }

    public ArrayList<String> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void agregarTransaccion(String transaccion) {
        historialTransacciones.add(transaccion);
    }

    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta +
                " | Titular: " + titular +
                " | Saldo: $" + saldo;
    }
}