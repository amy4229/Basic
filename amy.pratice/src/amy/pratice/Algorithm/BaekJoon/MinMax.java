package amy.pratice.Algorithm.BaekJoon;

import java.util.Scanner;

/**
  * 백준#10818
  * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 * @author "Amy"
 *
 */
public class MinMax {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]  array=new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		int min = array[0];
        int max = array[0];
        
        for(int j = 1; j < n; j++){
            min = Math.min(min,array[j]);
            max = Math.max(max,array[j]);
        }
        System.out.println(min+" "+max);
		
	}
}
