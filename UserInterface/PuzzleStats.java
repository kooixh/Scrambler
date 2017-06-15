package UserInterface;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Created by Kooi on 06/06/2017.
 */
public class PuzzleStats extends JTextArea {

    private Generator generator;




    public PuzzleStats(Generator gen){


        generator = gen;
        //setPreferredSize(new Dimension(400,100));
        setEditable(false);
        setBackground(generator.getBackground());


        setText(format());

    }

    public void refresh(){
        setText(format());
    }


    private String format(){

        return String.format("Puzzle: %s \n Scrambe Length: %d", generator.getScrambler().getPuzzleName(),generator.getScrambler().getScrambleLength());
    }
}
