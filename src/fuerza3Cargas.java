import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fuerza3Cargas extends JFrame {

    private JPanel mainPanel;
    private JTextField charge1;
    private JTextField charge2;
    private JTextField charge3;
    private JTextField d1;
    private JTextField d2;
    private JButton calcularButton;
    private JLabel resultadoFinal;
    private JButton regresarButton;
    public static Double q1;
    public static Double q2;
    public static Double q3;
    public static Double distancia1;
    public static Double distancia2;
    public static Double F1;
    public static Double F2;
    public static Double fuerzaTotal;

    calculadoraDeCargas calc = new calculadoraDeCargas();

    public fuerza3Cargas() {

        setContentPane(mainPanel);
        setSize(1920, 1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        calc.setVisible(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String _q1 = charge1.getText();
                String _q2 = charge2.getText();
                String _q3 = charge3.getText();
                String distance1 = d1.getText();
                String distance2 = d2.getText();

                System.out.println("Soy un boton");
                if (_q1.contains("^")) {
                    int indexOfExponential = _q1.indexOf("^");
                    int indexOfMulti = _q1.indexOf("x");
                    String exponente = _q1.substring((indexOfExponential + 1), _q1.length());
                    String cadenaCarga1 = _q1.substring(0, (indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    q1 = Double.parseDouble(cadenaCarga1);

                    System.out.println(q1);
                    System.out.println(exp);

                    q1 = q1 * Math.pow(10, exp);


                } else {
                    q1 = Double.parseDouble(_q1);
                }

                if (_q2.contains("^")) {
                    int indexOfExponential = _q2.indexOf("^");
                    int indexOfMulti = _q2.indexOf("x");
                    String exponente = _q2.substring((indexOfExponential + 1), _q2.length());
                    String cadenaCarga1 = _q2.substring(0, (indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    q2 = Double.parseDouble(cadenaCarga1);

                    q2 = q2 * Math.pow(10, exp);

                } else {
                    q2 = Double.parseDouble(_q2);
                }

                if (_q3.contains("^")) {
                    int indexOfExponential = _q3.indexOf("^");
                    int indexOfMulti = _q3.indexOf("x");
                    String exponente = _q3.substring((indexOfExponential + 1), _q3.length());
                    String cadenaCarga1 = _q3.substring(0, (indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    q3 = Double.parseDouble(cadenaCarga1);

                    q3 = q3 * Math.pow(10, exp);

                } else {
                    q3 = Double.parseDouble(_q3);
                }

                if (distance1.contains("^")) {
                    int indexOfExponential = distance1.indexOf("^");
                    int indexOfMulti = distance1.indexOf("x");
                    String exponente = distance1.substring((indexOfExponential + 1), distance1.length());
                    String cadenaCarga1 = distance1.substring(0, (indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    distancia1 = Double.parseDouble(cadenaCarga1);

                    distancia1 = Math.abs(distancia1 * Math.pow(10, exp));

                } else {
                    distancia1 = Math.abs(Double.parseDouble(distance1));
                }

                if (distance2.contains("^")) {
                    int indexOfExponential = distance2.indexOf("^");
                    int indexOfMulti = distance2.indexOf("x");
                    String exponente = distance2.substring((indexOfExponential + 1), distance2.length());
                    String cadenaCarga1 = distance2.substring(0, (indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    distancia2 = Double.parseDouble(cadenaCarga1);

                    distancia2 = Math.abs(distancia2 * Math.pow(10, exp));

                } else {
                    distancia2 = Math.abs(Double.parseDouble(distance2));
                }

                Double K = 9*Math.pow(10,9);

                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                F1 = Math.abs((K*q1*q2)/Math.pow(distancia1,2));
                F2 = Math.abs((K*q2*q3)/Math.pow(distancia2,2));

                if (q1>0&&q2<0){
                    F1 = F1 * (-1);
                } else if (q1<0&&q2>0){
                    F1 = F1*(-1);
                } else {
                    F1 = F1;
                }

                if (q2<0&&q3<0){
                    F2 = F2 * (-1);
                } else if (q2>0&&q3>0){
                    F2 = F2 * (-1);
                } else {
                    F2 = F2;
                }

                fuerzaTotal = F1 + F2;
                resultadoFinal.setText("La fuerza resultante es de "+fuerzaTotal+ " Newtons");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                calc.setVisible(true);
            }
        });
    }

    }


