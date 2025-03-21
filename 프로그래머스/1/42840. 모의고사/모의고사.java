import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 학생의 찍기 패턴 정의
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 점수 초기화
        int score1 = 0, score2 = 0, score3 = 0;
        
        // 각 문제에 대해 세 학생의 답안을 평가
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                score1++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                score2++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                score3++;
            }
        }
        
        // 최대 점수 계산
        int maxScore = Math.max(score1, Math.max(score2, score3));
        
        // 최대 점수를 얻은 학생 번호를 ArrayList에 담기
        List<Integer> list = new ArrayList<>();
        if (score1 == maxScore) list.add(1);
        if (score2 == maxScore) list.add(2);
        if (score3 == maxScore) list.add(3);
        
        // 결과를 int 배열로 변환하여 반환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
