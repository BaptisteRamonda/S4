package tp2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileCirculaireTest {
    private FileCirculaire f1;
    private FileCirculaire f2;

    @BeforeEach
    void setUp() throws Exception {
        f1 = new FileCirculaire(5);
        f2 = new FileCirculaire(5);
    }

    @AfterEach
    void tearDown() throws Exception {
        f1 = null;
        f2 = null;
        System.gc();
    }

    @Test
    void testAdd() {
        f1.add(0);
        Assertions.assertEquals(0, f1.get(), "Error add");
        f1.add(1);
        Assertions.assertEquals(0, f1.get(), "Error add");
        f1.add(2);
        f1.add(3);
        Assertions.assertTrue(f1.add(4), "error add");
        Assertions.assertFalse(f1.add(5), "error add");
    }

    @Test
    void testRemove() {
        Assertions.assertFalse(f1.remove(), "error remove file vide");
        f1.add(0);
        Assertions.assertTrue(f1.remove(), "error remove");
        Assertions.assertEquals(0, f1.size(), "Error remove");
        f1.add(0);
        f1.add(1);
        f1.remove();
        Assertions.assertEquals(1, f1.size(), "Error remove");
        Assertions.assertEquals(1, f1.get(), "Error remove");
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(f1.isEmpty(), "Error isEmpty");
        f1.add(0);
        Assertions.assertFalse(f1.isEmpty(), "Error isEmpty");
        f1.remove();
        Assertions.assertTrue(f1.isEmpty(), "Error isEmpty");
    }

    @Test
    void testSize() {
        Assertions.assertEquals(0, f1.size(), "Error size");
        f1.add(0);
        Assertions.assertEquals(1, f1.size(), "Error size");
        f1.add(1);
        Assertions.assertEquals(2, f1.size(), "Error size");
        f1.remove();
        Assertions.assertEquals(1, f1.size(), "Error size");
        f1.remove();
        Assertions.assertEquals(0, f1.size(), "Error size");
    }

    @Test
    void testGet() {
        try {
            f1.get();
            Assertions.fail("Error get, no assertion with an empty queue");
        } catch (AssertionError ignored) {
        }
        f1.add(0);
        Assertions.assertEquals(0.0, f1.get(), "Error get");
        f1.add(1);
        Assertions.assertEquals(0.0, f1.get(), "Error get");
        f1.remove();
        Assertions.assertEquals(1.0, f1.get(), "Error get");
        f1.add(0);
        Assertions.assertEquals(1.0, f1.get(), "Error get");
    }

    @Test
    void testIsFull() {
        Assertions.assertFalse(f1.isFull(), "Error isFull");
        f1.add(1.0);
        Assertions.assertFalse(f1.isFull(), "Error isFull");
        double i = 2.0;
        while (!f1.isFull())
            f1.add(i);
        Assertions.assertTrue(f1.isFull(), "Error isFull");
    }

    @Test
    void testCapacity() {
        Assertions.assertEquals(f1.capacity(), 5);
    }

    @Test
    void testToString() {
        Assertions.assertTrue(f1.toString().equals("[]"), "Error toString");
        f1.add(0);
        Assertions.assertTrue(f1.toString().equals("[0.0]"), "Error toString");
        f1.add(1);
        Assertions.assertTrue(f1.toString().equals("[0.0, 1.0]"), "Error toString");
        f1.remove();
        Assertions.assertTrue(f1.toString().equals("[1.0]"), "Error toString");
        f1.remove();
        Assertions.assertTrue(f1.toString().equals("[]"), "Error toString");
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void testEqualsObject() {
        Assertions.assertFalse(f1.equals(null), "Error equals");
        Assertions.assertFalse(f1.equals("hello"), "Error equals");
        Assertions.assertTrue(f1.equals(f2), "Error equals");
        f1.add(0);
        Assertions.assertFalse(f1.equals(f2), "Error equals");
        f1.add(1);
        f2.add(0);
        f2.add(1);
        Assertions.assertTrue(f1.equals(f2), "Error equals");
        f1.remove();
        f2.remove();
        Assertions.assertTrue(f1.equals(f2), "Error equals");
    }

}