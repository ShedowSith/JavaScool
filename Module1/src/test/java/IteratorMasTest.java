import homework_4.IteratorMas;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class IteratorMasTest {
    private Object[] objects;
    private IteratorMas iterator;
    @Before
    public void before(){
        objects = new Object[2];
        objects[0] = "1";
        objects[1] = "10";
        iterator = new IteratorMas(objects);

    }
    @After
    public void after(){
        objects = null;
        iterator = null;
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void iteratorTest(){
        assertEquals(true, iterator.hasNext());
        assertEquals("1", iterator.next().toString());
        assertEquals("10", iterator.next().toString());
        assertEquals(false, iterator.hasNext());
        iterator.next();//Должен выкинуть исключение
    }

}