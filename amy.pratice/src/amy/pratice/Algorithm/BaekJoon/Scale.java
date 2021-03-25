package amy.pratice.Algorithm.BaekJoon;

/**
 * 백준#2920
 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는
 * 1로, d는 2로, ..., C를 8로 바꾼다.
 * 
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed
 * 이다.
 * 
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 * 
 * @author amy
 *
 */
public class Scale {
	public  final String ASCENDING = "12345678";
	public final String DESCENDING = "87654321";
	public String judgeScale(String input) {
		String result = "";
		String scale= input.replace(" ","");
		if(scale.equals(ASCENDING)) {
			result = "ascending";
		}else if(scale.equals(DESCENDING)) {
			result = "descending";
		}else{
			result = "mixed";
		}
		return result;
	}

	public static void main(String[] args) {
		Scale s = new Scale();
		String input1 = "1 2 3 4 5 6 7 8";
		String expected = "ascending";
		System.out.println("expected: " + expected + "actual: " + s.judgeScale(input1));
		String input2 = "8 7 6 5 4 3 2 1";
		String expected2 = "descending";
		System.out.println("expected: " + expected2 + "actual: " + s.judgeScale(input2));
		String input3 = "8 1 7 2 6 3 5 4";
		String expected3 = "mixed";
		System.out.println("expected: " + expected3 + "actual: " + s.judgeScale(input3));

	}
}
