import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question2Test {

    Question2 watch;

    @BeforeEach
    public void init() {
        watch = new Question2();
    }

    //A testsuite for edge coverage
    @Nested
    public class EdgeCoverageTest {
        @Nested
        public class NormalStateTest {
            @Test
            public void testTransitionTimeToDate() {
                watch.press('a');
                assertEquals("NORMAL,DATE", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
            }

            @Test
            public void testTransitionDateToTime() {
                watch.press('a');
                watch.press('a');
                assertEquals("NORMAL,TIME", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
            }

            @Test
            public void testTransitionNormalToUpdate() {
                watch.press('c');
                assertEquals("UPDATE,min", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());

            }

            @Test
            public void testTransitionNormalToAlarm() {
                watch.press('b');
                assertEquals("ALARM,Alarm", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());

            }

            @AfterEach
            public void cleanUp() {
                watch = null;
            }
        }

        @Nested
        //A testsuite for Update State
        public class UpdateStateTest {
            @Test
            public void minTomin() {
                watch.press('c');
                watch.press('b');
                assertEquals("UPDATE,min", watch.getState());
                assertEquals("0:1", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
            }

            @Test
            public void minToHourAndHourToHour() {
                watch.press('c');
                watch.press('a');
                assertEquals("UPDATE,hour", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
                watch.press('b');
                assertEquals("UPDATE,hour", watch.getState());
                assertEquals("1:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());

            }

            @Test
            public void hourToDayAndDayToDay() {
                watch.press('c');
                watch.press('a');
                watch.press('a');
                assertEquals("UPDATE,day", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
                watch.press('b');
                assertEquals("UPDATE,day", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-2", watch.getDate());

            }

            @Test
            public void dayToMonthAndMonthToMonth() {
                watch.press('c');
                watch.press('a');
                watch.press('a');
                watch.press('a');
                assertEquals("UPDATE,month", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
                watch.press('b');
                assertEquals("UPDATE,month", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-2-1", watch.getDate());
            }

            @Test
            public void monthToYearAndYearToYear() {
                watch.press('c');
                watch.press('a');
                watch.press('a');
                watch.press('a');
                watch.press('a');
                assertEquals("UPDATE,year", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
                watch.press('b');
                assertEquals("UPDATE,year", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2001-1-1", watch.getDate());
            }

            @Test
            public void yearToNormal() {
                watch.press('c');
                watch.press('a');
                watch.press('a');
                watch.press('a');
                watch.press('a');
                watch.press('a');
                assertEquals("NORMAL,TIME", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
            }

            @AfterEach
            public void cleanUp() {
                watch = null;
            }
        }

        @Nested
        //A testSuite for Alarm State
        public class AlarmStateTest {
            @Test
            public void alarmToChimeAndChimeToNormal() {
                watch.press('b');
                watch.press('a');
                assertEquals("ALARM,Chime", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
                watch.press('d');
                assertEquals("NORMAL,TIME", watch.getState());
                assertEquals("0:0", watch.getTime());
                assertEquals("2000-1-1", watch.getDate());
            }

            @AfterEach
            public void cleanUp() {
                watch = null;
            }


        }
    }

    @Nested
    public class ADUPTest {
        @Test
        public void ADUP1() {
            watch.press('c');
            assertEquals("UPDATE,min", watch.getState());
            assertEquals("0:0", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());
        }

        @Test
        public void ADUP2() {
            watch.press('c');
            watch.press('b');
            assertEquals("UPDATE,min", watch.getState());
            assertEquals("0:1", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());

        }

        @Test
        public void ADUP3() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            assertEquals("UPDATE,min", watch.getState());
            assertEquals("0:2", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());

        }

        @Test
        public void ADUP4() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            assertEquals("UPDATE,hour", watch.getState());
            assertEquals("0:2", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());

        }

        @Test
        public void ADUP5() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            assertEquals("UPDATE,hour", watch.getState());
            assertEquals("1:2", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());

        }

        @Test
        public void ADUP6() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            assertEquals("UPDATE,hour", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());
        }

        @Test
        public void ADUP7() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            assertEquals("UPDATE,day", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-1-1", watch.getDate());
        }

        @Test
        public void ADUP8() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            assertEquals("UPDATE,day", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-1-2", watch.getDate());
        }

        @Test
        public void ADUP9() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            assertEquals("UPDATE,day", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-1-3", watch.getDate());
        }

        @Test
        public void ADUP10() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            assertEquals("UPDATE,month", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-1-3", watch.getDate());
        }

        @Test
        public void ADUP11() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            assertEquals("UPDATE,month", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-2-3", watch.getDate());
        }

        @Test
        public void ADUP12() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            assertEquals("UPDATE,month", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-3-3", watch.getDate());
        }

        @Test
        public void ADUP13() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            assertEquals("UPDATE,year", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2000-3-3", watch.getDate());
        }

        @Test
        public void ADUP14() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            assertEquals("UPDATE,year", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2001-3-3", watch.getDate());
        }

        @Test
        public void ADUP15() {
            watch.press('c');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            watch.press('a');
            watch.press('b');
            watch.press('b');
            assertEquals("UPDATE,year", watch.getState());
            assertEquals("2:2", watch.getTime());
            assertEquals("2002-3-3", watch.getDate());
        }


        @AfterEach
        public void cleanUp() {
            watch = null;
        }
    }
}