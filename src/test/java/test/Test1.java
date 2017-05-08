package test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test1 {
	@Test
	public void test1(){
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("f");
		List<String> list2 = new ArrayList<String>();
		list2.add("a");
		list2.add("c");
		list2.add("e");
		System.out.println("before1: "+list1);
		System.out.println("before2: "+list2);
		
		for (int i = 0; i < list1.size(); i++) {
			for (String string : list2) {
				if(string.equals(list1.get(i))){
					list1.remove(i);
				}
			}
		}
		System.out.println("after1: "+list1);
		System.out.println("after2: "+list2);
		
	}
	
	@Test
	public void test2(){
		String[] arrs = new String[]{"a","b","c"};
		StringBuilder sb = new StringBuilder();
		for (String str : arrs) {
			sb.append(str+",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
