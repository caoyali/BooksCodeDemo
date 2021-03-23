package com.example.pattern.ChainResponsbilityPattern.demo1;

class Demo {
    public static void main(String[] args) {
        BaseChainHandler xiaozhang = new XiaoZhangHandle(null);
        BaseChainHandler jibuZhuRen = new JiBuZhuRenHandler(xiaozhang);
        BaseChainHandler banzhuren = new BanZhuRenHandler(jibuZhuRen);
        banzhuren.handle(4);
    }
}
