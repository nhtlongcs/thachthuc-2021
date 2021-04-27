#include <pthread.h>
#include <iostream>
#include <string>
#include <vector>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <fstream>
#include <set>
#include <algorithm>

using namespace std;
vector<string> a;
set<int> f;

int second = 12000;
int state = 1;
int number = 1;

string showing_text ="-----";

void *myThreadFun(void *vargp)
{
    while(second)
    {
    cout << number << " : " << showing_text << "\n" << second/100 << "\n";
    usleep(10000);
    second--;
    cout << "\033[2J\033[1;1H";
    if (state==0) break;
    }
    return 0;
}

bool cmp(const string & a,const string & b)
{
    return a.length()<b.length();
}

int main()
{
    string s;
    srand(time(0));

    ifstream fin;
    fin.open("KeyWordsDB.txt",ios_base::in);

    while (getline(fin,s))
    {
        a.push_back(s);
    }

    int n = a.size();

    while(1)
    {
        second = 12000;
        state = 1;
        number = 1;
        vector<string> b;

        for (int i = 0;i<10;++i)
        {
            int idx = rand()%n;
            cout << idx << "\n";
            while(f.count(idx)==1)
            {

                idx = rand()%n;
            }
            f.insert(idx);
            b.push_back(a[idx]);
        }

        sort(b.begin(),b.end(),cmp);

        pthread_t thread_id;
        pthread_create(&thread_id, NULL, myThreadFun, NULL);  

        for (int i = 0;i<10;++i)
        {
            if (second==0) break;
            number = i+1;
            showing_text = b[i];
            getline(cin,s);
            if (second==0) break;
        }
        state = 0;
        pthread_join(thread_id, NULL);
        cout << "ENDING - Enter to continue.\n";
        
        getline(cin,s);
        getline(cin,s);
    }
    return 0;
}