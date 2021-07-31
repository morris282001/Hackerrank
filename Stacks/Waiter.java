import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
    // Write your code here
Stack<Integer> a= new Stack<>();
Stack<Integer> b= new Stack<>();
//Stack<Integer> stk= new Stack<>();
List<Integer> answer = new ArrayList<>();
int x[]= new int[50000];
int prime[]= new int[100000];
int ct=0,n=0,c=1,d=1,element=0,num=0;

while(n<q)  
{  
d=1;  
ct=0;  
while(d<=c)  
{  
if(c%d==0)  
ct++;  
d++;   
}  
if(ct==2)  
{  
prime[element]=c; 
element++;
n++;  
}  
c++;  
} 

    


for( int i=0;i<number.size();i++)
{
   a.push(number.get(i)); 
}


    for(int i=0;i<q;i++)
    {
        while(!a.empty())
        {
        if(a.peek()% prime[i] == 0)
        {
            b.push(a.peek());
            a.pop();
            
        }
        else{
            x[num]=a.peek();
            a.pop();
            
            num++;
        }
        }
        while(!b.empty())
        {
  answer.add(b.peek());
  b.pop();
        }
        if(a.empty()){
       for(int j=0;j<num;j++)
       {
           a.push(x[j]);
       }
       num=0;
        }
        
    }    
while(!a.empty()){
        answer.add(a.peek());
        a.pop();
    
    }
    return answer;      
}


    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        String[] numberTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int numberItem = Integer.parseInt(numberTemp[i]);
            number.add(numberItem);
        }

        List<Integer> result = Result.waiter(number, q);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
