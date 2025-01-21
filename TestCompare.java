import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCompare {
    @Test
    public void test1()
    {
        Person p = new Person("123", "Juan", "Dela", "Male", "Faculty", "12345", 63, 81);
        Person p1 = new Person("213", "Maria", "Ceciel", "Male", "Faculty", "12345", 63, 81);
        assertEquals(p.getLName().compareTo(p1.getLName()), 1);
    }
    public void test2()
    {
        Person p = new Person("123", "Juan", "Dela", "Male", "Faculty", "12345", 63, 81);
        Person p1 = new Person("123", "Juan", "Dela", "Female", "Faculty", "12345", 63, 81);
        assertEquals(p.getLName().compareTo(p1.getLName()), 0);
    }

    public static void main(String[] args) {
        TestCompare test = new TestCompare();
        test.test1();
    }
}
