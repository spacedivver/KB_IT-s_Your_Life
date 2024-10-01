// 정렬 > 가장 큰 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42746

// numbers				return
// [6, 10, 2]			"6210"
// [3, 30, 34, 5, 9]	"9534330"
// [0, 0, 0, 0, 0, 0]   "0"
// 전략 -> numbers 정렬 시키는에, 문자열중 어떤 값이 기대값이 높을 것인지 기준?
//  [6, 10, 2] -> 6 > 2 > 10
//  [3, 30, 34, 5, 9] -> 9 > 5 > 34 > 3 > 30
// 정렬 방법을 유추하는것이 핵심?
// -> 사전순? X
// 3 > 30, 330, 303, 기준은 두수를 조합해서 더 큰값이 되는 순서로 높은 취급을 해준다!


package ch03.sort.ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int num : numbers){
            list.add("" + num);
        }
        list.sort((o1, o2)->{
            return (o2 + o1).compareTo(o1 + o2);
        });
//        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            if(str.equals("0") && sb.length() == 0){
                continue;
            }
            sb.append(str);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0, 0, 0,};
        String result = new Solution().solution(numbers);
        System.out.println(result);
    }
}
