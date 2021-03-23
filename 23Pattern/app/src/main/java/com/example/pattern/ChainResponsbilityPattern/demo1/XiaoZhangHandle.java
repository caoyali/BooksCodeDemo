package com.example.pattern.ChainResponsbilityPattern.demo1;

class XiaoZhangHandle extends BaseChainHandler{
    public XiaoZhangHandle(BaseChainHandler next) {
        super(next);
    }

    @Override
    void handle(int days) {
        System.out.println("校长批假！终止！");
    }
}
