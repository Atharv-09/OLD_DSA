
// n=4 ;
// 1 
// one time 1 = 11
// 2 time 1 = 21
// 1 time 2 n 1 time 1 = 1211

import java.io.*;
class CountNSay{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter n : ");
        int n = Integer.parseInt(br.readLine());

        
        String ans = "1";
        for(int i=0;i<n-1;i++){

            char ch = ans.charAt(0);
            StringBuilder sb = new StringBuilder();
            int count=1;
            
            for(int j=1;j<ans.length();j++){

                if(ch!=ans.charAt(j)){
                    sb.append(count);
                    sb.append(ch);
                    count=0;
                    ch = ans.charAt(j);
                }

                count++;
            }

            sb.append(count);
            sb.append(ch);

            ans = sb.toString();
        }

        System.out.println("CountAndSay String : "+ ans);   

    
    
    }
}