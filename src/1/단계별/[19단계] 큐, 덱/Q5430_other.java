
import java.io.*;
public class Q5430_other {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< N; i++){
            String commandStr = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String numStr = br.readLine();
            String[] numArray;
            if (length == 1) {
                numArray = new String[]{numStr.substring(1, numStr.length() - 1)};
            }
            else numArray = numStr.substring(1, numStr.length() - 1).split(",");
            int start = 0;
            int end;
            if(numArray.length ==0) end = 0;
            else end =numArray.length-1;
            int front = 1;
            for(int j=0;j<commandStr.length();j++){
                if(commandStr.charAt(j)=='R'){
                    front *=-1;
                }
                else{
                    length--;
                    if(front == 1){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
            if (length < 0) {
                System.out.println("error");
                continue;
            }
            else if (length==0) {
                System.out.println("[]");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if (front == 1) {
                for (int j = start; j <= end ; j++) {
                    sb.append(numArray[j]);
                    sb.append(',');
                }
            }
            else{
                for (int j = end; j >= start ; j--) {
                    sb.append(numArray[j]);
                    sb.append(',');
                }
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            sb.append(']');
            System.out.println(sb.toString());
        }
    }
}