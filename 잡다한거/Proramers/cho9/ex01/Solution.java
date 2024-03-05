package cho9.ex01;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        String[] letters = letter.split(" ");
        Map<String, String> morse=new HashMap<String, String>();
        morse.put(".-","a");
        morse.put("-...","b");
        morse.put("-.-.","c");
        morse.put("-..","d");
        morse.put(".","e");
        morse.put("..-.","f");
        morse.put("--.","g");
        morse.put("....","h");
        morse.put("..","i");
        morse.put(".---","j");
        morse.put("-.-","k");
        morse.put(".-..","l");
        morse.put("--","m");
        morse.put("-.","n");
        morse.put("---","o");
        morse.put(".--.","p");
        morse.put("--.-","q");
        morse.put(".-.","r");
        morse.put("...","s");
        morse.put("-","t");
        morse.put("..-","u");
        morse.put("...-","v");
        morse.put(".--","w");
        morse.put("-..-","x");
        morse.put("-.--","y");
        morse.put("--..","z");
        
        
        StringBuilder builder = new StringBuilder();
        for (String str : letters) {
			builder.append(morse.get(str));
		}
        answer = builder.toString();
        
        return answer;
    }
}
/*
 * 모스부호를 이용한 편지를 받았습니다.
 * 해독하는 프로그램을 만들려고합니다.
 * 문자열 letter가 매개변수로 주어질 때, 
 * letter를 영어 소문자로 바꾼 문자열을 
 * return 하도록 solution 함수를완성해보세요
 */

/*
 * 받은 모스 편지를 불러온다
 * 모스부호를 letter에 넣는다
 * 가져온 모스부호를 letter와 비교 한다
 * 같은 알바벳을 문자열로 바꾼다
 * 문자열을 리턴한다 
 */