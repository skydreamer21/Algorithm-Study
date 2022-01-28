import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541_other {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] str2 = str.split("\\-");
        int result = 0;

        for(int i=0;i<str2.length;i++){
            int value = 0;
            String[] items = str2[i].split("\\+");
            for(String item:items){
                value += Integer.parseInt(item);
            }
            if(i == 0){
                result += value;
            } else{
                result -= value;
            }
        }
        System.out.println(result);
    }
}