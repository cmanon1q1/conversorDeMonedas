import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsultaTipoDeMoneda consultaTipoDeMoneda = new ConsultaTipoDeMoneda();

    private final Set<String> monedasValidas = new HashSet<>(Set.of(
            "USD", "EUR", "MXN", "JPY", "GBP", "BRL", "CAD", "CHF", "CNY", "ARS"
    ));

    public void mostrarMenu() {
        System.out.println("****** Conversor de Monedas con API *****");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMonedas disponibles: " + monedasValidas);
            System.out.print("Ingrese moneda de origen: ");
            String monedaOrigen = scanner.nextLine().toUpperCase();

            if (!monedasValidas.contains(monedaOrigen)) {
                System.out.println(" Moneda de origen no válida.");
                continue;
            }

            System.out.print("Ingresa moneda destino: ");
            String monedaDestino = scanner.nextLine().toUpperCase();

            if (!monedasValidas.contains(monedaDestino)) {
                System.out.println("Moneda destino no válida.");
                continue;
            }

            System.out.print("Ingrese cantidad a convertir: ");
            double cantidad;
            try {
                cantidad = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Intente nuevamente.");
                continue;
            }

            double tasa = consultaTipoDeMoneda.obtenerTasa(monedaOrigen, monedaDestino);

            if (tasa == -1) {
                System.out.println("No se pudo obtener la tasa. Intente más tarde.");
                continue;
            }

            double resultado = cantidad * tasa;

            System.out.printf("Resultado: %.2f %s = %.2f %s (Tasa: %.4f)\n",
                    cantidad, monedaOrigen, resultado, monedaDestino, tasa);

            System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        System.out.println("Gracias por usar el conversor de monedas.");
    }
}
