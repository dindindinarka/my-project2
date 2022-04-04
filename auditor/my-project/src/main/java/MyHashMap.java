
import java.sql.SQLOutput;
import java.util.*;

public class MyHashMap {


    private static MyHashMap myHashMap = new MyHashMap();
    private static int currentSize = 4;
    private static int newSize = currentSize * 2;
    private static ArrayList<Data> myMap = new ArrayList<>(currentSize);


    public static void main(String args[]) {

        myMap = myHashMap.create();

        myHashMap.put("test", "test");
        myHashMap.put("test1", "test2");
        myHashMap.put("test2", "test");
        myHashMap.put("test2", "test2");
        myHashMap.put("test2", "test");
        myHashMap.put("test2", "test2");

        Data data2 = new Data("test2", "test");
        System.out.println(myHashMap.get(data2));//проверка вхождения элемента

        System.out.println(myHashMap.getSize());//вычисление размера мапы

    }

    public ArrayList<Data> create() {
        myMap = new ArrayList(currentSize);
        for (int i = 0; i < currentSize; i++) myMap.add(new Data(null, null));
        return myMap;
    }

    public void put(String dataKey, String dataValue) {
        Data data1 = new Data(dataKey, dataValue);

        if ((myHashMap.getSize()) < currentSize * 0.8) {//если массив не заполнен на 80%
            int h = myHashMap.hashCode(data1) % currentSize / 4;
            if (myMap.get(h).dataKey == null) {
                myMap.set(h, data1);
            } else {
                for (int i = h; i < currentSize; i++) {
                    if (myMap.get(i).dataKey == null) {
                        myMap.set(i, data1);
                        break;
                    }
                }
            }
        } else {
            ArrayList<Data> newList = new ArrayList<>(newSize);//создаем новый массив
            for (int i = 0; i < newSize; i++) newList.add(new Data(null, null));//инициализируем значениямм
            for (int i = 0; i < myMap.size(); i++) {//переносим в него значения из старого массива
                newList.add(myMap.get(i));
            }
            myMap = newList;//переприсваиваем значение переменной
            int h = myHashMap.hashCode(data1) % newSize / 4;//вычисляем хэшкод
            if (myMap.get(h).dataKey == null) {//если ячейка с таким хешкодом пуста - заполняем
                myMap.set(h, data1);
            } else {//если ячейка с таким хешкодом занята - ищем ближайшую свободную
                for (int j = h; j < newSize; j++) {
                    if (myMap.get(j).dataKey == null) {
                        myMap.set(j, data1);
                        System.out.println(myMap.get(j).dataKey);
                        break;
                    }

                }
            }
        }
    }

    public boolean get(Data data) {
        boolean b = false;
        for (Data string : myMap) {
            if (string.dataKey != null) {
                if ((string.dateValue.equals(data.dateValue)) && (string.dataKey.equals(data.dataKey))) {
                    b = true;
                    break;
                } else b = false;
            }
        }
        return b;
    }

    public int getSize() {
        int size = 0;
        for (Data string : myMap) {
            if (string.dataKey != null) size++;
        }
        return size;
    }

    public int hashCode(Data data) {
        char[] ch = data.dataKey.toCharArray();
        int hashCode = 0;
        for (int i = 0; i < data.dataKey.length(); i++) {
            hashCode = hashCode + (int) (ch[i]) * i * ch.length;
        }
        return hashCode;
    }

}




