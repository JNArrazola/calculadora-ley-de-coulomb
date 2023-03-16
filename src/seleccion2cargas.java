import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class seleccion2cargas extends JFrame {
    private JPanel principal;
    private JRadioButton fuerzaRadioButton;
    private JRadioButton cargaRadioButton;
    private JRadioButton distanciaRadioButton;

//aqui se va a seleccionar lo que desees calcular
    public seleccion2cargas(){
        setContentPane(principal);
        setSize(1920,1080);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);


        fuerzaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                fuerza2cargas calculo2cargas = new fuerza2cargas();
                calculo2cargas.setVisible(true);
            }
        });
        cargaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                q2cargas cargadesconocida = new q2cargas();
                cargadesconocida.setVisible(true);
            }
        });
        distanciaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                calculoDistanciaDosQ distacia2cargas = new calculoDistanciaDosQ();
                distacia2cargas.setVisible(true);
            }
        });
    }

}
