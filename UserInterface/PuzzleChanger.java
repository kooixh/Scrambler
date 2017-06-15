package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kooi on 06/06/2017.
 */
public class PuzzleChanger extends JFrame {

    private Generator generator;
    private JButton puzzle3x3 = new JButton("3x3");
    private JButton puzzle2x2 = new JButton("2x2");
    private JButton puzzle4x4 = new JButton("4x4");
    private JButton puzzle5x5 = new JButton("5x5");

    public PuzzleChanger(Generator gen, JButton generate, PuzzleStats pz){ //pz use to refresh the name and length
        generator = gen;

        setSize(300,300);
        setLayout(new FlowLayout());


        //Action Listeners
        puzzle3x3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.changePuzzle("3x3");
                generate.doClick();
                pz.refresh();
                dispose();
            }
        });

        puzzle4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.changePuzzle("4x4");
                generate.doClick();
                pz.refresh();
                dispose();
            }
        });

        puzzle5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.changePuzzle("5x5");
                generate.doClick();
                pz.refresh();
                dispose();
            }
        });

        puzzle2x2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.changePuzzle("2x2");
                generate.doClick();
                pz.refresh();
                dispose();
            }
        });


        //Add to frame
        add(puzzle3x3);
        add(puzzle2x2);
        add(puzzle4x4);
        add(puzzle5x5);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void showWindow(){
        setVisible(true);
    }
}
