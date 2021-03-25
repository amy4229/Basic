package amy.pratice.Algorithm.BaekJoon;

import java.util.Scanner;

/**
  * ����#10818
  * N���� ������ �־�����. �̶�, �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
