package java_sample;

public class HighLevelSample {

    private static boolean isNameHasUpperCase(String text) {
        boolean result = false;
        for (int index = 0; index < text.length(); index++) {
            if (Character.isUpperCase(text.charAt(index))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("abc = " + isNameHasUpperCase("abc"));
        System.out.println("aBc = " + isNameHasUpperCase("aBc"));
    }

}
