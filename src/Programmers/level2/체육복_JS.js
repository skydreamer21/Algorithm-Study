function solution(n, lost, reserve) {
    reserve.sort();
    const lostSet = new Set(lost);
    const reserveSet = new Set(reserve);

    for (let std of lostSet) {
        if (reserveSet.has(std)) {
            lostSet.delete(std);
            reserveSet.delete(std);
        }
    }

    const sideStds = [-1, 1];
    for (let reserveStd of reserveSet) {
        for (let side of sideStds) {
            const sideStd = reserveStd + side;
            if (lostSet.has(sideStd)) {
                lostSet.delete(sideStd);
                reserveSet.delete(sideStd);
                break;
            }
        }
    }

    const answer = n - lostSet.size;
    return answer;
}