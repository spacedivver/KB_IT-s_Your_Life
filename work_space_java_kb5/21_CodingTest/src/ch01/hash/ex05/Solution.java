// 해시 > 베스트앨범
// https://school.programmers.co.kr/learn/courses/30/lessons/42579

package ch01.hash.ex05;


// genres											plays						return
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
// TC 너무 적은 문제로 TC 좀 만들어서 검증해야한다.
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 500, 500, 2500]	[4, 1, 0, 2]
// -> 재생횟수가 같은 노래가 많은경우는? -> 고유번호가 낮아한다.
// ["classic", "classic", "classic", "classic", "pop"]	[500, 500, 500, 500, 2500]	[4, 0, 1]
// ["classic", "classic", "classic", "classic", "classic"]	[500, 500, 500, 500, 2500]	[4, 0]
// -> 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.

// 주요 요구사항
//1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

// 제한사항
// 1. genres[i]는 고유번호가 i인 노래의 장르입니다.
// 2. plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
// 3. genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
// 4. 장르 종류는 100개 미만입니다.
// 5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
// 6. 모든 장르는 재생된 횟수가 다릅니다.

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Integer>> genresTimeMap = new HashMap<>();
        Map<String, Integer> genresToTotalTimeMap = new HashMap<>();
        Map<Long, Set<Integer>> idToIndexMap = new HashMap<>();

        for(int i = 0; i< genres.length; i++){
            // idKey = 고유 값을 가져오면 index를 반환하는 자료구조
            // 장르의 고유 해시키 + 재생시간을 조합하면 index를 반환하는 맵
            long idKey = (long) genres[i].hashCode() * 100000 + plays[i];
            if(idToIndexMap.get(idKey) == null){
                idToIndexMap.put(idKey, new TreeSet<>());
            }
            idToIndexMap.get(idKey).add(i);

            if(genresTimeMap.get(genres[i]) == null){
                genresTimeMap.put(genres[i], new PriorityQueue<>(Comparator.reverseOrder()));
            }
            genresTimeMap.get(genres[i]).offer(plays[i]);

            genresToTotalTimeMap.putIfAbsent(genres[i], 0);
            genresToTotalTimeMap.put(genres[i],
                            genresToTotalTimeMap.get(genres[i]) + plays[i]) ;

        }
//        System.out.println("genresTimeMap");
//        System.out.println(genresTimeMap);
//        System.out.println("genresToTotalTimeMap");
//        System.out.println(genresToTotalTimeMap);
//        System.out.println("idToIndexMap");
//        System.out.println(idToIndexMap);

        Map<Integer, String> totalTimeToGenresMap
                            = new TreeMap<>(Comparator.reverseOrder());
        for(String genre : genresToTotalTimeMap.keySet()){
            totalTimeToGenresMap.put(genresToTotalTimeMap.get(genre), genre);
        }
        // 역맵
//        System.out.println("totalTimeToGenresMap");
//        System.out.println(totalTimeToGenresMap);

        // 수록곡 선택하는 과정
        int[] answer = new int[genres.length];
        int count = 0; // 수록곡 자를 숫자!

        for(Map.Entry<Integer, String> entry : totalTimeToGenresMap.entrySet()){
            String genre = entry.getValue(); // 가장 많이 재생된 장르를 뽑고
            PriorityQueue<Integer> queue = genresTimeMap.get(genre);
            for(int i = 0; i < 2; i++){
                int musicTime = queue.poll();
                long idKey = (long)genre.hashCode() * 100000 + musicTime;
                Set<Integer> indexSet = idToIndexMap.get(idKey);
                int firstIndex = indexSet.iterator().next();
                answer[count++] = firstIndex;
                indexSet.remove(firstIndex);
                if(queue.isEmpty()){
                    break;
                }
            }
        }
        return Arrays.copyOf(answer, count);
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//    	int[] plays = {500, 600, 150, 800, 2500};
        int[] plays = {500, 600, 500, 500, 2500}; // 겹치는 케이스
        int[] result = new Solution().solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
}