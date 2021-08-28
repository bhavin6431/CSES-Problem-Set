#include <bits/stdc++.h>
#include <utility>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update>
using namespace __gnu_pbds;
using namespace std;
typedef long long ll;
#define loop(n) for(int i=0;i<n;i++)
#define loops(n, s) for(int i=s;i<n;i++)
#define loopi(n) for(int i=0;i<n;i++)
#define loopj(n) for(int j=0;j<n;j++)
#define mx(a, b) a > b ? a : b
#define mn(a,b) a > b ? b : a
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
const int maxN = 2e5;
const int MOD = 1000000007;
bool a[maxN];
int n, ans=0, i, l, k, s;
 
int main() {
   
    r(n);
    r(k);
 
     ordered_set o_set;
     loops(n + 1 , 1) {
         o_set.insert(i);
     }    
 
     s = 0;
     while(o_set.size() > 0) {
         s = s % o_set.size();
         int r = (s + k) % o_set.size();
         auto it = o_set.find_by_order(r);
         p_s(*it);
         o_set.erase(it);
         s = r;
     }
}