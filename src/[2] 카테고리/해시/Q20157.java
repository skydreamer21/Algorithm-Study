// 2982번 (G5) [Map]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q20157 {
    static int N;
    static Map<String, Integer> ratioMap = new HashMap<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());

        // ******************** 메인 로직 ********************
        int maxScore = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> sortedNumbers = new ArrayList<>(List.of(a, b));
            String ratio = makeRatioExpression(sortedNumbers);
            if (ratioMap.containsKey(ratio)) {
                ratioMap.put(ratio, ratioMap.get(ratio) + 1);
            } else {
                ratioMap.put(ratio, 1);
            }
            maxScore = Math.max(maxScore, ratioMap.get(ratio));
        }

        ratioMap.keySet().forEach(System.out::println);

        // ******************** 정답 출력 ********************
        sb.append(maxScore);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String makeRatioExpression (List<Integer> sortedNumbers) {
        return calculateRatio(sortedNumbers).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(":"));
    }

    public static List<Integer> calculateRatio(List<Integer> sortedNumbers) {
        List<Integer> absSortedNumbers = absList(sortedNumbers);
        int gcd = calculateGcd(absSortedNumbers.get(1), absSortedNumbers.get(0));
        return sortedNumbers.stream()
                .map(number -> number / gcd)
                .collect(Collectors.toList());
    }

    public static int calculateGcd(int biggerNumber, int smallerNumber) {
        if (smallerNumber == 0) {
            return  biggerNumber;
        }
        return calculateGcd(smallerNumber, biggerNumber % smallerNumber);
    }

    public static List<Integer> absList(List<Integer> numbers) {
        return numbers.stream().map(Math::abs)
                .collect(Collectors.toList());
    }
}
