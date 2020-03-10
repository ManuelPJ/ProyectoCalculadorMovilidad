import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class InterfazGrupal extends Main{
    private static double min;
    public static String descuentos;

    public InterfazGrupal(Double minimo, String desc){
        min = minimo;
        descuentos = desc;
    }
    Main main = new Main();
    private static int diap;
    private static int colectivosp;
    private static int viajesp;

    public static void main(String[] args){
        JFrame marco = new JFrame("Aplicación Movilidad");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(460, 460);
        JPanel panelGeneral = new JPanel();
        panelGeneral.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelGeneral.setLayout(new GridLayout(2, 2, 10, 5));
        JPanel estancia = new JPanel();
        JPanel colectivo = new JPanel();
        JPanel propuesta= new JPanel();
        JPanel subillete = new JPanel();
        JPanel estancia1 = new JPanel();
        JPanel estancia2 = new JPanel();

        estancia.setLayout(new FlowLayout());
        colectivo.setLayout(new GridLayout(5,1));
        propuesta.setLayout(new FlowLayout());
        subillete.setLayout(new FlowLayout());

        //Bordes
        Border bordeestancia = new TitledBorder(new EtchedBorder(), "Estancia");
        estancia.setBorder(bordeestancia);
        Border bordecolectivo = new TitledBorder(new EtchedBorder(), "Colectivo");
        colectivo.setBorder(bordecolectivo);
        Border bordepropuesta = new TitledBorder(new EtchedBorder(), "Propuesta");
        propuesta.setBorder(bordepropuesta);
        Border bordesubillete = new TitledBorder(new EtchedBorder(), "Su Billete");
        subillete.setBorder(bordesubillete);

        //panel estancia
        estancia1.setLayout(new FlowLayout());
        estancia2.setLayout(new BorderLayout(50,10));
        JSpinner dia = new JSpinner();
        dia.setValue(0);
        JLabel dias = new JLabel();
        dia.setPreferredSize(new Dimension(40, 25));
        JLabel viajes = new JLabel();
        JSlider slider = new JSlider(0, 100, 0);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        estancia1.add(dias);
        estancia1.add(dia);
        estancia2.add(viajes, BorderLayout.SOUTH);
        estancia2.add(slider, BorderLayout.CENTER);
        estancia.add(estancia1, BorderLayout.NORTH);
        estancia.add(estancia2, BorderLayout.SOUTH);

        //panel colectivo

        JRadioButton botRadio1 = new JRadioButton();
        JRadioButton botRadio2 = new JRadioButton();
        JRadioButton botRadio3 = new JRadioButton();
        JRadioButton botRadio4 = new JRadioButton();
        JRadioButton botRadio5 = new JRadioButton();
        ButtonGroup agrupBotRad = new ButtonGroup();

        colectivo.add(botRadio1);
        colectivo.add(botRadio2);
        colectivo.add(botRadio3);
        colectivo.add(botRadio4);
        colectivo.add(botRadio5);

        botRadio1.setText("Sin Descuento");
        botRadio2.setText("Jubilado");
        botRadio3.setText("Discapacitado");
        botRadio4.setText("Parado");
        botRadio5.setText("Estudiante");

        agrupBotRad.add(botRadio1);
        agrupBotRad.add(botRadio2);
        agrupBotRad.add(botRadio3);
        agrupBotRad.add(botRadio4);
        agrupBotRad.add(botRadio5);

        //panel propuesta
        Icon aceptar = new ImageIcon("src/valBot.png");
        Icon cancelar = new ImageIcon("src/canBot.png");
        JTextArea texto = new JTextArea();
        texto.setPreferredSize(new Dimension(200,50));
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setBorder(BorderFactory.createLoweredBevelBorder());
        texto.setLineWrap(true);
        propuesta.add(texto);
        JPanel propuesta1 = new JPanel();
        propuesta1.setLayout(new BorderLayout(5,10));
        JPanel propuesta2 = new JPanel();
        propuesta2.setLayout(new BorderLayout(5,10));
        JButton botonaceptar = new JButton(aceptar);
        JButton botoncancelar = new JButton(cancelar);
        propuesta1.add(botonaceptar, BorderLayout.SOUTH);
        propuesta2.add(botoncancelar, BorderLayout.SOUTH);
        propuesta.add(propuesta1, BorderLayout.SOUTH);
        propuesta.add(propuesta2, BorderLayout.SOUTH);

        //panel billete
        JLabel billete = new JLabel();
        billete.setHorizontalAlignment(JLabel.CENTER);
        billete.setVerticalAlignment(JLabel.CENTER);
        billete.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createEmptyBorder(5,5,5,5)));
        billete.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,0,10,0),billete.getBorder()));
        subillete.add(billete);



        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                viajes.setText("                        Viajes: " + slider.getValue());
                viajesp = slider.getValue();
            }
        });
        dia.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                dias.setText("Días ");
                diap = Integer.parseInt(dia.getValue().toString());
            }
        });
        botRadio1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colectivosp = 1;
            }
        });
        botRadio2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colectivosp = 2;
            }
        });
        botRadio3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colectivosp = 4;
            }
        });
        botRadio4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { colectivosp = 3; }
        });
        botRadio5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colectivosp = 5;
            }
        });
        botonaceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DecimalFormat formato = new DecimalFormat("#.##");
                if (colectivosp == 0) {
                    texto.setText("Seleccione un colectivo");
                }
                else {
                    Calcmovi opci = new Calcmovi(diap, viajesp, colectivosp);
                    opci.calculaPreciosViaje();
                    opci.mejorOpcion();
                    try {
                        if (diap <= 0 || viajesp <= 0) {
                            throw new Excepcionc(diap, viajesp);
                        } else if (min == opci.calculaPreciosViaje()[colectivosp - 1][0]) {
                            texto.setText("(" + descuentos + ") " + "Debería coger la opción de Billete suelto " + "(" + formato.format(min) + "€/viaje)");
                            if(colectivosp == 1 ){
                                billete.setIcon(new ImageIcon("src/SIN_DESCUENTO_1_VIAJE.png"));
                            }else if(colectivosp == 2){
                                billete.setIcon(new ImageIcon("src/JUBILADOS_1_VIAJE.png"));
                            }else if(colectivosp == 4){
                                billete.setIcon(new ImageIcon("src/DISCAPACITADO_1_VIAJE.png"));
                            }
                            else if(colectivosp == 3){
                                billete.setIcon(new ImageIcon("src/PARADOS_1_VIAJE.png"));
                            }
                            else if(colectivosp == 5){
                                billete.setIcon(new ImageIcon("src/ESTUDIANTES_1_VIAJE.png"));
                            }
                        } else if (min == opci.calculaPreciosViaje()[colectivosp - 1][1]) {
                            texto.setText("(" + descuentos + ") " + "Debería coger la opción de Bono para 7 días " + "(" + formato.format(min) + "€/viaje)");
                            if(colectivosp == 1 ){
                                billete.setIcon(new ImageIcon("src/SIN_DESCUENTO_7_DIAS.png"));
                            }else if(colectivosp == 2){
                                billete.setIcon(new ImageIcon("src/JUBILADOS_7_DIAS.png"));
                            }else if(colectivosp == 4){
                                billete.setIcon(new ImageIcon("src/DISCAPACITADO_7_DIAS.png"));
                            }
                            else if(colectivosp == 3){
                                billete.setIcon(new ImageIcon("src/PARADOS_7_VIAJES.png"));
                            }
                            else if(colectivosp == 5){
                                billete.setIcon(new ImageIcon("src/ESTUDIANTES_7_DIAS.png"));
                            }
                        } else if (min == opci.calculaPreciosViaje()[colectivosp - 1][2]) {
                            texto.setText("(" + descuentos + ") " + "Debería coger la opción de Bono para 30 días " + "(" + formato.format(min) + "€/viaje)");
                            if(colectivosp == 1 ){
                                billete.setIcon(new ImageIcon("src/SIN_DESCUENTO_30_DIAS.png"));
                            }else if(colectivosp == 2){
                                billete.setIcon(new ImageIcon("src/JUBILADOS_30_DIAS.png"));
                            }else if(colectivosp == 4){
                                billete.setIcon(new ImageIcon("src/DISCAPACITADO_30_DIAS.png"));
                            }
                            else if(colectivosp == 3){
                                billete.setIcon(new ImageIcon("src/PARADOS_30_VIAJE.png"));
                            }
                            else if(colectivosp == 5){
                                billete.setIcon(new ImageIcon("src/ESTUDIANTES_30_DIAS.png"));
                            }
                        }
                    } catch (Excepcionc exp) {
                        texto.setText(exp.toString());
                    }
                }
            }
        });
        botoncancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slider.setValue(1);
                dia.setValue(1);
                botRadio1.setSelected(true);
                texto.setText(" ");
                billete.setIcon(null);
            }
        });
        panelGeneral.add(estancia);
        panelGeneral.add(colectivo);
        panelGeneral.add(propuesta);
        panelGeneral.add(subillete);
        marco.add(panelGeneral);
        dias.setText("Días ");
        viajes.setText("                        Viajes: 0");
        marco.setVisible(true);
    }
}