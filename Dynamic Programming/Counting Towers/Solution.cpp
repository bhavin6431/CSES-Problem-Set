#include <bits/stdc++.h>
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)
using namespace std;
 
long long dp[1000005][2];
 
int main()
{
    fast_io;
    int n, t;
    int mod = 1000000007;
    cin >> t;
    dp[0][0] = dp[0][1] = 1;
    for(int i=1;i<1000005;i++){
        long long op1 = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        long long op2 = dp[i-1][0];
        long long op3 = (2 * dp[i-1][0]) % mod;
        long long op4 = dp[i-1][1];
        
        dp[i][0] = (op1 + op2 + op3) % mod;
        dp[i][1] = (op1 + op4) %mod;
    }
 
    while(t--) {
    cin >> n;
    cout << ((dp[n- 1][0] + dp[n -1][1]) % mod) << endl;  
    }
}