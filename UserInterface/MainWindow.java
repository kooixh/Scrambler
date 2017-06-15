package UserInterface;

import AverageCalculate.AllTimes;
import AverageCalculate.AverageCalculator;
import AverageCalculate.Session;
import AverageCalculate.Times;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by Kooi on 14/05/2017.
 */
public class MainWindow  extends JFrame{




    // Generator and other windows
    private Generator generator;
    private PuzzleStats puzzleStats;
    private PuzzleChanger puzzleChanger;

    private AverageCalculator averageCalculator = new AverageCalculator();

    private Session session = new Session(averageCalculator);
    private AllTimes allTimes = new AllTimes(averageCalculator,session);
    private Times times = new Times(session,averageCalculator,allTimes);


    //JScrollPane for times
    private JScrollPane jsp = new JScrollPane(allTimes);




    public MainWindow(String puzzleName){


        JPanel p = new JPanel(); // panel for stats
        JPanel p1 = new JPanel(); // Panel for generator
        setLayout(new BorderLayout());
        pack();

        setMinimumSize(new Dimension(800,300));

        try{
            generator = new Generator(puzzleName, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    puzzleChanger.showWindow();
                }
            });
        }catch (IllegalArgumentException iae){
            JOptionPane.showMessageDialog(null,"Invalid puzzle type");
        }

        puzzleStats = new PuzzleStats(generator);
        puzzleChanger = new PuzzleChanger(generator,generator.getGenerate(),puzzleStats);




        p.setLayout(new FlowLayout());
        p.add(puzzleStats);
        p.add(session);


        //dimension for scrollpane
        int height = this.getHeight();
        int width = this.getWidth()/3;

        jsp.setPreferredSize(new Dimension(width,height));

        //link the ScrollPane to the allTimes so it can be repainted when a time is removed
        allTimes.linkJSP(jsp);

        p1.add(generator);

        JButton test = new JButton("Test");
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,getWidth());
            }
        });

        //add(test,BorderLayout.WEST);

        add(p1,BorderLayout.NORTH);
        add(times,BorderLayout.CENTER);
        add(jsp,BorderLayout.WEST);
        add(p,BorderLayout.SOUTH);




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void run(){
        setVisible(true);
    }

}
