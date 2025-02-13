import java.util.*;
class Main{
    static int row ;

    static void mergeIntoSingleArrayAndSort(int arr[][],int n,int k){
        int ans[] = new int[n*k];
        int ind = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                ans[ind] = arr[i][j];
                ind++;
            }
        }
    
        Arrays.sort(ans);

        for(int i=0;i<n*k;i++){
            System.out.print(ans[i]+" ");
        }
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter col : ");
        int k = sc.nextInt();
        System.out.println("Enter row : ");
        int n = sc.nextInt();
        
        row = n;
        int arr[][] = new int[n][k];

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j] = sc.nextInt();
            }
        }
 
        // time : nk lognk  space : nk
        mergeIntoSingleArrayAndSort(arr,n,k);
    }
}