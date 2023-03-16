import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class seleccion3cargas extends JFrame{
    private JRadioButton fuerzaResultanteRadioButton;
    private JRadioButton distanciaTotalRadioButton;
    private JPanel mainPanel;

    calculadoraDeCargas calc = new calculadoraDeCargas();
    public seleccion3cargas() {

        setContentPane(mainPanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        calc.setVisible(false);
        distanciaTotalRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            distancia3cargas distance = new distancia3cargas();
            distance.setVisible(true);


            }
        });
        fuerzaResultanteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            fuerza3Cargas fuerza3q = new fuerza3Cargas();
            fuerza3q.setVisible(true);
            setVisible(false);

            }
        });
    }
}
