package lab1;

public class Exercise2 {

	public static String longestString (String[] inputs) {
		
		if(inputs == null || inputs.length == 0) {
			return null; 
		}
		
		String longest = inputs[0];
		
		for (int i=1; i<inputs.length; i++) {
			if(inputs[i].length() >= longest.length()) {
				longest = inputs[i];
			}
		}
		
		return longest;
	}
	
	
	public static void main(String[] args) {
        String[] inputs1 = {"a", "ab", "abc", "bcd", "e"};

        System.out.println("Longest in inputs1: " + longestString(inputs1)); // 'bcd'

    }

}
