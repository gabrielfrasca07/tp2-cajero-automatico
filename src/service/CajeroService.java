package service;

import model.*;
import exception.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CajeroService {

    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    // agregar cuenta
    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    // buscar cuenta
    public CuentaBancaria buscarCuenta(String numeroCuenta) {

        for (CuentaBancaria c : cuentas) {
            if (c.getNumeroCuenta().equals(numeroCuenta)) {
                return c;
            }
        }

        return null;
    }

    // depositar
    public void depositar(CuentaBancaria cuenta, double monto)
            throws CuentaInactivaException {

        if (!cuenta.isActiva()) {
            throw new CuentaInactivaException("La cuenta está inactiva");
        }

        if (monto <= 0) {
            System.out.println("Monto inválido");
            return;
        }

        cuenta.setSaldo(cuenta.getSaldo() + monto);

        StringBuilder log = new StringBuilder();

        log.append("[")
                .append(LocalDateTime.now())
                .append("] DEPOSITO: $")
                .append(monto)
                .append(" | Saldo: $")
                .append(cuenta.getSaldo());

        cuenta.agregarTransaccion(log.toString());

        System.out.println("Depósito realizado");
    }

    // extraer
    public void extraer(CuentaBancaria cuenta, double monto)
            throws SaldoInsuficienteException,
            LimiteExtraccionExcedidoException,
            CuentaInactivaException {

        if (!cuenta.isActiva()) {
            throw new CuentaInactivaException("Cuenta inactiva");
        }

        if (monto > 10000) {
            throw new LimiteExtraccionExcedidoException("Límite máximo: $10000");
        }

        if (cuenta.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        cuenta.setSaldo(cuenta.getSaldo() - monto);

        StringBuilder log = new StringBuilder();

        log.append("[")
                .append(LocalDateTime.now())
                .append("] EXTRACCION: $")
                .append(monto)
                .append(" | Saldo: $")
                .append(cuenta.getSaldo());

        cuenta.agregarTransaccion(log.toString());

        System.out.println("Extracción realizada");
    }

    // transferencia
    public void transferir(CuentaBancaria origen,
                           CuentaBancaria destino,
                           double monto)
            throws SaldoInsuficienteException,
            CuentaInactivaException,
            LimiteExtraccionExcedidoException {

        extraer(origen, monto);

        depositar(destino, monto);

        System.out.println("Transferencia realizada");
    }

    // consultar saldo
    public void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
    }

    // mostrar historial
    public void mostrarHistorial(CuentaBancaria cuenta) {

        System.out.println("=== HISTORIAL ===");

        ArrayList<String> historial = cuenta.getHistorialTransacciones();

        int inicio = Math.max(0, historial.size() - 10);

        for (int i = inicio; i < historial.size(); i++) {
            System.out.println(historial.get(i));
        }
    }
}