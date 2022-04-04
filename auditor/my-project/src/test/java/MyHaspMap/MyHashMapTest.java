package MyHaspMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {


    @Test
    @DisplayName("Проверка метода получения элемента")
    void checkGetElementInMyHashMap() {
        var myMap = createMyHaspMap();

        for (int i = 0; i < 7; i++) {
            var data = new Data("test" + i, "test" + i);
            myMap.put(data);
        }

        assertAll(
                () -> assertEquals(true, myMap.get(new Data("test2", "test2"))),
                () -> assertEquals(false, myMap.get(new Data("test22", "test2"))));

    }

    @Test
    @DisplayName("Проверка метода добавления элемента до заполнения на 80%")
    void checkPutElementInMyHashMap() {
        var myMap = createMyHaspMap();
        var data = new Data("test234", "test234");

        for (int i = 0; i < 24; i++) {
            var d = new Data("test" + i, "test" + i);
            myMap.put(d);
        }
        assertAll(
                () -> assertEquals(false, myMap.get(data)),
                () -> assertEquals(24, myMap.getSize()));


        myMap.put(data);

        assertAll(
                () -> assertEquals(true, myMap.get(new Data("test234", "test234"))),
                () -> assertEquals(25, myMap.getSize()));


    }

    @Test
    @DisplayName("Проверка метода добавления элемента после заполнения на 80%")
    void checkPutAfterPull80Percent() {
        var myMap = createMyHaspMap();
        var data1 = new Data("test234", "test234");
        var data2 = new Data("test235", "test234");
        var data3 = new Data("test236", "test234");

        for (int i = 0; i < 32; i++) {
            var d = new Data("test" + i, "test" + i);
            myMap.put(d);
        }

        assertAll(
                () -> assertEquals(false, myMap.get(new Data("test234", "test234"))),
                () -> assertEquals(32, myMap.getSize()));

        myMap.put(data1);
        myMap.put(data2);
        myMap.put(data3);

        assertAll(
                () -> assertEquals(true, myMap.get(data1)),
                () -> assertEquals(true, myMap.get(data2)),
                () -> assertEquals(true, myMap.get(data3)),
                () -> assertEquals(35, myMap.getSize()));

    }

    @Test
    @DisplayName("Проверка метода добавления элемента c тем же ключом и значением")
    void checkPutElementInMyHashMapWithCollision() {
        var myMap = createMyHaspMap();
        var data = new Data("test2", "test2");

        for (int i = 0; i < 24; i++) {
            var d = new Data("test" + i, "test" + i);
            myMap.put(d);
        }
        assertAll(
                () -> assertEquals(true, myMap.get(data)),
                () -> assertEquals(24, myMap.getSize()));


        myMap.put(data);

        assertAll(
                () -> assertEquals(true, myMap.get(data)),
                () -> assertEquals(25, myMap.getSize()));

    }

    public MyHashMap createMyHaspMap() {
        var myHashMap = new MyHashMap();
        myHashMap.create();
        return myHashMap;
    }
}