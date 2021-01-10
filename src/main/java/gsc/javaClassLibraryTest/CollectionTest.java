package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

    @Test
    public static void ArrayListTest() {
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
