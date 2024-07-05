package lab1_extra;

public class Exercise1 {
    
    public static double variance(double[] inputSet) {
        double sum = 0.0;
        double mean;
        double variance = 0.0;
        int n = inputSet.length;

        // Calculate the mean
        for (double num : inputSet) {
            sum += num;
        }
        mean = sum / n;

        // Calculate the variance
        for (double num : inputSet) {
            variance += Math.pow(num - mean, 2);
        }
        variance /= n;

        return variance;
    }

    public static void main(String[] args) {
        double[] inputSet = {2.3, 5.7, 1.8, 4.1, 3.3};
        double result = variance(inputSet);
        System.out.println("The variance of the input set is: " + result);
    }
}

