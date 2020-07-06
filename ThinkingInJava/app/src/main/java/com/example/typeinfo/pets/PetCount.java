package com.example.typeinfo.pets;

import com.example.typeinfo.pets.Pet;
import com.example.typeinfo.pets.PetCreator;
import com.example.util.print.Print;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (null == quantity) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            Print.print(pet.getClass().getSimpleName());
            if (pet instanceof Pet) {
                petCounter.count("Pet");
            } //后面省略很多判断，实际上都要判断一遍，但是没有时间去搞这些没意义的。
        }
    }
}
