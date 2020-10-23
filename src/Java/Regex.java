package Java;

import java.util.Scanner;

class Regex{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex {
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}
// 1) \\d{1,2} catches any one or two digit number
// 2) (0|1)\\d{2} catches any three digit number starting with 0 or 1. [000-199]
// 3) 2[0-4]\\d catches numbers between 200 and 249.
// 4) 25[0-5] catches numbers between 250 and 255.
// \d ~ [0-9]