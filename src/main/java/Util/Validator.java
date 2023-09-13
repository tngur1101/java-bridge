package Util;

public class Validator {
    private final String ERROR_MESSAGE = "[ERROR]";

    public void validateBridgeNumber(String input, int min, int max){
        if(!input.matches("[0-9]+")){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자만 입력 가능합니다.");
        }

        int num = Integer.parseInt(input);
        if(num < min || num > max){
            throw new IllegalArgumentException(ERROR_MESSAGE + min +"이상 " + max + "이하의 숫자만 입력 가능합니다.");
        }
    }

    public void validateWord(String input, String word1, String word2){
        if(!input.equals(word1) && !input.equals(word2)){
            throw new IllegalArgumentException(ERROR_MESSAGE + word1 + " 또는 " + word2+"만 입력 가능합니다.");
        }
    }
}
