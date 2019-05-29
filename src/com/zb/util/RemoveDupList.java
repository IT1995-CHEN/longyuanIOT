package com.zb.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RemoveDupList {

	public List<String> removeDupString(List<String> nameList){
	Set set = new HashSet();
    List newList = new ArrayList();
     for (Iterator iter = nameList.iterator(); iter.hasNext();) {
         Object element = iter.next();
         if (set.add(element))
             newList.add(element);
     }
     nameList.clear();
     nameList.addAll(newList);
     System.out.println(" remove duplicate " + nameList);
     return nameList;
	}
	
	public List<Integer> removeDupInteger(List<Integer> countList){
		Set set = new HashSet();
	    List newList = new ArrayList();
	     for (Iterator iter = countList.iterator(); iter.hasNext();) {
	         Object element = iter.next();
	         if (set.add(element))
	             newList.add(element);
	     }
	     countList.clear();
	     countList.addAll(newList);
	     System.out.println(" remove duplicate " + countList);
	     return countList;
		}
}
