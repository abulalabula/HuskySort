package edu.neu.coe.huskySort.sort.huskySortUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

import edu.neu.coe.huskySort.sort.radix.MSDStringBPMFSort;

public class TestChinese {
	@Test
    public void testConvertToPinyin() {
		final String Chinese = "拜办拜办我非此产品安排充满没快另起送皮肤妇女事拍赔丛偿兰桂坊从全面开放此";
    	final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                //若已存在后面加一个a;
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
        List<String> list = new ArrayList<>();//store sorted Chinese
        for(String s:tokens){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);//print sorted array
        }
        System.out.println(list);
    }
}
