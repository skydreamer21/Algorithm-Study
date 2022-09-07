function solution(number, k) {
    const len = number.length;
    const stack = [];
    for (let num of number) {
        stack.push(+num);
    }

    const ans = [];
    const numOfAns = len - k;
    let lastIdx = -1;

    for (let i=0;i<len;i++) {
        // console.log(`i:${i} -> ans:${ans}`);
        while (lastIdx >= 0 && ans[lastIdx] < stack[i]) {
            if (k-- <= 0) break;
            ans.pop();
            lastIdx--;
        }
        if (ans.length < numOfAns) {
            ans.push(stack[i]);
            lastIdx++;
        }
    }

    let ansStr = "";
    for (let num of ans) {
        ansStr += num;
    }

    return ansStr;
}