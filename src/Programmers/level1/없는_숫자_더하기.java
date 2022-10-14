// sol1
/*class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int num : numbers) answer-=num;
        return answer;
    }
}*/

/*
// sol2
class Solution {
    public int solution(int[] numbers) {
        boolean[] nums = new boolean[10];
        for (int num : numbers) nums[num] = true;
        int answer = 0;

        for (int i=0;i<10;i++) {
            if(!nums[i]) answer+=i;
        }
        return answer;
    }
}
*/