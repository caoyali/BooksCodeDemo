# include <iostream>
int main() {
    using namespace std;
    int updates = 6;
    int * p_updates; //地址的初始化，就是一个星，不用解释为什么这里会出现个星，死记硬背就成了
    p_updates = &updates;
    cout << " upsates = " << updates << " p_updates=" << p_updates << " *p_updates=" << * p_updates << endl; 
    *p_updates = *p_updates + 1;
    cout << "把地址内容取出，加了1之后看看：updates=" << updates << " *p_updates= " << *p_updates << endl;

    p_updates += 1;
    cout << "直接把地址值加了1之后看看：updates=" << updates << " *p_updates= " << *p_updates << endl;
    // *p_updates 指的就是，p_updates这个地址里面的那段内存，所存储的值！相当于反找！给地址看值。
    return 0;
}