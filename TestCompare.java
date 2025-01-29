import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCompare {
    @Test
    public void test1()
    {
        Person p = new Person("123", "Juan", "Dela", "Male", "Faculty", "12345", 63, 81);
        Person p1 = new Person("213", "Maria", "Ceciel", "Male", "Faculty", "12345", 63, 81);
        assertEquals(1, p.getLName().compareTo(p1.getLName()));
    }
    @Test
    public void test2()
    {
        Person p = new Person("123", "Juan", "Dela", "Male", "Faculty", "12345", 63, 81);
        Person p1 = new Person("123", "Juan", "Dela", "Female", "Faculty", "12345", 63, 81);
        assertEquals(0, p.getLName().compareTo(p1.getLName()));
    }
}
