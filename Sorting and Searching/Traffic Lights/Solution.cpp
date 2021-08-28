#include <bits/stdc++.h>
#include <utility>
using namespace std;
typedef long long ll;
#define loop(n) for(int i=0;i<n;i++)
#define loops(n, s) for(int i=s;i<n;i++)
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
#define v_pb(v,s) v.push_back(s)
#define m_i(m, a, b) m.insert({a,b})
#define m_e(m, a) m.erase(a)
#define loopm(map) for(auto it = map.begin(); it != map.end();it++)
#define p_ma(map) loopm(map) {p((*it).first);p(" - ");p_e((*it).second);}
#define r_e_m(map, key, value) {m_e(map, key); m_i(map, key, value);} 
 
typedef priority_queue<int> pq;
typedef pair<int, int> pi;
const int maxN = 2e5;
const int MOD = 1000000007;
 
int a[maxN], n, ans=0, x = 0;
 
int getOrDefault(map<int,int> map, int key, int d) {
    return map.count(key) > 0 ?  (*map.find(key)).second :  d;
}
 
int floorKey(map<int, int> input, int key)
{
    auto begin = input.begin();
    if (begin->first > key)//if key is less than the first key. It must retrun -1;
        return -1;
 
    auto end = input.end();
    end--;
    if (end->first < key)//if key is greater than last key, it must return last key
        return end->first;
 
    //if key is equal to any existing key, it should return the key
    auto find = input.find(key);
 
    if (find != input.end())
        return key;
 
    //Return the floor key for the given key
    auto lower = input.lower_bound(key);
 
    lower--;
    return lower->first;
}
 
int main() {
    
    r(x);
    r(n);
    
    r_a(a, n);
    
    
    set<int> s;
    map<int, int> gap;
    
    s.insert(x);
    s.insert(0);
    m_i(gap, x -0, 1);
    
    loop(n) {
        auto it = s.lower_bound(a[i]);
        int r = *it;
        --it;
        int l = *it;
        int m = a[i];
        --gap[r -l];
        if(!gap[r -l]) {
            m_e(gap, r-l);
        }
        s.insert(a[i]);
        ++gap[m - l];
        ++gap[r - m];
        
        p((--gap.end()) -> first);
        p(" ");
    }
    
}