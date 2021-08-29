/******************************************************************************
 
                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.
 
*******************************************************************************/
 
#include <iostream>
#include <stdio.h>
#include <string.h>
 
using namespace std;
 
 
int main()
{
    int n, m;
    int mod = 1000000007; 
 
    cin >> n;
    cin >> m;
    int dp[n+2][m+2];
    memset(dp, 0, sizeof dp);
    int v[n+1];
    for(int i=1;i<=n;i++){
        cin >> v[i];
    }
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(i == 1) {
                if(v[i] == 0 || v[i] == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                } 
            } else {
                if(v[i] == 0 || v[i] == j) {
                    dp[i][j] = ((dp[i-1][j] + dp[i-1][j - 1]) % mod + dp[i-1][j + 1]) % mod;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
    }
    
    
    int ans = 0;
    for(int i=1;i<=m;i++){
        ans = (ans + dp[n][i]) % mod;
    }
    cout << ans;
    
    return 0;
}