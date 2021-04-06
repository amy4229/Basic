package amy.practice.Algorithm.BaekJoon;

import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class OverAverage {

	public static double getRatio(int[] scores) {
		double avg = IntStream.of(scores).parallel().average().getAsDouble();
		double overAvg = IntStream.of(scores).parallel().filter(score->score>avg).count();
		return overAvg/scores.length*100.000;
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int no = sc.nextInt();
    	double[] ratio = new double[no];
    	sc.nextLine();
    	int i =0;
    	while(i < no) {
    		int stdNo = sc.nextInt();
    		int[] scores = new int[stdNo];
    		for(int j = 0; j < stdNo ; j++) {
    			scores[j] = sc.nextInt();
    		}
    		sc.nextLine();
    		ratio[i] = getRatio(scores);
    		i++;
    	}
    	
    	DoubleStream.of(ratio).forEach(r->System.out.printf("%.3f%s\n",r,"%"));
    	
    }

}
