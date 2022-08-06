package edu.neu.coe.huskySort.sort.huskySortUtils;

import edu.neu.coe.huskySort.sort.Sorter;
import edu.neu.coe.huskySort.sort.radix.Alphabet;
import edu.neu.coe.huskySort.sort.radix.MSDStringSort;
import edu.neu.coe.huskySort.sort.radix.UnicodeMSDStringSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ChineseCharacterTest {

    @Test
    public void testEncode() {
        assertEquals(0x8A986E834000000L, new ChineseCharacter('卞').longCode);
        assertEquals(0x8A9834000000000L, new ChineseCharacter('毕').longCode);
    }

    @Test
    public void testAlt() {
        assertEquals("bian 4", new ChineseCharacter('卞').alt);
        assertEquals("bi 4", new ChineseCharacter('毕').alt);
    }

    @Test
    public void testCompare1() {
        final ChineseCharacter 鹿 = new ChineseCharacter('鹿'); // lu4
        final ChineseCharacter 绿 = new ChineseCharacter('绿'); // lu:4
        assertEquals(-1, 鹿.compareTo(绿));
    }

    @Test
    public void testConvertToPinyin() {
        final String 歐 = ChineseCharacter.convertToPinyin("一個大胖蘋果大胖子");
        //assertEquals("he 2xin 1yu 4", 何欣蔚);
        System.out.println(歐);
        //分割string
        String strArray[] = 歐.split(",");

        // Iterating over the string
        for (int i = 0; i < strArray.length; i++) {
            // Printing the elements of String array
            System.out.print(strArray[i] + ", ");
        }
        System.out.print("\n");
        //MSDStringSort
        final MSDStringSort msdStringSort = new MSDStringSort(new Alphabet(Alphabet.RADIX_UNICODE));
        final String[] strings = strArray;
        msdStringSort.sort(strings);
        //assertArrayEquals(new String[]{"毕", "卞"}, strings);
        for (int i = 0; i < strArray.length; i++) {
            // Printing the elements of String array
            System.out.print(strArray[i] + ", ");
        }

    }

    @Test
    public void testParsePinyin0() {
        final String[] strings = ChineseCharacter.parsePinyin("bo 1", 1);
        assertEquals(1, strings.length);
        assertEquals("b--o-1", strings[0]);
    }

    @Test
    public void testParsePinyin1() {
        final String[] strings = ChineseCharacter.parsePinyin("xin 1", 1);
        assertEquals(1, strings.length);
        assertEquals("x-i-n-1", strings[0]);
    }

    @Test
    public void testParsePinyin2() {
        final String name = "阿安";
        final String pinyin = ChineseCharacter.convertToPinyin(name);
        final String[] strings = ChineseCharacter.parsePinyin(pinyin, name.length());
        assertEquals(name.length(), strings.length);
        assertEquals("--a-1", strings[0]);
    }

    @Test
    public void testParsePinyin3() {
        final String[] strings = ChineseCharacter.parsePinyin("he 2xin 1yu 4", 3);
        assertEquals(3, strings.length);
        assertEquals("h--e-2", strings[0]);
        assertEquals("x-i-n-1", strings[1]);
        assertEquals("y-u--4", strings[2]);
    }

    @Test
    public void testParsePinyin4() {
        final String name = "阿冰";
        final String pinyin = ChineseCharacter.convertToPinyin(name);
        final String[] strings = ChineseCharacter.parsePinyin(pinyin, name.length());
        assertEquals(2, strings.length);
        assertEquals("--a-1", strings[0]);
        assertEquals("b-i-ng-1", strings[1]);
    }

    @Test
    public void testParsePinyin5() {
        final String name = "阿称";
        final String pinyin = ChineseCharacter.convertToPinyin(name);
        final String[] strings = ChineseCharacter.parsePinyin(pinyin, name.length());
        assertEquals(2, strings.length);
        assertEquals("--a-1", strings[0]);
        assertEquals("ch--eng-1", strings[1]);
    }

    @Test
    public void testParsePinyin6() {
        final String name = "阿晖";
        final String pinyin = ChineseCharacter.convertToPinyin(name);
        final String[] strings = ChineseCharacter.parsePinyin(pinyin, name.length());
        assertEquals(2, strings.length);
        assertEquals("--a-1", strings[0]);
        assertEquals("h-u-i-1", strings[1]);
    }

    @Test
    public void testParsePinyin7() {
        final String name = "艾绿";
        final String pinyin = ChineseCharacter.convertToPinyin(name);
        final String[] strings = ChineseCharacter.parsePinyin(pinyin, name.length());
        assertEquals(2, strings.length);
        assertEquals("--ai-4", strings[0]);
        assertEquals("l-ü--4", strings[1]);
    }
}