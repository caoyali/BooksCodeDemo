package com.example.typeinfo.pets;

import androidx.annotation.NonNull;

import com.example.util.print.Print;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 纸质书 329页
 * Class.isInstance 方法提供了一种动态测试对象的突降
 */
public class PetCount3 {
//     static class PetCount extends LinkedHashMap<Class <? extends Pet>, Integer> {
//         public PetCount() {
//             super(MapData.map(LetterPetCreator.allTypes, 0));
//         }
//
//         public void count(Pet pet) {
//             for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
//                 /**
//                  * 重点，就是考察一个对象是不是class对应的类。但是个人感觉计算的次数蛮多的！
//                  */
//                 if (entry.getKey().isInstance(pet)) {
//                     put(entry.getKey(), entry.getValue() + 1);
//                 }
//             }
//         }
//
//         @NonNull
//         @Override
//         public String toString() {
//             StringBuilder stringBuilder = new StringBuilder();
//             for (Map.Entry<Class <? extends Pet>, Integer> entry : entrySet()) {
//                 stringBuilder.append(entry.getKey().getSimpleName())
//                         .append("=")
//                         .append(entry.getValue())
//                         .append(", ");
//                 return stringBuilder.toString();
//             }
//             return super.toString();
//         }
//     }
//
//    public static void main(String[] args) {
//        PetCount PetCount = new PetCount();
//        for (Pet pet : Pets.createArray(20)) {
//            Print.print(pet.getClass().getSimpleName() + " ");
//            PetCount.count(pet);
//        }
//
//        Print.print(PetCount);
//    }
}
