// merge 2 arrays then next two like that merge 2 2 arrays as we merge in merge sort 

import java.util.*;
class Main{
    static void mergeArrays(int a1[],int a2[],int n1,int n2,int[] op){

        int i=0,j=0,k=0;
        
        while(i<n1 && j<n2){
            if(a1[i]<a2[j]){
                op[k] = a1[i];
                i++;k++;
            }else{
                op[k] = a2[j];
                k++;j++;
            }
        }

        while(i<n1){
            op[k] = a1[i];
            i++;k++;
        }

        while(j<n2){
            op[k] = a2[j];
            k++;j++;
        }

    }
    static void mergeKArrays(int arr[][],int i,int j,int op[],int n){

        // if we are at the last row then simply add
        if(i==j){
            for(int p=0;p<n;p++){
                op[p] = arr[i][p];
            }
            return;
        }

        //if onlu two list are ther direct merge 
        if(j-i==1){
            mergeArrays(arr[i],arr[j],n,n,op);
            return;
        }

        int out1[] = new int[n*(((i+j)/2)-i+1)];
        int out2[] = new int[n*(j-((i+j)/2))];


        mergeKArrays(arr, i,(i+j)/2, op, n);
        mergeKArrays(arr, (i+j)/2+1, j, op, n);
        
        mergeArrays(out1,out2,n*(((i+j)/2)-i+1),n*(j-((i+j)/2)),op);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row : ");
        int n = sc.nextInt();
        System.out.println("Enter col : ");
        int k = sc.nextInt();

        int arr[][] = new int[n][k];

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int op[] = new int[n*k];
        mergeKArrays(arr,0,n-1,op,k);

        for(int i=0;i<n*k;i++){
            System.out.print(op[i]+" ");
        }
    }
}