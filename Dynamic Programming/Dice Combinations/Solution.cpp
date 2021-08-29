#include <bits/stdc++.h>
#include <utility>
#include <math.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update>
using namespace __gnu_pbds;
using namespace std;
typedef long long ll;
#define loop(n) for(int i=0;i<n;i++)
#define loopr(n) for(int i=n-1;i>=0;--i)
#define loops(n, s) for(int i=s;i<n;i++)
#define loopi(n) for(int i=0;i<n;i++)
#define loopj(n) for(int j=0;j<n;j++)
#define loopjs(n, s) for(int j=s;j<n;j++)
#define p(a) cout << a
#define p_s(a) cout << a << " ";
#define p_e(a) cout << a << endl;
#define r(a) cin >> a
#define r_a(a, n) loop(n) {cin >> a[i];}
#define p_a(a, n) loop(n) {cout <<  a[i] << " ";}
#define m_c(m, a) m.find(a) != m.end()
#define m_v(m ,a) (*m.find(a[i])).second
#define m_k(m ,a) (*m.find(a[i])).first
#define s_to(s) s.top()
#define s_pu(s, a) s.push(a)
#define s_po(s, a) s.pop(a)
#define s_a(a, n) loop(n) {int t = (int) rand() % n; swap(a[t], a[i]);}
#define p_m(m, r, c) loopi(r) { loopj(c) {p(m[i][j]); p(" ");} p_e("");}
#define v_pb(v,s) v.push_back(s)
#define m_i(m, a, b) m.insert({a,b})
#define m_e(m, a) m.erase(a)
#define loopm(map) for(auto it = map.begin(); it != map.end();it++)
#define p_ma(map) loopm(map) {p((*it).first);p(" - ");p_e((*it).second);}
#define pq_pu(pq, a) pq.push(a)
const int MOD = 1e9+7;
const int MaxIN = 1000005;
ll dp[MaxIN];
 
int n;
int main() {
   
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    r(n);
 
    //fstream myfile("c:\\tmp\\in.txt", ios_base::in);
    //myfile >> n;
    //fstream mf("c:\\tmp\\out.txt", ios_base::out);
    //mf << n;
    dp[0] = 0;
    loops(7, 1) {
        dp[i] = 1;
    }
    loops(MaxIN, 1) {
        loopjs(7, 1) {
            if(i - j > 0) {
                dp[i] += (dp[i - j] % MOD);
                dp[i] %= MOD;
            }    
        }
    }
    p(dp[n]);
}