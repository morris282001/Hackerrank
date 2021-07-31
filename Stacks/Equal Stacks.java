import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code; here
Stack<Integer> s1= new Stack<>();
Stack<Integer> s2= new Stack<>();
Stack<Integer> s3= new Stack<>();
int H1=0,H2=0,H3=0;
   for(int i = h1.size() -1; i>= 0 ; i--)
       {
           s1.push(h1.get(i));
           H1 = H1 + h1.get(i); 
       } 
       
       for(int i = h2.size() -1; i>= 0 ; i--)
       {
           s2.push(h2.get(i));
           H2 = H2 + h2.get(i); 
       } 
       
       for(int i = h3.size() -1; i>= 0 ; i --)
       {
           s3.push(h3.get(i));
           H3 = H3+ h3.get(i); 
       }
if(H1 == H2 && H2 == H3)
{
    return H1;
}
else{
   
    while(H1!=H2 || H2!=H3 || H3!=H1)
    {
        if(s1.empty() || s2.empty() || s3.empty())
        {
            return 0;
        }
    //int msum = Math.max(H1 , H2 );
             //  int maxsum = Math.max(msum , H3);
   /* if( maxsum== H1)
    {
        H1= H1- s1.pop();
    }
    if( maxsum== H2)
    {
        H2= H2- s2.pop();
    }
    if( maxsum== H3)
    {
        H3= H3- s3.pop();
    }*/
    if(H1>=H2 && H1>=H3)
    {
        H1= H1-s1.pop();
    }
    else if (H2>=H1 && H2>=H3)
    {
        H2= H2-s2.pop();
    }
    else if( H3>=H1 && H3>=H2)
    {
        H3= H3- s3.pop();
    }
    
        
    }
    
}

return H1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
