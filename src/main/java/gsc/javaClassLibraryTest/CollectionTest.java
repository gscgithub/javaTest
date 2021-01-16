package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionTest {

    //只有hashMap可以放null值，TreeMap、Hashtable、ConcurrentHashMap不可以
    @Test
    public void mapNullTest() {
        Map map = new HashMap<>();
        map.put(null, "value is null");
        System.out.println("HashMap:" + map);

//        Map map2 = new TreeMap<>();
//        map2.put(null, "value is null");
//        System.out.println("HashMap:" + map2);

//        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put(null, "value is null");
//        System.out.println("hashtable:" + hashtable);

//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put(null, "value is null");
//        System.out.println("hashtable:" + concurrentHashMap);
    }

    @Test
    public void ArrayListTest() {
        List<Integer> asList = Arrays.asList(1,2,3);
//		asList.add(5);
//		ArrayList<Integer> arrayList = new ArrayList<Integer>(asList);
//		arrayList.add(5);
//		for (Integer integer : arrayList) {
//			System.out.println(integer);
//		}
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
//		for(int i=0;i<list.size();i++) {
//			if (list.get(i).equals("c")) {
//				list.remove(i);
//				i--;
//			}
//		}
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals("c")) {
                iterator.remove();
            }
        }
        for (String s : list) {
            System.out.println(s);
//		    if (s.equals("a"))
//		        list.remove(s);
        }
    }
}
