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
#define p_m(m, r, c) loopi(r) { loopj(c) {p(m[i][j]); p(" ");} p_e("");}
#define map_insert(m, a, b) m.insert({a,b})
#define map_erase(m, a) m.erase(a)
#define loopm(map) for(auto it = map.begin(); it != map.end();it++)
#define MOD 1000000007
#define INF 1e18
#define ff first
#define ss second
#define mp make_pair
const int MAXIN = 2e6;
int n,m, le, ri;
int dp[MAXIN];
 
 
int x[4] = {0, 0, 1, -1};
int y[4] = {1, -1, 0, 0};
char d[4] = {'R', 'L', 'D', 'U'};
bool v[1010][1010];
char g[1010][1010];
char p[1010][1010];
 
bool isValid(int i, int j) {
    return i>=0 && i<n && j>=0 && j <m && !v[i][j];
}
 
int main() {
 
    #ifdef LOCAL_JUDGE
    freopen("Error.txt", "w", stderr);
    #endif
    fastio();
    read_2(n, m);
    debug(n);
    debug(m);
    int si,sj, ei, ej;
    queue<pair<int,int>> q;
    loop(n) {
      loopj(m){
        cin >> g[i][j];
        if(g[i][j] == 'A') {
            si = i;
            sj = j;
            q.push({si,sj});
            v[i][j] = true;
        } else if(g[i][j] == 'B') {
            ei = i;
            ej = j;
        } else if(g[i][j] == '#') {
            v[i][j] = true;
        }       
    }
}
while(!q.empty()) {
    pii pr = q.front();
    q.pop();
    loop(4) {
        if(isValid(pr.first + x[i], pr.second + y[i])) {
            q.push({pr.first + x[i], pr.second + y[i]});
            p[pr.first + x[i]][pr.second + y[i]] = d[i];
            v[pr.first + x[i]][pr.second + y[i]] = true;
        }
    }
}
 
if(!v[ei][ej]) {
    p_e("NO");
} else {
    string ans;
    int len = 0; 
    int st = ei, en = ej;
    while(!(st == si && en == sj)) {
        ans += p[st][en];
        if(p[st][en] == 'D') {
            st = st - 1;
        } else if(p[st][en] == 'L') {
            en = en + 1;
        } else if(p[st][en] == 'R') {
            en = en - 1;
        } else {
            st = st + 1;
        }
    }
    p_e("YES");
    p_e(ans.length());
    debug(ans);
    loopr(ans.length()) {
        p(ans[i]);
    }
 }
 
}    