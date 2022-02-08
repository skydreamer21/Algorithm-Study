import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Q1655_other
{
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>( (a, b) -> b - a );
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>( (a, b) -> a - b );

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(maxQueue.size() == minQueue.size())
                maxQueue.offer(num);
            else
                minQueue.offer(num);

            if(!maxQueue.isEmpty() && !minQueue.isEmpty())
            {
                if(maxQueue.peek() > minQueue.peek())
                {
                    int tmp = maxQueue.poll();
                    maxQueue.offer(minQueue.poll());
                    minQueue.offer(tmp);
                }
            }
            //bw.write(maxQueue.peek() + "\n");
            sb.append(maxQueue.peek() + "\n");
            //System.out.println(maxQueue.peek());
        }
        System.out.println(sb.toString());
    }
}