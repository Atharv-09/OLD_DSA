import java.util.*;

class Solution {
    public int colorful(int A) {
        
        String s = Integer.toString(A);
        int len = s.length();

        ArrayList<String> ar = new ArrayList<>();

        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                
                String str= s.substring(i,j);
                ar.add(str);
            }
        }

        // for(int i=0;i<ar.size();i++){
        //     System.out.println(ar.get(i));
        // }

        Set<Integer> map = new HashSet<>();

        for(int i=0;i<ar.size();i++){

            String cur = ar.get(i);

            int num = Integer.parseInt(cur);

            String numLen = Integer.toString(num);

            if(numLen.length() > 1){
                // more then 2 dig

                int ans = 1;
                for(int m=0;m<numLen.length();m++){
                    ans = ans * ((int)numLen.charAt(m));
                }

                if(map.contains(ans)){
                    return 0;
                }else{
                    map.add(ans);
                }

            }else{
                
                if(map.contains(num)){
                    return 0;
                }else{
                    map.add(num);
                }
            }
        }

        Iterator<Integer> it = map.iterator();

        while(it.hasNext()){

            System.out.println(it.next());
        }
        return 1;

       

    }

    public static void main(String[] args) {
        
        int ans =new Solution().colorful(123);
        
        System.out.println(ans);
    }

}
