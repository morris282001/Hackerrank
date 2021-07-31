import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
   Stack<Integer> s = new Stack<>();
   List<Integer> a= new ArrayList<>();
   //List<Integer> t= new ArrayList<>();
   String str= new String();
  // String num= new String();
   
   //int k=0;
   int max=0;
   
   for(int i=0;i< operations.size();i++)
   {
       str= operations.get(i);
       
       switch(str.charAt(0))
       {
           case '1': 
          // num= str.substring(2);
           
                s.push(Integer.parseInt(str.substring(2)));
                //t.add(Integer.parseInt(num));
                
                break;
                
            case '2':
            s.pop();
            //t.remove(t.size()-1);
            break;
            
            case '3':
            max= Collections.max(s);
            a.add(max);
            break;
                
       }
       
   }
   return a;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = Result.getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
