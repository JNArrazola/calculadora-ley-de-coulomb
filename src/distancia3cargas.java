import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class distancia3cargas extends JFrame{
    private JPanel mainPanel;
    private JTextField charge1;
    private JTextField charge2;
    private JTextField charge3;
    private JTextField force1;
    private JTextField force2;
    private JButton calcularButton;
    private JLabel distancia1;
    private JLabel distancia2;
    private JLabel distanciaTotal;
    private JButton regresarButton;

    public static Double q1;
    public static Double q2;
    public static Double q3;
    public static Double f1;
    public static Double f2;

    calculadoraDeCargas calc = new calculadoraDeCargas();


    public distancia3cargas(){
        setContentPane(mainPanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        calc.setVisible(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String _q1 = charge1.getText();
                String _q2 = charge2.getText();
                String _q3 = charge3.getText();
                String _f1 = force1.getText();
                String _f2 = force2.getText();

                //obtengo todos los valores necesarios
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                if (_q1.contains("^")){
                    Double exp = Double.parseDouble(_q1.substring((_q1.indexOf("^")+1),_q1.length()));
                    Double num = Double.parseDouble(_q1.substring(0,_q1.indexOf("x")));

                    q1 = num * Math.pow(10,exp);
                } else {
                    q1 = Double.parseDouble(_q1);
                }

                if (_q2.contains("^")){
                    Double exp = Double.parseDouble(_q2.substring((_q2.indexOf("^")+1),_q2.length()));
                    Double num = Double.parseDouble(_q2.substring(0,_q2.indexOf("x")));

                    q2 = num * Math.pow(10,exp);
                } else {
                    q2 = Double.parseDouble(_q2);
                }

                if (_q3.contains("^")){
                    Double exp = Double.parseDouble(_q3.substring((_q3.indexOf("^")+1),_q3.length()));
                    Double num = Double.parseDouble(_q3.substring(0,_q3.indexOf("x")));

                    q3 = num * Math.pow(10,exp);
                } else {
                    q3 = Double.parseDouble(_q3);
                }

                if (_f1.contains("^")){
                    Double exp = Double.parseDouble(_f1.substring((_f1.indexOf("^")+1),_f1.length()));
                    Double num = Double.parseDouble(_f1.substring(0,_f1.indexOf("x")));

                    f1 = num * Math.pow(10,exp);
                } else {
                    f1 = Double.parseDouble(_f1);
                }

                if (_f2.contains("^")){
                    Double exp = Double.parseDouble(_f2.substring((_f2.indexOf("^")+1),_f2.length()));
                    Double num = Double.parseDouble(_f2.substring(0,_f2.indexOf("x")));

                    f2 = num * Math.pow(10,exp);
                } else {
                    f2 = Double.parseDouble(_f2);
                }

                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                if (q1<=-0.000000000000001){
                    q1 = q1*(-1);
                }
                if (q2<=-0.000000000000001){
                    q2 = q2*(-1);
                }
                if (q3<=-0.000000000000001){
                    q3 = q3*(-1);
                }

                Double K = 9 * Math.pow(10,9);


                Double d1 = Math.pow(((K*q1*q2)/f1),0.5);
                Double d2 = Math.pow(((K*q2*q3)/f2),0.5);

                distancia1.setText("La distancia entre q1 y q2 es de "+d1+" metros");
                distancia2.setText("La distancia entre q2 y q3 es de "+d2+" metros");
                distanciaTotal.setText("La distancia total es de "+ (d1+d2)+ " metros");


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
