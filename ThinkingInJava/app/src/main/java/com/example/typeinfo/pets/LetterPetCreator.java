package com.example.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 纸质书326页采用字面量
 * 像Pet.class， 这样的可以称之为字面量。说实话我到现在都闹不清字面量的确切概念！
 */
public class LetterPetCreator extends PetCreator{

    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
            Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class
    ));

    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
