import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    // Write your code here
   Stack<Integer> right = new Stack<>();
   Stack<Integer> left = new Stack<>();
 
   int length=0;
   int r1=0;
   int l1=0;
   for(int i=0;i< h.size();i++)
   {
      
      /* if(i== h.size()-1 || h.get(i)==min)
       {
           right.push(h.size());
       }*/
       for(int j=i+1;j<h.size();j++)
       {
           if( h.get(j)<h.get(i))
           {
               right.push(j);
               r1=1;
               break;
           }
           
       }
       if( r1==0)
       {
          right.push(h.size()); 
       }
      /* if( i==0 || h.get(i)== min)
       {
           left.push(-1);
       }*/
       
       for(int k=i-1;k>=0;k--)
       {
           if(h.get(k)<h.get(i))
           {
               left.push(k);
               l1=1;
               break;
           }
       }
        if( l1==0)
       {
          left.push(-1); 
       }
       r1=0;
       l1=0;
      }
   
   int maxarea=0;
   for(int i= h.size()-1; i>=0;i--)
      {
          
          
          length= right.peek() - left.peek() -1;
          if( maxarea< length* h.get(i))
          {
              maxarea= length* h.get(i);
          }
          left.pop();
          right.pop();
         
          
   }
  

   return maxarea;
   
  
   


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
