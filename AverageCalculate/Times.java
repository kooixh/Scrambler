package AverageCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Kooi on 06/06/2017.
 */
public class Times extends JPanel {


    private JTextField time = new JTextField(10);
    private JButton enter = new JButton("Enter");

    private AverageCalculator averageCalculator;
    private Session session;
    private AllTimes allTimes;

    /**
     *
     * @param s The reference to the session that shows the stats
     * @param ac Reference to the average calculator used
     * @param at Reference to the all times object for the session
     */
    public Times(Session s,AverageCalculator ac,AllTimes at){
        averageCalculator = ac;
        session =s;
        allTimes = at;
        setLayout(new FlowLayout());

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    averageCalculator.addTime(Double.parseDouble(time.getText()));
                    time.setText("");
                    s.refresh(); //refresh the session stats
                    at.refresh(); //refresh the times

                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Please enter a valid time");
                    time.setText("");
                }
            }
        });

        time.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    enter.doClick();
                }
            }
        });

        add(time);
        add(enter);

    }

}
