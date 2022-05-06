import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class maxandminTest {

    @Test
    void checkeq() {
        int[] numbers={1,2,3,4,5,6,7};
        assertArrayEquals(new int[]{1,7},maxandmin.checkeq(numbers));
    }
    @Test
    void checkeq1() {
        int[] numbers={1,1,2,3,4,5,6,7};
        assertArrayEquals(new int[]{1,7},maxandmin.checkeq(numbers));
    }
    @Test
    void checkeq2() {
        int[] numbers={7,7};
        assertArrayEquals(new int[]{7,7},maxandmin.checkeq(numbers));
    }
    @Test
    void checkeq3() {
        int[] numbers={7};
        assertArrayEquals(new int[]{7,7},maxandmin.checkeq(numbers));
    }
}