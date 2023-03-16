import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculoDistanciaDosQ extends JFrame{
    private JPanel mainPanel;
    private JLabel ingresarFuerza;
    private JTextField force;
    private JLabel ingresaCarga1;
    private JTextField charge1;
    private JLabel ingresaCarga2;
    private JTextField charge2;
    private JButton calcularButton;
    private JLabel resultado;
    private JButton regresarButton;

    public static Double q1;
    public static Double q2;
    public static Double f1;

    calculadoraDeCargas calc = new calculadoraDeCargas();

    public  calculoDistanciaDosQ(){
        setContentPane(mainPanel);
        setVisible(true);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        regresarButton.setVisible(true);
        calc.setVisible(false);


        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String carga1 = charge1.getText();
                String carga2 = charge2.getText();
                String fuerza = force.getText();


                //aqui calculo la carga 1 y la convierto
                if (carga1.contains("^")){

                    Double exp = Double.parseDouble(carga1.substring((carga1.indexOf("^")+1),carga1.length()));
                    Double _q1 = Double.parseDouble(carga1.substring(0,(carga1.indexOf("x"))));

                    q1 = _q1 * Math.pow(10,exp);
                } else {
                    q1 = Double.parseDouble(carga1);
                }

                //ahora la carga 2

                if (carga2.contains("^")){

                    Double exp = Double.parseDouble(carga2.substring((carga2.indexOf("^")+1),carga2.length()));
                    Double _q2 = Double.parseDouble(carga2.substring(0,(carga2.indexOf("x"))));

                    q2 = _q2 * Math.pow(10,exp);
                } else {
                    q2 = Double.parseDouble(carga2);
                }

                //ahora la fuerza
                if (fuerza.contains("^")){

                    Double exp = Double.parseDouble(fuerza.substring((fuerza.indexOf("^")+1),fuerza.length()));
                    Double _f = Double.parseDouble(fuerza.substring(0,(fuerza.indexOf("x"))));

                    f1 = _f * Math.pow(10,exp);
                } else {
                    f1 = Double.parseDouble(fuerza);
                }

                Double k = 9* Math.pow(10,9);


                Double resultado1 = k*q1*q2;
                Double resultado2 = resultado1/f1;
                Double resultadoFinal = Math.sqrt(resultado2);
                System.out.println(Math.abs(resultadoFinal));

                resultado.setText("La distancia es de: "+resultadoFinal + " metros.");
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
