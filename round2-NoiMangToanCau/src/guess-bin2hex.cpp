#include <iostream>
#include <time.h>
using namespace std;
int main()
{
    srand(time(0));
    while (1)
    {
        unsigned short x = rand() % 16;
        char ans = 0;
        int n = 4;
        while (n)
        {
            n--;
            cout << ((x >> n) & 1);
        }
        cout << "\nAnswer:";
        cin >> ans;
        if (ans <= '9')
            ans -= '0';
        else
            ans = ans - 'A' + 10;
        while (ans != x)
        {
            cout << "Wrong\n";
            cin >> ans;
            if (ans <= '9')
                ans -= '0';
            else
                ans = ans - 'A' + 10;
        }
    }
    return 0;
}
