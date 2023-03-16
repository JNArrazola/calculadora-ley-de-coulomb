import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q2cargas extends JFrame{
    private JPanel mainpanel;
    private JTextField charge1;
    private JTextField fuerza;
    private JTextField distancia;
    private JButton calcularButton;
    private JLabel result;
    private JButton regresarButton;

    public static Double q1;
    public static Double newton;
    public static Double distancia_;

    calculadoraDeCargas calc = new calculadoraDeCargas();

    //aqui se van a calcular una carga desconocida
    public q2cargas(){
        setContentPane(mainpanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        calc.setVisible(false);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String carga1 = charge1.getText();
                String force = fuerza.getText();
                String distance = distancia.getText();

                if (carga1.contains("^")){
                    int indexOfExponential = carga1.indexOf("^");
                    int indexOfMulti = carga1.indexOf("x");
                    String exponente = carga1.substring((indexOfExponential+1),carga1.length());
                    String cadenaCarga1 = carga1.substring(0,(indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    Double _q1 = Double.parseDouble(cadenaCarga1);

                    q1 = _q1 * Math.pow(10,exp);

                } else {
                    q1 = Double.parseDouble(carga1);
                }

                if (force.contains("^")){
                    int indexOfExponential = force.indexOf("^");
                    int indexOfMulti = force.indexOf("x");
                    String exponente = force.substring((indexOfExponential+1),force.length());
                    String cadenaCarga1 = force.substring(0,(indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    Double _q1 = Double.parseDouble(cadenaCarga1);

                    newton = _q1 * Math.pow(10,exp);

                } else {
                    newton = Double.parseDouble(force);
                }

                if (distance.contains("^")){
                    int indexOfExponential = distance.indexOf("^");
                    int indexOfMulti = distance.indexOf("x");
                    String exponente = distance.substring((indexOfExponential+1),distance.length());
                    String cadenaCarga1 = distance.substring(0,(indexOfMulti));


                    Double exp = Double.parseDouble(exponente);
                    Double _q1 = Double.parseDouble(cadenaCarga1);

                    distancia_ = _q1 * Math.pow(10,exp);

                } else {
                    distancia_ = Double.parseDouble(distance);
                }

                Double k = 9*Math.pow(10,9);

                Double dividendo = newton*Math.pow(distancia_,2);
                Double divisor = k*q1;

                Double resultado = dividendo/divisor;


                result.setText("El valor de la carga faltante es de "+Math.abs(resultado)+" Coulombs.");
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
