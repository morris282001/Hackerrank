import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'poisonousPlants' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int poisonousPlants(List<Integer> p) {
    // Write your code here
  
   
    int count=0;
    int var=1;
    while(var == 1)
    {
        var=0; 
        for(int i= p.size()-1;i>0;i--)
        {
            
            if( p.get(i)>p.get(i-1))
            {
                p.remove(i);
                var=1;
            }
                
            
        }
        if(var==0)
        {
            break;
        }
        else{
            count++;
        }
        }
    
return count;
 


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p.add(pItem);
        }

        int result = Result.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
