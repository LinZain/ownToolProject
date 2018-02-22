package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "111");
        map.put(2, "222");
        map.put(3, "333");
        map.put(4, "444");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(5, "555");
        map2.put(6, "666");
        map2.put(7, "777");
        map2.put(8, "444");
        mapTest(map, map2);
        System.out.println("map1 " + map);
        System.out.println("map2 " + map2);
    }

    public static void mapTest(Map<Integer, String> map, Map<Integer, String> map2) {

        for (Integer key : map.keySet()) {
            String s = map2.get(key);
            if (null == s) {
                System.out.println("≤ª∆•≈‰,map1 key=" + key);
                continue;
            }
            System.out.println("map1 value=" + map.get(key) + " map2 value=" + s);
            map.remove(key);
            map2.remove(key);
            System.out.println("return1");
            return;
        }
        System.out.println("return2");
        return;
    }
}
