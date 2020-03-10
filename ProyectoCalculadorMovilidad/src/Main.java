import java.util.Scanner;

public class Main {
    private static int diap;
    private static int colectivosp;
    private static int viajesp;
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Introduzca el colectivo (0-Salir, 1-Sin descuento, 2-Jubilado, 3-Parado, 4-Discapacitado, 5-Estudiante) ");
        colectivosp = leer.nextInt();
        if (colectivosp == 0) {
            System.out.println("Ha cancelado la operacion");
        }
        else {
            System.out.print("Introduzca el número de días estimado: ");
            diap = leer.nextInt();
            System.out.print("Introduzca el número de viajes: ");
            viajesp = leer.nextInt();
            CalculadorMovilidad opci = new CalculadorMovilidad(diap, viajesp, colectivosp);
            opci.calculaPreciosViaje();
            opci.mejorOpcion();
        }
    }
}
