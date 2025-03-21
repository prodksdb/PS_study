class Solution {
    
    static int count;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        dfs(numbers, 0, 0, target);
        return count;
    }
    
    public static void dfs( int [] numbers, int index, int sum, int target){
        if( index == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        
        // 현재 number +하기 
        dfs(numbers, index + 1 , sum + numbers[index], target);
        
        // 현재 number -하기 
        dfs(numbers, index + 1, sum - numbers[index], target);
        
    }
}