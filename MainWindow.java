package Scrambler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kooi on 14/05/2017.
 */
public class MainWindow  extends JFrame{


    private static JButton generate = new JButton("Generate");
    private static JLabel scramble = new JLabel("Generate a scramble");
    private Scrambler scrambler;


    public MainWindow(String puzzleName){
        setLayout(new BorderLayout());

        setSize(600,600);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        if(puzzleName.equals("3x3")){
            scrambler = new Scrambler3x3();
        }else{
            throw new IllegalArgumentException();
        }

        generate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                scramble.setText(scrambler.generateScramble());
            }
        });

        p.add(scramble);
        p.add(generate);

        add(p, BorderLayout.NORTH);




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void run(){
        setVisible(true);
    }

}
