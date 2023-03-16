/*
* @author: Joshua Arrazola
* */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fuerza2cargas extends JFrame {

    private JPanel principalpanel;
    public JTextField carga1;
    public JTextField carga2;
    public JTextField distance;
    private JButton calculate;
    private JLabel resultado;
    private JButton regresarButton;


    public static Double q1;
    public static Double q2;
    public static Double valDistancia;
    public static Double fuerza;

    calculadoraDeCargas cal = new calculadoraDeCargas();

    //aqui se va a calculoar la fuerza entre dos cargas
    public fuerza2cargas(){
        setContentPane(principalpanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        cal.setVisible(false);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String charge1 = carga1.getText();
                String Charge2 = carga2.getText();
                String distancia = distance.getText();

                //aqui voy a verificar si carga1 contiene ^
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                if (charge1.contains("^")){
                    int indexOfExponential = charge1.indexOf("^");
                    int indexOfMulti = charge1.indexOf("x");
                    String exponente = charge1.substring((indexOfExponential+1),charge1.length());
                    String cadenaCarga1 = charge1.substring(0,(indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    Double _q1 = Double.parseDouble(cadenaCarga1);

                      q1 = _q1 * Math.pow(10,exp);

                } else {
                      q1 = Double.parseDouble(charge1);
                }



//                aca voy a verificar lo mismo con q2
//                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                if (Charge2.contains("^")){

                    String exponencial = Charge2.substring((Charge2.indexOf("^")+1),Charge2.length());
                    String cadenaCarga2 = Charge2.substring(0,(Charge2.indexOf("x")));

                    Double exp = Double.parseDouble(exponencial);
                    Double _q2 = Double.parseDouble(cadenaCarga2);

                      q2 = _q2 * Math.pow(10,exp);



                } else {
                      q2 = Double.parseDouble(Charge2);
                }


                //calculo la distancia
                if (distancia.contains("^")){
                    String exponencial = distancia.substring((distancia.indexOf("^")+1),distancia.length());
                    String num = distancia.substring(0,(distancia.indexOf("x")));


                     valDistancia = Double.parseDouble(num) * Math.pow(10,Double.parseDouble(exponencial));
                } else {
                    valDistancia = Double.parseDouble(distancia);
                }

                Double k = 9*Math.pow(10,9);

                fuerza = ((k)*(q1)*(q2))/(Math.pow(valDistancia,2));

                resultado.setText("La fuerza es de: "+Math.abs(fuerza)+ " Newtons.");
                
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                cal.setVisible(true);
            }
        });
    }

}
