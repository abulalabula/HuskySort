package edu.neu.coe.huskySort.sort.huskySortUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

import edu.neu.coe.huskySort.sort.radix.MSDStringBPMFSort;

public class TestChinese {
	@Test
    public void testConvertToPinyin0() {
		final String Chinese = "拜办拜办我非此产品安排充满没快另起送皮肤妇女事拍赔丛偿兰桂坊从全面开放此";
    	final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
        List<String> list = new ArrayList<>();
        for(String s:tokens){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        System.out.println(list);
    }
	@Test
    public void testConvertToPinyin1() {
		final String Chinese = "拜办拜办我";
    	final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
        List<String> list = new ArrayList<>();
        for(String s:tokens){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        System.out.println(list);
    }
	
	@Test
    public void testConvertToPinyin2() {
		final String Chinese = "据俄新社援引扎波罗热核电站所在的埃涅尔戈达尔市官员的消息称乌克兰军队日凌晨使用飓风火箭炮对扎波罗热核电站进行了炮击炮击区域涉及乏燃料棒的储存设施区域和辐射情况自动监测站弹片落在了正在运行的发电机组附近距离不超过米";
    	final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
        List<String> list = new ArrayList<>();
        for(String s:tokens){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        System.out.println(list);
    }
}
