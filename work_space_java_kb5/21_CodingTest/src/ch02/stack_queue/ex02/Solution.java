// 스택/큐 > 기능개발
// https://school.programmers.co.kr/learn/courses/30/lessons/42586

package ch02.stack_queue.ex02;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    // progresses				speeds				return
    // [93, 30, 55]				[1, 30, 5]			[2, 1]
    // [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

    // 풀이 전략! -> 전형적인 Round를 돌리는 문제로 시뮬레이션을 해보고 그대로 구현하면 끝나는 문제!
    // 	[93, 30, 55] 	[1, 30, 5]	 [2, 1]
    //1 [94, 60, 60] -> 배포가능? X
    //2 [95, 90, 65] -> 배포가능? X
    //3 [96, 100, 70] -> 배포가능? 2번째가 100 이상 이긴한데, 1번째가 96임으로 배포 불가능! X
    //4 [97, 100, 75] -> 배포가능? X
    //5 [98, 100, 80] -> 배포가능? X
    //6 [99, 100, 85] -> 배포가능? X
    //7 [100, 100, 90] -> 배포가능? 1, 2번째가 100이상임으로 배포 가능! O, 답: [2]
    //8 [100, 100, 95] -> 배포가능? X
    //9 [100, 100, 100] -> 배포가능? 3번째 배포 가능! 답: [2, 1]

    // 문제풀이 Step
    // 1. Round 돌리는 반복문을 만든다.
    // 2. 제대로 증감 감소하는지 확인
    // 3. 정답과 유사하게 꾸미고
    // 4. 마지막은 Break point를 잡아 알고리즘을 완성!

    public int[] solution2(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int[] state = new int[progresses.length]; // 0 = 개발중, 1=배포가능, 2=배포 끝
        int count = 0;
        int allFinishCount = 0; // 작업이 끝난 숫자

        // 임시 반복문 초기에는 for문 나중에는 while로 바꿔 break 지점을 정한다.
//		for(int k = 0; k < 10; k++) {
        while(true){
            int finishCount = 0; // flag 변수, 0이 아닌경우 배포가 될수 있다는 숫자
            // 초기에 Round를 돌리는 부
            for(int i = 0; i <progresses.length; i++) {
                progresses[i] += speeds[i]; // 증감부!!
                // 개발이 끝나서 배포 가능한지 체크하는 if문
                if(progresses[i] >= 100) { // state 업데이트!
                    state[i] = 1;
                    progresses[i] = Integer.MIN_VALUE; // 최소값으로 초기화, 이후에는 100 이상이 될일이 없다!
                    finishCount++; // 배포 가능여부 업데이트!
                }
            }

            // 배포 체크
            if(finishCount > 0) { // 배포가 가능할때
                allFinishCount += finishCount; // 실제 작업이 끝난 갯수!
                int deployCount = 0; // 배포가 가능한 숫자
                for(int i = 0; i < state.length; i++) {
                    if(state[i] == 0) { // 앞에 개발이 안된경우임으로 할꺼 없다!
                        break;
                    }
                    if(state[i] == 1) { // 배포 가능할때!!
                        deployCount++;
                        state[i] = 2; // 배포 완료!
                    }
                }
                // 실제 정답 내는곳
                if(deployCount > 0) {
                    answer[count++] = deployCount;
                }
            }
            // finish 여부 체크 -> 앞에할지 뒤에들어갈지 모른다!
            if(allFinishCount == progresses.length) {
                break;
            }
        }
        return Arrays.copyOf(answer, count);
    }

    // 의도대로 Stack으로 풀이한 방법
    // -> 전략 : 개발 가능일을 미리 계산한 스택을 구성하고, pop을 하면서 answer를 계산
    //  progresses	                speeds	            return
    //  [93, 30, 55]	            [1, 30, 5]	        [2, 1]
    //  Stack : [7, 3, 9]
    //
    //  init prevMaxDay = 7 (pop한 값), answer[1]
    //  #1 : pop 3, if (3 <= 7), prevMaxDay = 7, answer[2]
    //  #2 : pop 9, if (9 <= 7)  prevMaxDay = 9, answer[2, 1]
    public int[] solution(int[] progresses, int[] speeds) {
        // LinkedList는 Stack, queue를 모두를 대체할수 있음
        LinkedList<Integer> deque = new LinkedList<>();
        int[] answer = new int[progresses.length];

        // Stack 초기화문
        // -> 이걸 아래 계산식과 합칠수도 있지만, step-by-step으로 푸는걸 추천!
        for(int i = 0; i < progresses.length; i++) {
            // 아래 수식을 유추하는게 어렵다면, 위처럼 중첩 반복문으로 100되는 순간을 day로 계산!
            int day = (int)Math.ceil((100 - (double)progresses[i]) / speeds[i]);
            deque.add(day);
        }
//		System.out.println(deque);

        // 답내는 초기화문, 첫번째는 수동으로 값들을 초기상태로 만들어준다.
        // -> 이게 아니면 while문에서 초기상태일때 체크하는 if문 한줄이 추가된다.
        int prevMaxDay = deque.pop();
        int answerIndex = 0;
        answer[answerIndex]++;

        while(!deque.isEmpty()) {
            int day = deque.pop();
            if(day > prevMaxDay){
                answerIndex++;
            }
            answer[answerIndex]++;
//			prevMaxDay = Math.max(day, prevMaxDay);
            prevMaxDay = Integer.max(day, prevMaxDay);
        }

        return Arrays.copyOf(answer, answerIndex + 1);
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = new Solution().solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }
}
