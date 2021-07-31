import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
    Stack <Character> str = new Stack<>();  
    
int max= s.length();
String y= "YES";
String n= "NO";
for(int i=0;i<max;i++)
{
    if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(')
    {
        str.push(s.charAt(i));
    }
    else
    {
        if(str.empty())
        {
            return n;
            
        }
       else{
           
        char value = str.pop();
        if(s.charAt(i)== ']' && value!='[')
        {
            return n;
        }
       else if(s.charAt(i)== '}' && value!='{')
        {
            return n;
        }  
        else if(s.charAt(i)== ')' && value!='(')
        {
            return n;
        } 
       }
        
    
    }
    
    
}
if(str.empty())
{
    return y;
}
  else
  {
      return n;
  }  

}
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
