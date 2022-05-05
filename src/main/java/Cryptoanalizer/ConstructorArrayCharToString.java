package Cryptoanalizer;

public class ConstructorArrayCharToString {
    private String[] strings;

    public ConstructorArrayCharToString(String strIn){
        setArrStrings(strIn);
    }

    public String[] getArrStrings() {
        return strings;
    }

    private void setArrStrings(String strIn) {
        char[] chars = strIn.toLowerCase().toCharArray();
        this.strings = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strings[i] = String.valueOf(chars[i]);
        }
    }
}
