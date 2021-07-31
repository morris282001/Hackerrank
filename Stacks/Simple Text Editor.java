import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Q = sc.nextInt();

        int tag, k;
        String last, newString;
        Stack<String> stack = new Stack<>();

        while(Q-- >0){
            tag = sc.nextInt();
            switch (tag){
                case 1:
                    
                    last = stack.size() > 0 ? stack.peek() : "";
                    newString = last + sc.next();

                    stack.push(newString);
                    break;
                case 2:
                    
                    k = sc.nextInt();
                    last = stack.peek();
                    newString = last.substring(0, last.length()-k);
                   
                    stack.push(newString);
                    break;
                case 3:
                    
                    k = sc.nextInt()-1;
                    if(stack.size() > 0) {
                        last = stack.peek();
                        String c = String.valueOf(last.charAt(k));
                        
                        System.out.println(c);
                    }
                    break;
                case 4:
                    
                    stack.pop();
                    break;
            }
        }
    }
}
