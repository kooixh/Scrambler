package AverageCalculate;

import javax.swing.*;

/**
 * Created by Kooi on 06/06/2017.
 */
public class Session extends JPanel {

    //Labels
    private JLabel best = new JLabel();
    private JLabel worst = new JLabel();
    private JLabel average = new JLabel();
    private JLabel solves = new JLabel();

    //Reference to calculator
    private AverageCalculator averageCalculator;


    /**
     * Takes a reference to the average calculator used by main program
     * @param ac
     */
    public Session(AverageCalculator ac){

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        averageCalculator = ac;

        refresh();

        add(solves);
        add(average);
        add(best);
        add(worst);

    }


    /**
     *
     * Method to round the times to 2 decimal points
     *
     */
    private String rounding(double time){

        return String.format("%.2f",time);
    }

    /**
     * When time is empty, show N/A
     * When less than 3 solves, average is not shown
     *
     */
    public void refresh(){

        if(averageCalculator.getTotal() < 3 && averageCalculator.getTotal() !=0) {
            best.setText("Best time: " + rounding(averageCalculator.getBestTime()));
            worst.setText("Worst time: " + rounding(averageCalculator.getWorstTime()));
            average.setText("Average: N/A");
            solves.setText(averageCalculator.getTotal() + " / " + averageCalculator.getTotal());
        }else if(averageCalculator.getTotal() == 0){
            best.setText("Best time: N/A");
            worst.setText("Worst time: NA");
            average.setText("Average: N/A");
            solves.setText(averageCalculator.getTotal() + " / " + averageCalculator.getTotal());
        }else{
            best.setText("Best time: " + rounding(averageCalculator.getBestTime()));
            worst.setText("Worst time: " + rounding(averageCalculator.getWorstTime()));
            average.setText("Average: " + rounding(averageCalculator.getAverage()));
            solves.setText(averageCalculator.getTotal() + " / " + averageCalculator.getTotal());
        }

    }
}
