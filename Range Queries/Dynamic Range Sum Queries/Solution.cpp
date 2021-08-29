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
typedef long long int lli;
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
#define p_t_s(x, y) cout << x << " " << y;
#define p_t_s_e(x, y) cout << x << " " << y << endl;
 
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
#define loop(i, s, e) for(i=s;i<e;i++)
#define loopr(i, s, e) for(i=e;i>=s;i--)
#define read(a) cin >> a
#define read_2(a,b) cin >> a >> b;
#define read_array(a, n) loop(n) {cin >> a[i];}
#define read_vector_l(v, n) loop(i, 0, n) { ll val; cin >> val; v.pb(val);};
#define read_vector_i(v, n) loop(i, 0, n) { int val; cin >> val; v.pb(val);};
#define read_arrays(a, n, s) loops(n, s) {cin >> a[i];}
#define p_m(m, r, c) loopi(r) { loopj(c) {p(m[i][j]); p(" ");} p_e("");}
#define p_a(m, n) loopi(n)  {p(m[i]); p(" ");}
#define map_insert(m, a, b) m.insert({a,b})
#define map_erase(m, a) m.erase(a)
#define loopm(map) for(auto it = map.begin(); it != map.end();it++)
#define MOD 1000000007
#define INF 1e18
#define mp make_pair
#define pb push_back
const int MAXIN = 2e6;
int n,q,i,t;
 
const int N = 200001;
lli v[N];
lli st[4*N];
 
ll create(lli *v, lli *st, lli ss, lli es, lli si) {
    if(ss == es) {
        st[si] = v[ss];
        return v[ss];
    }
    lli mid = ss + ((es - ss) / 2);
    st[si] = create(v, st, ss, mid, (2 * si) + 1) + create(v, st, mid + 1, es, (2*si) + 2);
    return st[si];
}
 
ll getSum(lli *st, lli ss, lli es, lli sr, lli er, lli si) {
    if(er < ss || sr > es) {
        return 0;
    }
 
    if(sr <= ss && er >= es) {
        return st[si];
    }
    lli mid = ss + (es - ss) / 2;
    return getSum(st, ss, mid, sr, er, (si * 2)+ 1) + getSum(st, mid + 1, es, sr, er, (si * 2) + 2);
}
 
void update(lli *st, lli ss, lli es, lli i, lli diff, lli si) {
    if(i <ss || i > es) {
        return;
    }
    st[si]+=diff;
    if(es != ss) {
        lli mid = ss + ((es - ss)/ 2);
        update(st, ss, mid, i, diff, (si * 2) + 1);
        update(st, mid + 1, es, i, diff, (si * 2) + 2);
    }
}
 
void updateValue(lli *v, lli *st, lli i, lli new_val, lli n) {
 
    lli diff = new_val - v[i];
    v[i] = new_val;
    update(st, 0, n - 1, i, diff, 0);
}
 
 
int main() {
 
    #ifdef LOCAL_JUDGE
    freopen("Error.txt", "w", stderr);
    #endif
    fastio();
    read(n);
    read(q);
    for(int i=0;i<n;i++) {
        cin >> v[i];
    
    }   
    create(v, st, 0, n - 1, 0);
    lli u, k, a, b;
    while(q--) {
        cin >> t;
        if(t == 1) {
            cin >> k;
            cin >> u;
            updateValue(v, st, k - 1, u,n);
        } else {            
            cin >> a;
            cin >> b;
            ll ans = getSum(st, 0, n - 1, a-1, b-1, 0);
            p_e(ans);
        }
    }
    return 0;
} 