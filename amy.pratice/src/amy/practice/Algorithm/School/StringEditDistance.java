package amy.practice.Algorithm.School;

public class StringEditDistance {

	public int[][] stdArray;

	public int getSED(String a, String b, int ins, int del, int chg) {
		//편집거리
		int sed = 0;
		//첫 행초기화
		for(int i = 1; i < stdArray.length; i++) {
			stdArray[0][i] = stdArray[0][i-1]+ins;	
		}
		//첫 열 초기화
		for(int j = 1; j < stdArray[0].length; j++) {
			stdArray[j][0] = stdArray[j-1][0]+del;	
		}
		for(int n = 1; n <stdArray.length;n++) {
			for(int m = 1; m < stdArray[0].length; m++) {
		}
		return sed;
	}

	public static void main(String[] args) {
		StringEditDistance s = new StringEditDistance();
		String a = "SNOWY";
		String b = "SUNNY";
		int ins = 1;
		int del =1;
		int chg = 2;
		int expected = 4;
		s.stdArray = new int[a.length() + 1][b.length() - 1];
		System.out.println("a: " + a + " b: " + b + " expected : " + expected);
		System.out.println("actual :" + s.getSED(a, b,ins,del,chg));

	}

}
