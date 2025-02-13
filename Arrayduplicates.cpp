
#include <bits/stdc++.h>
using namespace std;
vector<int> duplicates(int arr[], int n);
int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) cin >> a[i];
        vector<int> ans = duplicates(a, n);
        for (int i : ans) cout << i << ' ';
        cout << endl;
    }
    return 0;
}



vector<int> duplicates(int a[], int n) {
    // code here
        sort(a,a+n);

    vector<int> v1(a,a+n);
    vector<int> ans;
    bool found;
    
    for(int i=0;i<n-1;){
      if(v1[i] == v1[i+1] && !(find(ans.begin(),ans.end(),v1[i])!=ans.end())){
          ans.push_back(v1[i]);
          i+=2;
          found=true;
      }else{
          i++;
      }
    }
    
    if(found==true)
        return ans;
    else{
        ans.push_back(-1);
        return ans;
    }
     //   return -1;
    
    
    
}
