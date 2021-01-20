package com.example.pattern.FlyweightPattern.demo2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FlyweightFactroy {
    private Map<Character, Flyweight> map = new HashMap<>();

    public Flyweight factory(List<Character> compositeFlyState) {
        // concreteCompositeFlyweight 这家伙不用存？越来越离谱啊
        ConcreteCompositeFlyweight concreteCompositeFlyweight = new ConcreteCompositeFlyweight();
        for (Character character : compositeFlyState) {
            ConcreteFlyweight concreteFlyweight = new ConcreteFlyweight(character);
            concreteCompositeFlyweight.add(character, concreteFlyweight);
        }

        return concreteCompositeFlyweight;
    }

    /**
     * 说实话我真的想不到这种要什么时候用，state这种东西，flyweight本身持有一份， 还要外部存一份？感觉好别扭啊！
     * @param state
     * @return
     */
    public Flyweight factroy(Character state) {
        if (map.containsKey(state)) {
            return map.get(state);
        } else {
            ConcreteFlyweight flyweight = new ConcreteFlyweight(state);
            map.put(state, flyweight);
            return flyweight;
        }
    }

}
