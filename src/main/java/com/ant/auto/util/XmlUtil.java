package com.ant.auto.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author sekift
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class XmlUtil {
	 
	public static Map toMap(String xml) {
		
		ByteArrayInputStream sin = new ByteArrayInputStream(xml.getBytes());
		return toMap(sin);
	}
	
	public static Map toMap(InputStream in) {

		try {			
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			return toMap(doc.getRootElement());
		} catch (Exception ex) {
			throw new RuntimeException("From xml to map object case exception", ex);
		} 
	}
	
	public static Map toMap(Element elem) {
		 
		if (null == elem) {
			throw new IllegalArgumentException("Unavailable XML Element Object, can not null");
		}
		List<Element> elems = elem.elements();
		Map tar = new LinkedHashMap();
		for (Element item : elems) {
			generateMap(tar, item);
		}
		return tar;
	}
	 
	private static Map generateMap(Map container, Element elem) {
		
		String name = elem.getName();
		Object obj = container.get(name);
		if (null != obj) {
			if (!(obj instanceof List)) {
				List<Object> newBean = new LinkedList<>();
				newBean.add(obj);
				container.put(name, newBean);
				generateMap(container, elem);
			} else { 
				List<Object> bean = (List<Object>)obj;
				if (elem.isTextOnly()) {
					bean.add(elem.getStringValue());
				} else {
					List<Element> subs = elem.elements();
					Map nodes = new LinkedHashMap();
					bean.add(nodes);
					for (Element item : subs) {
						generateMap(nodes, item);
					}
				}
			}
			return container;
		}
		
		if (elem.isTextOnly()) {
			container.put(name, elem.getStringValue());
		} else { 
			List<Element> subs = elem.elements();
			Map nodes = new LinkedHashMap();
			container.put(name, nodes);
			for (Element item : subs) {
				generateMap(nodes, item);
			} 
		} 
		return container;
	}
	
	@Deprecated
	public static String getXml(List rowList){
		if(rowList == null || rowList.isEmpty()){
			return getEmptyXml(); 
		}
		StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?><dataset>");
		for (Object o : rowList) {
			result.append("<row>");
			Map map = (Map) o;
			Set<Map.Entry> entrys = map.entrySet();
			for (Map.Entry entry : entrys) {
				result.append("<").append(entry.getKey()).append("><![CDATA[").append(entry.getValue())
						.append("]]></").append(entry.getKey()).append(">");
			}
			result.append("</row>");
		}
		result.append("</dataset>");
		return result.toString();
	}
	
	@Deprecated
	public static String getEmptyXml(){
		return "<?xml version=\"1.0\" encoding=\"utf-8\" ?><dataset></dataset>";
	}	

	@Deprecated
	public static String getErrorXml(String errorMsg){
		String result = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><error_msg><![CDATA[" +
				errorMsg +
				"]]></error_msg>";
		return result;
	}
	
	@Deprecated
	public static String getErrorXml(String errorMsg,Exception ex){
		StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?><error_msg><![CDATA[");
        try {
            StringWriter sw = new StringWriter();  
            ex.printStackTrace(new PrintWriter(sw));  
            result.append(errorMsg);
            result.append(sw.toString());
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.append("]]></error_msg>");
		return result.toString();
	}	
	
	@Deprecated
    public static void orderBy(List rowList, String fieldSortBy, Class fieldClassType, boolean inc){
    	if(rowList == null || rowList.isEmpty()){
    		return;
    	}
		Comparator comp;
		if(fieldClassType == int.class || fieldClassType == Integer.class){
			comp = new ElementIntComparator(fieldSortBy, inc);
		} else {
			comp = new ElementStringComparator(fieldSortBy, inc);
		}
		rowList.sort(comp);
    }	
	
	@Deprecated
    private static class ElementIntComparator implements Comparator {
    	private String fieldName;
    	private boolean inc;
    	
    	public ElementIntComparator(String fieldName, boolean inc){
    		this.fieldName = fieldName;
    		this.inc = inc;
    	}

    	@Override
		public int compare(Object o1, Object o2) {
    		String f1 = (String)((Map)o1).get(fieldName);
    		String f2 = (String)((Map)o2).get(fieldName);
    		int if1 = 0;
    		int if2 = 0;
    		try{
    			if1 = Integer.parseInt(f1);
    		}catch(NumberFormatException e){
    			return -1;
    		}
    		try{
    			if2 = Integer.parseInt(f2);
    		}catch(NumberFormatException e){	
    			return 1;
    		}
    		int result = if1 - if2;
    		if(!inc){
    			result = -result;
    		}
    		return result;
    	}
    	
    }
    
	@Deprecated
    private static class ElementStringComparator implements Comparator {
    	private String fieldName;
    	private boolean inc;
    	
    	public ElementStringComparator(String fieldName, boolean inc){
    		this.fieldName = fieldName;
    		this.inc = inc;
    	}

    	@Override
		public int compare(Object o1, Object o2) {
    		String f1 = (String)((Map)o1).get(fieldName);
    		String f2 = (String)((Map)o2).get(fieldName);
    		int result = f1.compareToIgnoreCase(f2);
    		if(!inc){
    			result = -result;
    		}
    		return result;
    	}
    	
    }	
}
