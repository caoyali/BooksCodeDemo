package com.example.pattern.BuilderPattern.Demo1;

/**
 * @author caoyali
 * 建造者模式的范例，说实话，我直至写完都没有感觉到这样写的原因。或许是没有碰到过需要它的场景吧
 */
public class BuildPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.println("Total cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
        System.out.println("Total cost: " + nonVegMeal.getCost());
    }
}
