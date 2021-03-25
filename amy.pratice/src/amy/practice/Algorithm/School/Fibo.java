package amy.practice.Algorithm.School;
/**
 * 피보나치 수열 (분할정복방법 VS 동적프로그래밍 방법)
 * @author amy
 *
 */
public class Fibo {
	
	/**
	 * fibo2를 위한 동적프로그래밍방법에서 소문제의 해를 저장할 테이블
	 */
	public int[] fiboArray;
	 
	/**
	 * 분할 정복방법을 이용
	 * @param 인덱스
	 * @return n+1번째 피보나치수열의 수 
	 */
	public int fibo1(int n) {
		
		System.out.println("fibo1("+n+")");
		if(n<=1) {
			return n;
		}else {
			return fibo1(n-1)+fibo1(n-2);
		}
	} 
	
	/**
	 * 동적프로그래밍방법을 이용
	 * @param 인덱스
	 * @return n+1번째 피보나치수열의 수 
	 */
	public int fibo2(int n) {
		for(int i = 0; i <= n;i++) {
			System.out.println("fibo2("+i+")");
			if(i < 2) {
				fiboArray[i]=i;
			}else {
				fiboArray[i] = fiboArray[i-1] + fiboArray[i-2];
			}
		}
		return fiboArray[n];
	} 

	public static void main(String[] args) {
		Fibo f = new Fibo();
		int n = 5;
		f.fiboArray = new int[n+1];
		System.out.println("n이 5일 때 피보나치수열[0, 1, 1, 2, 3, 5] 따라서 예상값은 5 ");
		System.out.println("분할정복방법====================");
		System.out.println("분할정복 과정 결과 :" + f.fibo1(n));
		System.out.println("");
		
		System.out.println("동적프로그래밍방법====================");
		System.out.println("동적프로그래밍 과정 결과 : " + f.fibo2(n));

	}

}
