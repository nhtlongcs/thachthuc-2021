#include <iostream>
#include <string>
using namespace std;
int sum_length = 0;
string answer;
void print(unsigned long long sum)
{
    unsigned char x = 1;
    string s;
    for (int i = 0;i<8;++i)
    {
        x = (1 << 5) | (sum & ((unsigned char)0x1F));
        s = char(x) + s;
        sum = sum >> 5;
    }
    answer += s;

}
char x[] ="~`!@#$%^&*()_-+={[}]|\\'\":;?/>.<,";
int main(){
    srand (time(NULL));
    string message;

    while(1)
    {
    getline(cin,message);
    if (message=="0") break;
    unsigned int key;
    cin >> key;
    getchar();
    answer = "";
    unsigned long long sum = 0;
    for (int i = 0;i<message.length();++i)
    {
        unsigned char x = (unsigned char) message[i] ^ (unsigned char) key;
        sum = (sum << 8) | x;
        if ((i+1)%5==0)
        {
            print(sum);
            sum =0;
        }
    }

    for (int i = 0;i<answer.length();++i)
    {
        cout << answer[i];
    }
    cout << "\n";
    cout << "Key: " << key << "\n" << "Answer: " << message << "\n";
    }
    return 0;
}
