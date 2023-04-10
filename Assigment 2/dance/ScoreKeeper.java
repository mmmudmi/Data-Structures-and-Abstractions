import java.util.*;
/**
 * Pearploy Chaicharoensin 6381278
 */

/*
 * The ScoreKeeper class stores scores and answers basic statistical average
 * about the scores. It is intended to be use as part of another class for
 * score storage.
 */
public class ScoreKeeper {
    // TODO: Declare private member variables as needed
    double[] scores;
    public ScoreKeeper() {
        // TODO: Create an instance for this.scores
        this.scores = new double[0];
    }

    /*
     * Record the scores given by double[] scores into your instance variable
     * scores. If the member variable already has existing data, clear it before
     * putting in the new scores.
     */
    public void setScores(double[] scores) {
        this.scores = scores;
    }

    // Return an array double[] of scores as was previously set
    public double[] getScores() {
        return this.scores; // TODO: REMOVE ME
    }

    /*
     * Return the average of the scores after excluding the minimum and maximum
     * value. In short, it should return
     *   (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))/(n-2), where
     * n is the length of the score list. This function will return Double.NaN if
     * n is <= 2 because no meaningful average can be computed.
     */
    public double getCalibratedAverage() {
        if(this.scores.length<=2){return Double.NaN;}
        double myMin = this.scores[0];
        double myMax = this.scores[0];
        for(int i =1; i<this.scores.length;i++){
            if(this.scores[i]>myMax){myMax = this.scores[i];}
            else if(this.scores[i]<myMin){myMin = this.scores[i];}
        }
        double sum = 0;
        for (int i = 0; i < this.scores.length; i++) {sum += this.scores[i];}
        return (sum-myMax-myMin)/(this.scores.length-2);


    }

    public static void main(String[] args) {
        /*
        System.out.println("=== ScoreKeeper ===");
        double[] sampleScores0 = {2.5, 1.0, 9.8, 5.4, 3.3, 0.25, 4.25};
        double[] sampleScores1 = {0.5, 9};

        ScoreKeeper scoreKeeper0 = new ScoreKeeper();
        scoreKeeper0.setScores(sampleScores0);
        System.out.println("scoreKeegetAliasper0: " + Arrays.toString(scoreKeeper0.getScores()));
        System.out.println("Calibrated Average: " + scoreKeeper0.getCalibratedAverage());

        System.out.printf("\n");

        ScoreKeeper scoreKeeper1 = new ScoreKeeper();
        scoreKeeper1.setScores(sampleScores1);
        System.out.println("scoreKeeper1: " + Arrays.toString(scoreKeeper1.getScores()));
        System.out.println("Calibrated Average: " + scoreKeeper1.getCalibratedAverage());

         */
    }
}
