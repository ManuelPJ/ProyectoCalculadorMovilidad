public class Exepcion extends Exception {

    private Integer diap;
    private Integer viajesp;
    Exepcion(Integer diapp, Integer viajespp ) {
        this.diap= diapp;
        this.viajesp = viajespp;
    }

    public String toString(){
        return ("Viajes introducidos y/o dias no son correctos" + "  "+ diap + ", " + viajesp);
    }

}