function solution(numbers, target) {
    const LEN = numbers.length;
    let ans = 0;
    dfs(0,0);

    return ans;

    function dfs(depth, sum) {
        if (depth === LEN) {
            if (sum === target) ans++;
            return;
        }

        dfs(depth+1, sum + numbers[depth]);
        dfs(depth+1, sum - numbers[depth]);
    }
}