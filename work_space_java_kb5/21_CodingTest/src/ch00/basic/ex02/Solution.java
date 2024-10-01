// 코딩테스트 연습 코딩테스트 입문 옹알이 (1)
// https://school.programmers.co.kr/learn/courses/30/lessons/120956
package ch00.basic.ex02;

// "aya", "ye", "woo", "ma" 

//  babbling	                                result
//  ["aya", "yee", "u", "maa", "wyeoo"]	        1
//  ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3
//  전략 replace로 풀이하면 될듯?

// 손으로 풀이 -> 무작정 replace는 안된다!
// "aya", "ye", "woo", "ma" 
// ["", "e", "u", "maa", ""]

// replace를 remove용도가 아닌 다른 문자열 = 공백으로 바꾸자!
// "aya", "ye", "woo", "ma"
// [" ", " e", "u", "maa", "w oo"]

public class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(String bword : babbling){
//            System.out.println(bword);
            for(String word : words){
                bword = bword.replace(word, " ");
//                System.out.println(bword);
                if(bword.trim().isEmpty()){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling  = { "aya", "yee", "u", "maa", "wyeoo"};
        int result = new Solution().solution(babbling);
        System.out.println(result);
    }
}