package edu.neu.coe.huskySort.bst;

import edu.neu.coe.huskySort.bqs.Queue;
import edu.neu.coe.huskySort.bqs.Queue_Elements;
import edu.neu.coe.huskySort.util.PrivateMethodTester;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class BSTOriginalTest {

    @Test
    public void testSetRoot1() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "X", 42, 0);
        tester.invokePrivate("setRoot", node);
        System.out.println(bst);
    }

    @Test
    public void testSetRoot2() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node nodeX = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "X", 42, 0);
        BSTOriginal.Node nodeY = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "Y", 52, 0);
        BSTOriginal.Node nodeZ = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "Z", 99, 0);
        nodeY.left = nodeX;
        nodeY.right = nodeZ;
        tester.invokePrivate("setRoot", nodeY);
        System.out.println(bst);
    }

    @Test
    public void testSetRoot3() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        assertNull(bst.root);
    }

    @Test
    public void testSetRoot4() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "G", 31, 0);
        tester.invokePrivate("setRoot", node);
        assertEquals("G", bst.root.key);
        assertEquals(new Integer(31), bst.root.val);
        assertEquals(1, bst.root.size);
        assertNull(bst.root.right);
    }

    @Test
    public void testPut0() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        assertEquals(0, bst.size());
        bst.put("C", 13);
        assertEquals(1, bst.size());
    }

    @Test
    public void testPut1() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "42", 42, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("99", 99);
        BSTOriginal.Node root = (BSTOriginal.Node) tester.invokePrivate("getRoot");
        assertEquals("42", root.key);
        assertEquals("99", root.right.key);
        assertNull(bst.root.left);
        assertEquals(2, bst.size());
    }

    @Test
    public void testPut2() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "42", 42, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("99", 99);
        bst.put("37", 37);
        BSTOriginal.Node root = (BSTOriginal.Node) tester.invokePrivate("getRoot");
        assertEquals("42", root.key);
        assertEquals("37", root.left.key);
        assertEquals("99", root.right.key);
        assertEquals(3, bst.size());
    }

    @Test
    public void testPut3() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        bst.put("42", 42);
        BSTOriginal.Node root = (BSTOriginal.Node) tester.invokePrivate("getRoot");
        assertEquals("42", root.key);
        assertNull(root.left);
        assertNull(root.right);
        bst.put("21", 21);
        assertEquals("21", root.left.key);
        bst.put("37", 37);
        assertNull(root.left.left);
        assertEquals("37", root.left.right.key);
        System.out.println(bst.toString());
        assertEquals(3, bst.size());
    }

    @Test
    public void testDelete1() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "13", 13, 0);
        tester.invokePrivate("setRoot", node);
        bst.delete("13");
        assertNull(bst.root);
        assertEquals(0, bst.size());
    }

    @Test
    public void testDelete2() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "43", 43, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("13", 13);
        bst.delete("13");
        assertNull(bst.root.left);
        assertNull(bst.root.right);
        assertEquals(1, bst.size());
    }

    @Test
    public void testDelete3() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "43", 43, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("77", 13);
        bst.delete("77");
        assertNull(bst.root.left);
        assertNull(bst.root.right);
        assertEquals(1, bst.size());
    }

    @Test
    public void testDelete4() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "33", 42, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("32", 57);
        bst.delete("12");
        assertEquals(2, bst.size());
    }

    @Test
    public void testDelete5() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "35", 35, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("32", 32);
        bst.put("43", 43);
        bst.delete("35");
        assertEquals(2, bst.size());
        assertEquals( new Integer(43), bst.root.val);
        assertEquals("32", bst.root.left.key);
    }

    @Test
    public void testDelete6() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node node = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "35", 35, 0);
        tester.invokePrivate("setRoot", node);
        bst.put("32", 32);
        bst.put("43", 43);
        bst.deleteLeft("35");
        assertEquals(2, bst.size());
        assertEquals( new Integer(32), bst.root.val);
        assertEquals("43", bst.root.right.key);
        assertNull(bst.root.left);
    }

    @Test
    public void testSize1() {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        for (int i = 0; i < 100; i++) bst.put(Integer.toString(i), i);
        assertEquals(100, bst.size());
    }

    @Test
    public void testSize2() {
        Random random = new Random(0L);
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        for (int i = 0; i < 100; i++) bst.put(Integer.toString(random.nextInt(200)), i);
        assertEquals(79, bst.size());
    }

    @Test
    public void testDepthKey1() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        PrivateMethodTester tester = new PrivateMethodTester(bst);
        Class[] classes = {Comparable.class, Object.class, int.class};
        BSTOriginal.Node nodeX = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "X", 42, 0);
        BSTOriginal.Node nodeY = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "Y", 52, 0);
        BSTOriginal.Node nodeZ = (BSTOriginal.Node) tester.invokePrivateExplicit("makeNode", classes, "Z", 99, 0);
        nodeY.left = nodeX;
        nodeY.right = nodeZ;
        tester.invokePrivate("setRoot", nodeY);
        assertEquals("Y", bst.root.key);
        assertEquals( "X", bst.root.left.key);
        assertEquals("Z", bst.root.right.key);
        assertEquals(1, bst.height());
        assertEquals(0, bst.height(nodeX));
        assertEquals(1, bst.height(nodeY));
        assertEquals(0, bst.height(nodeZ));
        nodeY = null;
        assertEquals(-1, bst.height(nodeY));
    }

    @Test
    public void testDepthKey2() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        bst.put("3", 3);
        bst.put("38", 5);
        bst.put("13", 8);
        assertEquals(2, bst.height(bst.root));
        assertEquals(1, bst.height(bst.root.right));
        assertEquals(0, bst.height(bst.root.right.left));
    }

    @Test
    public void testDepthKey3() throws Exception {
        BSTOriginal<String, Integer> bst = new BSTOriginal<>();
        bst.put("3", 3);
        bst.put("38", 5);
        bst.put("13", 8);
        assertEquals(2, bst.height());
    }







}
