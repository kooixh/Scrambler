package UserInterface;

import Scrambler.Scrambler;
import Scrambler.CubeScrambler;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kooi on 06/06/2017.
 */
public class Generator extends JPanel {

    private JTextArea scramble = new JTextArea("Generate a scramble");

    //Buttons
    private JButton generate = new JButton("Generate");
    private JButton getLast = new JButton("Get last scramble");
    private JButton switchPuzzle = new JButton("Switch Puzzle");
    private JButton print = new JButton("Save session");

    //Reference to the current puzzle scrambler
    private Scrambler scrambler;

    public Generator(String puzzle,ActionListener a){


        JPanel buttons = new JPanel();
        JPanel s = new JPanel();
        buttons.setLayout(new FlowLayout());


        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));




        scramble.setSize(new Dimension(800,500));
        scramble.setEditable(false);
        scramble.setBackground(this.getBackground()); // make the background same as panel
        scramble.setLineWrap(true);

        try{
            scrambler = CubeScrambler.getInstance(puzzle);
        }catch (IllegalArgumentException iae){

        }

        scramble.setText(scrambler.generateScramble());

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scramble.setText(scrambler.generateScramble());
            }
        });

        getLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scramble.setText("Last scramble: " + scrambler.getLastScramble());
            }
        });

        switchPuzzle.addActionListener(a);

        buttons.add(generate);
        buttons.add(getLast);
        buttons.add(switchPuzzle);
        buttons.add(print);

        s.add(scramble);

        add(s);
        add(buttons);
    }

    //getters
    public Scrambler getScrambler(){
        return scrambler;
    }

    public JButton getGenerate(){
        return generate;
    }


    //method to change the puzzle
    public void changePuzzle(String puzzle){

        scrambler = CubeScrambler.getInstance(puzzle);

    }
}
