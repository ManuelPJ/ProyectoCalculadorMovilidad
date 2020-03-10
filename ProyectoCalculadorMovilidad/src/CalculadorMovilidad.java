import java.util.Arrays;
import java.util.Collections;
import java.text.DecimalFormat;
public class CalculadorMovilidad {
    private double[] precioBillete = {2.75, 33.0, 127.00};
    private Integer dias;
    private Integer viajes;
    private Double colectivo;
    private Double[] colectivos = {0.0, 0.50, 0.60, 0.75, 0.80};
    private Integer colectivop;
    private String descuentos;
    public CalculadorMovilidad(Integer diap, Integer viajesp, Integer colectivosp) {
        this.dias = diap;
        this.viajes = viajesp;
        this.colectivop = colectivosp;
        if (colectivosp == 1) {
            this.colectivo = 0.0;
        } else if (colectivosp == 2) {
            this.colectivo = 0.50;
        } else if (colectivosp == 3) {
            this.colectivo = 0.60;
        }else if (colectivosp == 4) {
            this.colectivo = 0.75;
        }else if (colectivosp == 5) {
            this.colectivo = 0.80;
        }
        if (colectivosp == 1) {
            this.descuentos = "Sin descuento";
        } else if (colectivosp == 2) {
            this.descuentos = "Jubilado";
        } else if (colectivosp == 3) {
            this.descuentos = "Parado";
        }else if (colectivosp == 4) {
            this.descuentos = "Discapacitado";
        }else if (colectivosp == 5) {
            this.descuentos = "Estudiante";
        }
    }

    Double[] precioIlimitado7d() {

        Double precioBase = precioBillete[1];
        Double[] precios = new Double[5];
        Double descuento;
        Double nBono;
        Double precio;
        int j;
        for (j=0; j < 5; j++) {
            descuento = precioBase * colectivos[j];
            precio = precioBase - descuento;
            nBono = Math.ceil(dias / 7d);
            precios[j] = (precio * nBono) /this.viajes;
        }
        return precios;
    }

    Double[] precioLimitadoSimple() {
        Double precioBase = precioBillete[0];
        Double[] precios = new Double[5];
        Double descuento;
        Double precio;
        int j;
        for (j=0; j < 5; j++) {
            descuento = precioBase * colectivos[j];
            precio = precioBase - descuento;
            precios[j] = precio;
        }
        return precios;
    }
    Double[] precioIlimitado30d() {
        Double precioBase = precioBillete[2];
        Double[] precios = new Double[5];
        Double descuento;
        Double nBono;
        Double precio;
        int j;
        for (j=0; j < 5; j++) {
            descuento = precioBase * colectivos[j];
            precio = precioBase - descuento;
            nBono = Math.ceil(dias / 30d);
            precios[j] = (precio * nBono) /this.viajes;
        }
        return precios;
    }

    Double[][] calculaPreciosViaje() {
        Double[][] preciod = new Double[5][3];
        Double[] precios1 = precioLimitadoSimple();
        Double[] precio7d = precioIlimitado7d();
        Double[] precio30d = precioIlimitado30d();
        for (int i=0; i < 5; i++) {
            for (int j=0; j < 3; j++) {
                if (j == 0) { //tipo de billete simple
                    preciod[i][j]=precios1[i];
                }else if (j == 1) { //tipo de billete 7d
                    preciod[i][j]=precio7d[i];
                }else if (j == 2) { //tipo de billete 30d
                    preciod[i][j]=precio30d[i];
                }
            }
        }
        return preciod;
    }

    void mejorOpcion() {
        DecimalFormat formato = new DecimalFormat("#.00");
        Double viaje[][] = calculaPreciosViaje();
        if (colectivop == 0) {
            System.out.println("Ha cancelado la operacion");
        }
        Double min = Collections.min(Arrays.asList(viaje[this.colectivop - 1]));
        InterfazGrupal in = new InterfazGrupal(min, descuentos);
        try {
            if (dias <= 0 || viajes <= 0) {
                throw new Exepcion(dias, viajes);
            } else if (min == viaje[this.colectivop - 1][0]) {
                System.out.println("(" + descuentos + ")" + "Debería coger la opción de Billete suelto" + "(" + (formato.format(min)) + "€/viaje)");
            } else if (min == viaje[this.colectivop - 1][1]) {
                System.out.println("(" + descuentos + ")" + "Debería coger la opción de Bono para 7 días" + "(" + (formato.format(min)) + "€/viaje)");
            } else if (min == viaje[this.colectivop - 1][2]) {
                System.out.println("(" + descuentos + ")" + "Debería coger la opción de Bono para 30 días" + "(" + (formato.format(min)) + "€/viaje)");
            }
        } catch (Exepcion exp) {
            System.out.println(exp);
        }
    }
}