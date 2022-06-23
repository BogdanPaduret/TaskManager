package com.company.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    Set<String> add() //verifies exists, add and size methods
    {

        Set<String> stringSet = new Set<>();

        stringSet.add("Ana");
        stringSet.add("Maria");
        stringSet.add("Bogdan");

        assertEquals(3, stringSet.size());

        return stringSet;
    }


    @Test
    void showAll() {

        Set<String> stringSet = add();
        assertEquals(3,stringSet.size());

        String string = stringSet.showAll();

        assertEquals("Ana\nBogdan\nMaria\n",string);
    }

    @Test
    void getIndex() {

        Set<String> stringSet = add();
        int anaIndex = stringSet.getIndex("Ana");
        int bogdanIndex = stringSet.getIndex("Bogdan");
        int mariaIndex = stringSet.getIndex("Maria");
        int vladIndex = stringSet.getIndex("Vlad");

        assertEquals(0, anaIndex);
        assertEquals(1, bogdanIndex);
        assertEquals(2, mariaIndex);
        assertEquals(-1, vladIndex);

    }

    @Test
    void getData() {

        Set<String> stringSet = add();

        assertEquals("Ana", stringSet.getData(0));
        assertEquals("Bogdan", stringSet.getData(1));
        assertEquals("Maria", stringSet.getData(2));
        assertThrows(IndexOutOfBoundsException.class, () ->{
            stringSet.getData(3);
        });

    }

    @Test
    void set() {
        Set<String> stringSet = add();

        stringSet.set(1, "Ciolofan");
        assertEquals("Ciolofan", stringSet.getData(1));

        stringSet.set(1, "Zalmoxis");
        assertEquals("Maria", stringSet.getData(1));
        assertEquals("Zalmoxis", stringSet.getData(2));

    }

    @Test
    void setComparator() {
    }

    @Test
    void remove() {
        Set<String> stringSet = add();
        assertEquals(1, stringSet.getIndex("Bogdan"));

        stringSet.remove(1);
        assertEquals("Maria", stringSet.getData(1));
        assertEquals(-1, stringSet.getIndex("Bogdan"));
    }
}