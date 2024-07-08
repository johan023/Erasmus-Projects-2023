package lab1_extra;

public class Exercise2 {
	static String upsideDown(String input) {
	    StringBuilder sb = new StringBuilder();
	    for (char c : input.toCharArray()) {
	        if (Character.isUpperCase(c)) {
	            sb.append(Character.toLowerCase(c));
	        } else if (Character.isLowerCase(c)) {
	            sb.append(Character.toUpperCase(c));
	        } else {
	            sb.append(c);
	        }
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
	    String input = "Ab%Cd";
	    String result = upsideDown(input);
	    System.out.println("Original: " + input);
	    System.out.println("Upside Down: " + result);
	}

}
