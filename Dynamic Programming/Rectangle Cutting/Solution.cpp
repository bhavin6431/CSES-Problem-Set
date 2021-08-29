#include <bits/stdc++.h>
#include <utility>
#include <math.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;
#define fastio() ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
 
template <typename T> 
using ordered_set = tree<T, null_type,less<T>, rb_tree_tag,tree_order_statistics_node_update>;
typedef long long ll;
typedef unsigned long long ull;
typedef long double lld;
typedef pair<int,int> pii;
#ifdef LOCAL_JUDGE
#define debug(x) cerr << #x <<" "; _print(x); cerr << endl;
#else
#define debug(x)
#endif
#define p(x) cout << x;
#define p_e(x) cout << x << endl;
#define p_s(x) cout << x << " ";
 
//fstream myfile("c:\\tmp\\in.txt", ios_base::in);
//myfile >> n;
//fstream mf("c:\\tmp\\out.txt", ios_base::out);
//mf << n;
 
void _print(ll t) {cerr << t;}
void _print(int t) {cerr << t;}
void _print(string t) {cerr << t;}
void _print(char t) {cerr << t;}
void _print(lld t) {cerr << t;}
void _print(double t) {cerr << t;}
void _print(ull t) {cerr << t;}
#define ff first
#define ss second
 
template <class T, class V> void _print(pair <T, V> p);
template <class T> void _print(vector <T> v);
template <class T> void _print(set <T> v);
template <class T, class V> void _print(map <T, V> v);
template <class T> void _print(multiset <T> v);
template <class T, class V> void _print(pair <T, V> p) {cerr << "{"; _print(p.ff); cerr << ","; _print(p.ss); cerr << "}";}
template <class T> void _print(vector <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(set <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(multiset <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T, class V> void _print(map <T, V> v) {cerr << "[ "; for (auto i : v) {_print(i); cerr << " ";} cerr << "]";}
#define loop(n) for(int i=0;i<n;i++)
#define loopr(n) for(int i=n-1;i>=0;--i)
#define loops(n, s) for(int i=s;i<n;i++)
#define loopi(n) for(int i=0;i<n;i++)
#define loopj(n) for(int j=0;j<n;j++)
#define loopjs(n, s) for(int j=s;j<n;j++)
#define read(a) cin >> a
    #define read_2(a,b) cin >> a >> b;
#define read_array(a, n) loop(n) {cin >> a[i];}
#define read_arrays(a, n, s) loops(n, s) {cin >> a[i];}
#define p_m(m, r, c) p_s(" ")loopi(c){p_s(i)}; p_e(" "); loopi(r) { p_s(i);loopj(c) {p(m[i][j]); p(" ");} p_e("");}
#define map_insert(m, a, b) m.insert({a,b})
#define map_erase(m, a) m.erase(a)
#define loopm(map) for(auto it = map.begin(); it != map.end();it++)
#define MOD 1000000007
#define INF 1e18
#define mp make_pair
#define pb push_back
const int MAXIN = 2e6;
int n,m;
int dp[505][505];
 
int main() {
 
    #ifdef LOCAL_JUDGE
    freopen("Error.txt", "w", stderr);
    #endif
    fastio();
    
    read(n);
    read(m);
    int n1 = max(n,m);
    if(n == m) {
        p(0);
    } else if(n * 2 == m || m * 2 == n) {
        p(1);
    } else {
        for(int i=1;i<=n1;i++) {
            for(int j=i + 1;j<=n1;j++) {
                if(j >= i) {
                    if(i == j) {
                        dp[i][j] = 0;
                        dp[j][i] = 0;
                    } else if(i * 2 == j || j * 2 == i) {
                        dp[i][j] = 1;
                        dp[j][i] = 1;
                    } else {
                        dp[i][j] = INT_MAX;
                        for(int k=1;k<j;k++) {
                            dp[i][j] = min(dp[i][j], 1 + dp[i][k] + dp[i][j - k]);
                        }
                        for(int k=1;k<i;k++) {
                            dp[i][j] = min(dp[i][j], 1 + dp[k][j] + dp[i - k][j]);                    
						}
						dp[j][i] = dp[i][j];
					}
                } else {
                    continue;
                }
            }
        }
        p(dp[n][m]);
    }
    return 0;
}         