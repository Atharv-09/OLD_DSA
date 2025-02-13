#include<bits/stdc++.h>
using namespace std;
/*running using java hashset

 public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        
        int count=1;
        
        for(int i=0;i<nums.length;i++){
            if(hs.contains(count)){
                count++;
            }else{
                return count;
            }
        }
        return nums.length+1;
    }
*/
void missingNumber(int arr[], int n) { 

            // not runnig;
        sort(arr,arr+n,greater<int>());
        for(int i=0;i<n;i++){
            cout<<arr[i]<<"     ";
        }
        cout<<"\n";


        stack<int> s;
        int lastEle=arr[0];
        s.push(lastEle);

        for(int i=1;i<n;i++){
            if(lastEle!=arr[i])
                s.push(arr[i]);

            lastEle = arr[i];
        }
        
        int count=1;
        bool containZero=false;
        for(int i=0;i<n;i++){
            int t = s.top();
            if(t>0){
                if(count!=t){
                    cout<<count<<"\n";
                    break;
                }
                count++;
                s.pop();
            }else{
                containZero=true;
                s.pop();
            }
        }
        if(containZero==true) cout<<n<<"\n"; return;
        cout<<n+1<<"\n";
        return;
}
int main(){

    int n;
    cout<<"Enter size : ";
    cin>>n;

    int arr[n];
    cout<<"Enter arr : ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    missingNumber(arr,n);

    // cout<<ans<<"\n";

    return 0;
}