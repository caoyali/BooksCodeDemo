package com.example.pattern.ChainResponsbilityPattern.demo1;

class BanZhuRenHandler extends BaseChainHandler{
    public BanZhuRenHandler(BaseChainHandler next) {
        super(next);
    }

    @Override
    void handle(int days) {
        if (days <= 3) {
            System.out.println("班主任批假！");
        } else {
            if (null != next) {
                next.handle(days);
            } else {
                System.out.println("班主任找不到更高权限的人了！！终止！");
            }
        }
    }
}
