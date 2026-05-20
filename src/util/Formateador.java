package util;

public class Formateador {
    public static String formatearMonto(double monto) {
        return String.format("$%,.2f", monto);
    }

    public static String buildLog(String tipo, double monto, double saldoResultante) {
        StringBuilder sb = new StringBuilder();
        sb.append(tipo).append(": ").append(formatearMonto(monto));
        sb.append(" | Saldo: ").append(formatearMonto(saldoResultante));
        return sb.toString();
    }
}