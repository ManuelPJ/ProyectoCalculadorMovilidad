public class Excepcionc extends Exception {

    private Integer diap;
    private Integer viajesp;
    Excepcionc(Integer diapp, Integer viajespp ) {
        this.diap= diapp;
        this.viajesp = viajespp;
    }

    public String toString(){
        return ("Viajes introducidos y/o dias no son correctos" + this.diap + "," + this.viajesp);
    }
}

