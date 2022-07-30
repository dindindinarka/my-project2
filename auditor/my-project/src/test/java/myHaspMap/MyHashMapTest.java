package myHaspMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {


    @Test
    @DisplayName("Проверка метода получения элемента")
    void checkGetElementInMyHashMap() {
        var myMap = createMyHaspMap();

        for (int i = 0; i < 7; i++) {
            var data = new Data("listNode" + i, "listNode" + i);
            myMap.put(data);
        }

        assertAll(
                () -> assertEquals("test2", myMap.get("test2").dateValue));

    }

    @Test
    @DisplayName("Проверка метода добавления элемента до заполнения на 80%")
    void checkPutElementInMyHashMap() {
        var myMap = createMyHaspMap();
        var data = new Data("test234", "test234");

        for (int i = 0; i < 24; i++) {
            var d = new Data("listNode" + i, "listNode" + i);
            myMap.put(d);
        }
        myMap.put(data);

        assertAll(
                () -> assertEquals("test234", myMap.get(data.dataKey).dataKey)
        );


    }

    @Test
    @DisplayName("Проверка метода добавления элемента после заполнения на 80%")
    void checkPutAfterPull80Percent() {
        var myHashMap = createMyHaspMap();
        var data1 = new Data("test234", "test234");
        var data2 = new Data("test235", "test238");
        var data3 = new Data("test236", "test239");

        for (int i = 0; i < 32; i++) {
            var d = new Data("listNode" + i, "listNode" + i);
            myHashMap.put(d);
        }
        assertAll(
                () -> assertEquals(32, myHashMap.getSize())
        );

        myHashMap.put(data1);
        myHashMap.put(data2);
        myHashMap.put(data3);

        for (int i = 0; i < 36; i++) {
            System.out.println(myHashMap.myMap.get(i).dataKey);
        }var d = myHashMap.get("test234");

       assertAll(
                () -> assertEquals(data1.dateValue, myHashMap.get(data1.dataKey).dateValue),
                () -> assertEquals(data2.dateValue, myHashMap.get(data2.dataKey).dateValue),
                () -> assertEquals(data3.dateValue, myHashMap.get(data3.dataKey).dateValue),
                () -> assertEquals(35, myHashMap.getSize())
        );

    }

    @Test
    @DisplayName("Проверка метода добавления элемента c тем же ключом и значением")
    void checkPutElementInMyHashMapWithCollision() {
        var myHashMap = createMyHaspMap();
        var data = new Data("test2", "test2");

        for (int i = 0; i < 24; i++) {
            var d = new Data("listNode" + i, "listNode" + i);
            myHashMap.put(d);
        }
        assertAll(
                () -> assertEquals("test2", myHashMap.get(data.dataKey).dateValue),
                () -> assertEquals(24, myHashMap.getSize())
        );

        myHashMap.put(data);

        assertAll(
                () -> assertEquals("test2", myHashMap.get(data.dataKey).dateValue),
                () -> assertEquals(25, myHashMap.getSize())
        );

    }

    //добавить тест на проверку , если в конец массива уже не влезаем

    public MyHashMap createMyHaspMap() {
        var myHashMap = new MyHashMap(32);
        //myHashMap.create(32);
        return myHashMap;
    }


    @Test
    @DisplayName("Проверка метода добавления элемента в конец списка с переносом в начало")
    void checkPutElementInMyHashMap2() {
        var myHashMap = createMyHaspMap();
        var data = new Data("test2097864", "test2");
        var data2 = new Data("test2", "test2");
        var data1 = new Data("656543fcgfcf33", "test2");

        for (int i = 0; i < 32; i++) {
            var d = new Data("listNode" + i, "listNode" + i);
            myHashMap.put(d);

        }
        myHashMap.put(data);
        myHashMap.put(data1);
        myHashMap.put(data2);
        myHashMap.put(data);

        assertAll(
                () -> assertEquals(data.dateValue, myHashMap.get(data.dataKey).dateValue),
                () -> assertEquals(36, myHashMap.getSize())
        );

    }

}