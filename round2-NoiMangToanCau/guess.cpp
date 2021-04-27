#include <bits/stdc++.h>

using namespace std;

char hexa(int n) {
    if (0 <= n && n <= 9) return n + '0';
    else return n - 10 + 'A';
}

int main() {
    srand(time(NULL));
    int cnt = 0;
    clock_t start, ed;
    while (true) {
        string s;
        if (cnt % 30 == 0) {
            cout << "Enter any key to start"; getline(cin, s);
            start = clock();
        }
        cout << "------------------------Count: " << (cnt++) % 30 << "---------------" <<'\n';
        int x = rand() % 6 + 2;
        int y = rand() % 16; if (x == 7 && y == 15) --y;
        cout << "Hexa: " << hexa(x) << hexa(y) << '\n';
        cout << "Guess : "; getline(cin, s);
        if ((int)s[0] == x * 16 + y) cout << "Correct !\n";
        else cout << "Wrong Answer :( True answer is: " << char(x * 16 + y) << '\n';
        cout << '\n';
        if (cnt % 30 == 0) {
            ed = clock();
            cout << "Finish 30 tokens in " << double(ed - start) / CLOCKS_PER_SEC << " seconds\n";
        }
    }
    return 0;
}
