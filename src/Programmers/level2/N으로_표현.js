function solution(N, number) {
    if (number === N) return 1;

    const NONE = -1;
    const isNumberMade = new Array(N+1).fill(false);
    const dp = [];

    // 초기값
    dp.push([]);
    dp.push([N]);
    isNumberMade[N] = true;

    for (let times=2;times<=8;times++) {
        // console.log(`===== ${times}번 사용 결과 =====`)
        makeNumberByNtimes(times);
        if (dp[times].indexOf(number) !== NONE) {
            return times;
        }
    }

    return -1;

    function onlyNumber(num, k) {
        let sum = num;
        for (let i=1;i<k;i++) {
            sum *= 10;
            sum += num;
        }
        return sum;
    }

    function makeNumberByNtimes(k) {
        dp.push([onlyNumber(N,k)]);
        for (let i=k-1;i>=1;i--) {
            // 5를 i번 사용한 결과와 (k-i)번 사용한 결과를 이용해서 숫자를 만듬
            for (let num1 of dp[i]) {
                for (let num2 of dp[k-i]) {
                    basicOperationResult(num1, num2, k);
                }
            }
        }
    }


    function basicOperationResult(num1, num2, k) {
        const calRes = [num1 + num2, num1 - num2, num1 * num2, parseInt(num1 / num2)]

        for (let res of calRes) {
            if (isNumberMade[res] || res === 0) continue;
            dp[k].push(res);
            isNumberMade[res] = true;
        }
    }
}