# include <iostream>
# include <cstring>
int main() {
    char animal[20] = "bear"; // 细节！ “bear” 整一个都是地址！他就是一个地址，但是它的名字就是“bear”。 这里的细节是， 你吧一个存储 bear字串内容的地址，赋给了一个叫 animal 的char数组！但是事实上，这个animal也是一个地址！
    const char* bird = "wren";
    char* ps;

    using namespace std;
    cout << animal << " and " << bird << endl;
    cout << "Please enter a kind of animal!" << endl;
    cin >> animal;

    ps = animal; // 注意这里，animal在我们之前的话，是认为这个只是一个字符串数组的名字！但是事实上它是这个字符串数组的地址，第一个字符的地址！所以这里是可以赋值的！
    cout << "ps=" << ps << endl;
    cout << "Before use strcy(): \n"; 
    cout << animal << " at " << (int*) animal << endl;  //强制改成一个int的原因是，让cout读的时候按照int读！ 这样的话后面就不会解释成一个字串了！打印的就是地址！
    cout << ps << " at " << (int*) ps << endl; //指针如果存在强制转型的话也是允许的！实际上在理解上也是可以理解的通的！看运行时怎么解释就是，只不过解释的不对是你自己要承担的！
    ps = new char[strlen(animal) + 1];

    strcpy(ps, animal);
    cout << "After use strcpy! " << endl;
    cout << animal << " at " << (int*) animal << endl;
    cout << ps << " at " << (int*) ps << endl;

    delete [] ps; //我靠！！！！这里特别容易出现问题啊，写一个这样的代码还得回头捋代码， 往回看这个 ps 是个啥指针我靠！
    // 所以到底有没有纯char的指针？？我感觉。这样写， 就默认没有纯char了，万一后面就是一个空字符的话，就是相当于字符串，而这种并不是我希望的！

    return 0;
}
