package com.example.pattern.ChainResponsbilityPattern.demo1;

class JiBuZhuRenHandler extends BaseChainHandler{
    public JiBuZhuRenHandler(BaseChainHandler next) {
        super(next);
    }

    @Override
    void handle(int days) {
        if (days < 5) {
            System.out.println("级部主任批假！");
        } else {
            if (null != next) {
                next.handle(days);
            } else {
                System.out.println("级部主任找不到更高权限的人了！ 终止！");
            }
        }
    }
}
