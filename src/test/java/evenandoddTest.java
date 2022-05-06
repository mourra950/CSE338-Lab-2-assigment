import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class evenandoddTest {

    @Test
    void checkeq() {
        int number=20;
        assertTrue(evenandodd.checkeqifeven(number));
    }
    @Test
    void checkeq1() {
        int number=-20;
        assertTrue(evenandodd.checkeqifeven(number));
    }
    @Test
    void checkeq2() {
        int number=21;
        assertFalse(evenandodd.checkeqifeven(number));
    }
    @Test
    void checkeq3() {
        int number=-21;
        assertFalse(evenandodd.checkeqifeven(number));
    }
    @Test
    void checkeq4() {
        int number=0;
        assertTrue(evenandodd.checkeqifeven(number));
    }
}