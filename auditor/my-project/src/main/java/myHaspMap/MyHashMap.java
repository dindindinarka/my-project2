package myHaspMap;

import profile.ProfileCustom;

import java.util.*;

@ProfileCustom
public class MyHashMap {

    int size;
    ArrayList<Data> myMap;

    private static int currentSize = 32;
    private static int newSize = currentSize * 2;


    public MyHashMap(int size) {
        this.size = size;
        this.myMap = new ArrayList<Data>(size);
        for (int i = 0; i < size; i++) myMap.add(new Data(null, null));
    }

   /* public static void main(String args[]) {


        //создание перенести в конструктор
        //должен принимать размер
      //  ArrayList myMap = myHashMap.create(currentSize);

        for (int i = 0; i < 7; i++) {
            var data = new Data("test" + i, "test" + i);
            myHashMap.put(data);
        }

        //Data data2 = new Data("test2", "test2");
        //myHashMap.put(data2);
        //System.out.println(myHashMap.get(data2));//проверка вхождения элемента

    }*/


    public int findIndexInArray(String key) {
        //проверить насколько хорошо хеш функция распределеят по массиву
        int h = hashCode(key) % currentSize;
        return h;
    }

    public void put(Data data) {
        if (getSize() < myMap.size() * 0.8) {
            var index = findIndexInArray(data.dataKey);
            System.out.println(data.dataKey + " вычислили индекс:" + index);
            tryAddElement(data, index);

        } else {
            var newM = myMap;
            var myHashMap = new MyHashMap(newSize);
            //не предусмотрено увеличение мапы больше, чем 1 раз!!!!
            for (Data d : newM) myHashMap.myMap.set(newM.indexOf(d), d);
            myMap = myHashMap.myMap;
            var index = findIndexInArray(data.dataKey);
            //System.out.println(data.dataKey + "вычислили индекс:" + index);
            tryAddElement(data, index);
        }
    }

    public Data get(String key) {
        var index = findIndexInArray(key);
        var d = myMap.get(index);
        if (d.dataKey.equals(key)) {
            return d;
        } else {
            for (Data data : myMap) {
                if ((data.dataKey != null) && (data.dataKey.equals(key))) return data;
            }
        }
        return null;
    }

    private int hashCode(String key) {
        char[] ch = key.toCharArray();
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode + (int) (ch[i]) * i * ch.length;
        }
        return hashCode;
    }

    public int getSize() {
        int size = 0;
        for (Data d : myMap) {
            if (d.dataKey != null) size++;
        }
        return size;
    }

    public void tryAddElement(Data data, int index) {
        try {
            if (myMap.get(index).dataKey == null) {
                myMap.set(index, data);
                System.out.println(data.dataKey + " индекс " + index + " вставился в " + index);
                return;
            }
            for (int j = index + 1; j < myMap.size(); j++) {
                if (j == myMap.size() - 1) {
                    tryAddElementInBeg(data, j);
                } else {
                    if (myMap.get(j).dataKey == null) {
                        myMap.set(j, data);
                        System.out.println(data.dataKey + " вставился в " + j);
                        break;

                    } else {
                        continue;
                    }
                }
            }
        } catch (
                IndexOutOfBoundsException indexOutOfBoundsException) {
        }
    }

    public void tryAddElementInBeg(Data data, int index) {
        for (int i = 0; i < index - 1; i++) {
            if (myMap.get(i).dataKey == null) {
                myMap.set(i, data);
                System.out.println(data.dataKey + " вставился в начало " + i);
                break;
            }
        }
    }
}


