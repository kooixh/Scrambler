package AverageCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kooi on 06/06/2017.
 */
public class AllTimes extends JPanel{

    private AverageCalculator averageCalculator;
    private Session session;
    private JScrollPane jsp;

    /**
     * takes the reference to the average calculator used by the program
     * @param ac
     */
    public AllTimes(AverageCalculator ac,Session s){
        averageCalculator = ac;
        session = s;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        //setMaximumSize(new Dimension(50,50));
        refresh();





    }

    //link the panel to the scroll pane so I can repaint the scroll pane when removing a time
    public void linkJSP(JScrollPane jsp){
        this.jsp = jsp;
    }
    /**
     * clear the panel and add all the times in the session
     */
    public void refresh(){
        removeAll(); // remove all existing time to refresh

        for(double d:averageCalculator.getTimes()){


            JLabel time = new JLabel();
            time.setText(String.format("%.2f",d));
            time.addMouseListener(new MouseAdapter() {

                // Red on hover
                @Override
                public void mouseEntered(MouseEvent e) {
                    time.setForeground(Color.red);
                }

                // Black when not hovered

                @Override
                public void mouseExited(MouseEvent e) {
                    time.setForeground(Color.BLACK);
                }

                //Delete time on click
                @Override
                public void mouseClicked(MouseEvent e) {
                    averageCalculator.removeTime(Double.parseDouble(time.getText()));
                    AllTimes.this.remove(time);
                    refresh();
                    session.refresh();

                    //repaint the jsp with the new times
                    jsp.revalidate();
                    jsp.repaint();

                }
            });
            add(time);
        }
    }
}
