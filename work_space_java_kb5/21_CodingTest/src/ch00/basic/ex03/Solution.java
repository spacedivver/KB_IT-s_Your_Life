// 코딩테스트 연습 코딩테스트 입문 옹알이 (2)
// https://school.programmers.co.kr/learn/courses/30/lessons/133499
package ch00.basic.ex03;

// words
// "aya", "ye", "woo", "ma"

// babbling	                                        result
// ["aya", "yee", "u", "maa"]	                    1
// ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2

// 전략 = 앞에 문자열만 삭제 가능, 대신 삭제한 이전 문자열을 기억하여 반복되는 문자열은 스킵하도록 전략 수정!
// "aya", "ye", "woo", "ma"
// prev : aya
// ["", "uuu", "ye", "", "ayaa"]
//  "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"

import java.util.Arrays;

public  class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        String prevWord = "";
        for(int i = 0; i < babbling.length; i++){
            int replaceCount = 0;
            System.out.println("i : " + i +", prevWord : " + Arrays.toString(babbling));
            for(String word : words){
                System.out.println("\tword : " +  word);
                if(prevWord.equals(word)){
                    continue;
                }
                if(babbling[i].startsWith(word)){
                    babbling[i] = babbling[i].replaceFirst(word,"");
                    prevWord = word;
                    replaceCount++;
                    System.out.println("\t del : " + word +" babbling[i] : " + babbling[i]);
                }
            }
            if(replaceCount == 0){
                prevWord = ""; // 초기화
            } else{
                if(babbling[i].isEmpty()){
                    answer++;
                }
                i--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] babbling  = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int result = new Solution().solution(babbling);
        System.out.println(result);
    }
}