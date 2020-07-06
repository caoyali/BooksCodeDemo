package com.example.typeinfo.pets;

import com.example.typeinfo.pets.LetterPetCreator;
import com.example.typeinfo.pets.Pet;
import com.example.typeinfo.pets.PetCreator;

import java.util.ArrayList;

/**
 * 纸质书 328页！
 * PetCreator 的实现使用了一种模板设计模式。
 */
public class Pets {
    public static final PetCreator PET_CREATOR = new LetterPetCreator();
    public static Pet randomPet() {
        return PET_CREATOR.randomPet();
    }

    public static Pet[] createArray(int size) {
        return PET_CREATOR.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return PET_CREATOR.arrayList(size);
    }
}
