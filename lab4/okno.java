import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class okno extends JFrame {
    private int count = 0;
    JFrame frame = this;
    private JTextField fio = new JTextField(20);
    private JLabel metka = new JLabel("Ваше имя?");
    private JLabel metkaDva = new JLabel("");
    private JLabel metkaCount = new JLabel("");

    class PushingListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Object button = e.getSource();
            if(button instanceof JButton && e.getActionCommand()!="change size"){
                count++;
                metkaCount.setText("Нажато " + count + " раз");
                metkaDva.setText("Спасибо, "+fio.getText()+"!");
            }
            else {
                if ( frame.getSize().width == 500) frame.setSize(300, 300);
                else frame.setSize(500, 500);
            }
        }
    }

    public okno(String title)
    {
        super(title);
        SozdatxOkno();
    }

    private void SozdatxOkno(){

        JButton button = new JButton(" Нажми меня! ");
        button.setBounds(65,60,150,40);
        JButton newButton = new JButton("Изменть размер окна");
        newButton.setBounds(65,160,200,40);
        newButton.setActionCommand("change size");

        button.addActionListener(new PushingListener());
        newButton.addActionListener(new PushingListener());
        metka.setBounds(15,15,95,30);
        metkaDva.setBounds(15,115,200,30);
        metkaCount.setBounds(15,200,100,30);

        fio.setBounds(120, 15, 100, 30);

        getContentPane().setLayout(null);
        getContentPane().add(button);
        getContentPane().add(metka);
        getContentPane().add(metkaDva);
        getContentPane().add(fio);
        getContentPane().add(metkaCount);
        getContentPane().add(newButton);

        setLocationRelativeTo(null);
    }
} 