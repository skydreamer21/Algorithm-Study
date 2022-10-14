// D번 미적분학 입문하기2
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

// 부피구하는 방식 2가지..

import java.io.*;
import java.util.StringTokenizer;

public class YPC1_4 {
    static final double pi = Math.PI;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        P12 p1 = new P12(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
        P12 p2 = new P12(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
        P12 p3 = new P12(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
        sb.append(getVx(p1,p2,p3)).append(" ").append(getVy(p1,p2,p3));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static double getVx (P12 p1, P12 p2, P12 p3) {
        double v1 = Vx(p1, p2);
        double v2 = Vx(p2, p3);
        double v3 = Vx(p3, p1);
        double maxV = Math.max(v1,Math.max(v2,v3));
        System.out.printf("%f %f %f\n",v1,v2,v3);
        if (maxV==v1) return v1-v2-v3;
        else if (maxV==v2) return v2-v1-v3;
        else return v3-v1-v2;
    }

    public static double getVy (P12 p1, P12 p2, P12 p3) {
        double v1 = Vy(p1, p2);
        double v2 = Vy(p2, p3);
        double v3 = Vy(p3, p1);
        double maxV = Math.max(v1,Math.max(v2,v3));
        System.out.printf("%f %f %f\n",v1,v2,v3);
        if (maxV==v1) return v1-v2-v3;
        else if (maxV==v2) return v2-v1-v3;
        else return v3-v1-v2;
    }

    public static double Vx (P12 p1, P12 p2) {
        double h;
        double ratio;
        double h1 = Math.max(p1.y,p2.y);
        double h2 = Math.min(p1.y,p2.y);
        if (p1.y==p2.y) {
            h = Math.abs(p1.x-p2.x);
            return pi*Math.pow(p1.y,2)*h;
        }
        else if (h2==0) {
            h = Math.abs(p1.x-p2.x);
            return pi*(1.0/3.0)*Math.pow(h1,2)*h;
        }
        else {
            h = (Math.abs(p1.x-p2.x)*h2/Math.abs(p1.y-p2.y))+Math.abs(p1.x-p2.x);
            ratio = (Math.pow(h1,3)-Math.pow(h2,3))/Math.pow(h1,3);
            return pi*(1.0/3.0)*Math.pow(h1,2)*h*ratio;
        }
    }

    public static double Vy (P12 p1, P12 p2) {
        double h;
        double ratio;
        double h1 = Math.max(p1.x,p2.x);
        double h2 = Math.min(p1.x,p2.x);
        if (p1.x==p2.x) {
            h = Math.abs(p1.y-p2.y);
            return pi*Math.pow(p1.x,2)*h;
        }
        else if (h2==0) {
            h = Math.abs(p1.y-p2.y);
            return pi*(1.0/3.0)*Math.pow(h1,2)*h;
        }
        else {
            h = (Math.abs(p1.y-p2.y)*h2/Math.abs(p1.x-p2.x))+Math.abs(p1.y-p2.y);
            ratio = (Math.pow(h1,3)-Math.pow(h2,3))/Math.pow(h1,3);
            return pi*(1.0/3.0)*Math.pow(h1,2)*h*ratio;
        }
    }
}

class P12 {
    double x,y;
    public P12 (double x, double y) {
        this.x=x;
        this.y=y;
    }
}
