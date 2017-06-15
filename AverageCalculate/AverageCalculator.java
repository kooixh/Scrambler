package AverageCalculate;

import java.util.*;


/**
 * Created by Kooi on 06/06/2017.
 */
public class AverageCalculator {

    //fields
    private List<Double> times = new ArrayList<Double>();
    private double average;
    private double bestTime;
    private double worstTime;

    public AverageCalculator(){


    }


    //Getters
    public double getBestTime(){
        if(!times.isEmpty()) {
            double best = times.get(0);

            //loop to find smallest
            for (double d : times) {
                if (best > d) {
                    best = d;
                }
            }

            bestTime = best;
        }

        return bestTime;
    }

    public double getAverage() {

        double total =0;

        for(double d:times){
            total +=d;
        }

        average = (total - getBestTime() - getWorstTime())/(times.size()-2);



        return average;
    }

    public double getWorstTime() {

        if(!times.isEmpty()) {
            double worst = times.get(0);

            //loop to find biggest
            for (double d : times) {
                if (worst < d) {
                    worst = d;
                }
            }

            worstTime = worst;
        }
        return worstTime;
    }

    public int getTotal(){
        return times.size();
    }

    //method to add time
    public void addTime(double time){
        times.add(time);
    }

    public List<Double> getTimes() {
        return times;
    }

    public void removeTime(double time){
        times.remove(time);
    }


    public void refresh(){

    }
}
