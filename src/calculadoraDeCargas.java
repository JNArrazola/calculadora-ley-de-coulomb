import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//pagina principal de seleccion
public class calculadoraDeCargas extends JFrame {

    private JPanel mainPanel;
    private JRadioButton oneq;
    private JRadioButton twoq;
    private JPanel instructionPanel;
    public JPanel calc2cargas;


    public calculadoraDeCargas(){
        setContentPane(mainPanel);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        oneq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               seleccion2cargas abrir = new seleccion2cargas();
                abrir.setVisible(true);
            }

        });
        twoq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                seleccion3cargas open = new seleccion3cargas();
                open.setVisible(true);
            }
        });
    }









    public static void main(String[] args) {
        calculadoraDeCargas calculadora = new calculadoraDeCargas();
        seleccion2cargas instruccion = new seleccion2cargas();
        seleccion3cargas selecc3 = new seleccion3cargas();
    }
}


