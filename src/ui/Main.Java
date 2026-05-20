package ui;

import model.*;
import service.*;
import exception.*;

public class Main {

    public static void main(String[] args) {

        CajeroService cajero = new CajeroService();

        // CREAR CUENTAS
        CuentaBancaria c1 = new CuentaBancaria("001", 5000, "Juan");
        CuentaBancaria c2 = new CuentaBancaria("002", 12000, "Ana");
        CuentaBancaria c3 = new CuentaBancaria("003", 8000, "Pedro");

        // AGREGAR CUENTAS
        cajero.agregarCuenta(c1);
        cajero.agregarCuenta(c2);
        cajero.agregarCuenta(c3);

        try {

            // OPERACIONES
            cajero.depositar(c1, 2000);

            cajero.extraer(c1, 1000);

            cajero.transferir(c2, c3, 3000);

            cajero.consultarSaldo(c1);

            // EXCEPCIÓN: saldo insuficiente
            cajero.extraer(c1, 20000);

        } catch (SaldoInsuficienteException e) {

            System.out.println("ERROR: " + e.getMessage());

        } catch (LimiteExtraccionExcedidoException e) {

            System.out.println("ERROR: " + e.getMessage());

        } catch (CuentaInactivaException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        // DESACTIVAR CUENTA
        c3.setActiva(false);

        try {

            // EXCEPCIÓN: cuenta inactiva
            cajero.depositar(c3, 500);

        } catch (CuentaInactivaException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        // MOSTRAR HISTORIAL
        cajero.mostrarHistorial(c1);

    }
}                                   