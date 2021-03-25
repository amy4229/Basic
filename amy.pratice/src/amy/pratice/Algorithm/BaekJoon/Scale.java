package amy.pratice.Algorithm.BaekJoon;

/**
 * ����#2920
 * �������� c d e f g a b C, �� 8�� ������ �̷�����ִ�. �� �������� 8�� ���� ������ ���� ���ڷ� �ٲپ� ǥ���Ѵ�. c��
 * 1��, d�� 2��, ..., C�� 8�� �ٲ۴�.
 * 
 * 1���� 8���� ���ʴ�� �����Ѵٸ� ascending, 8���� 1���� ���ʴ�� �����Ѵٸ� descending, �� �� �ƴ϶�� mixed
 * �̴�.
 * 
 * ������ ������ �־����� ��, �̰��� ascending����, descending����, �ƴϸ� mixed���� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
