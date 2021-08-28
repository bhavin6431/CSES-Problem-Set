#include <bits/stdc++.h>
#include <utility>
using namespace std;
typedef long long ll;
#define loop(n) for(int i=0;i<n;i++)
#define loopi(n) for(int i=0;i<n;i++)
#define loopj(n) for(int j=0;j<n;j++)
#define mx(a, b) a > b ? a : b
#define mn(a,b) a > b ? b : a
#define p(a) cout << a
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
typedef priority_queue<int> pq;
typedef pair<int, int> pi;
const int maxN = 2e5;
const int MOD = 1000000007;
int main() {
    int a[maxN], n, ans=0, b=0;
    r(n);
    r_a(a, n);
    map<int, int> m;
    loop(n) {
        if(m_c(m, a[i]) && m_v(m ,a) >= b) {
            b = m_v(m ,a) + 1;
        }
        ans = mx(ans, i - b +1);
        m[a[i]] = i;
    }
    p(ans);    
}