function solution(word) {
    const NUM_OF_CHAR = 5;
    const EMPTY = 0;
    const map = new Map();
    map.set('A', 1);
    map.set('E', 2);
    map.set('I', 3);
    map.set('O', 4);
    map.set('U', 5);

    const dp = new Array(6).fill(0); dp[0] d[1] dp[2]
    const len = word.length;
    let numOfCases = 0;
    for (let i=1;i<=len;i++) {
        const charOrderInDict = map.get(word[i-1]);
        const emptySpace = NUM_OF_CHAR - i;

        numOfCases += (charOrderInDict-1)*eachDigitNumOfCases(emptySpace); // 1*dp[emptySpace]
        numOfCases++; // B
        // console.log(`charOrderInDict:${charOrderInDict}, emptySpace:${emptySpace}`);
        // console.log(`i:${i}, numOfCases:${numOfCases}`);
    }

    return numOfCases;

    function eachDigitNumOfCases(n) {
        if (n==0) {
            return dp[n] = 1;
        }
        if (dp[n] != EMPTY) return dp[n];

        dp[n] = 1 + NUM_OF_CHAR*(eachDigitNumOfCases(n-1));
        return dp[n];
    }
}

/*
const VOWELS = ['A','E','I','O','U','']

const f=(a)=>VOWELS.map(b=>b+a)

function solution(word) {
    const ans = Array.from(
        new Set(VOWELS
            .map(f).flat()
            .map(f).flat()
            .map(f).flat()
            .map(f).flat())
        ).sort().indexOf(word)
    return ans;
}
*/
