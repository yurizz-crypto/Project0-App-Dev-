import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class TestDelete {

    private Phonebook pb;

    public TestDelete() {
        pb = new Phonebook();
    }

    @Test
    public void test1()
    {
        Person p = new Person("123", "Juan", "Dela Cruz", "Male", "Faculty", "12345", 63, 81);
        pb.insert(p);
        pb.deleteContact(p.getId());
        assertEquals(null, pb.getContactAtIndex(0));
    }
    @Test
    public void test2()
    {
        Person p1 = new Person("123", "Juan", "Dela Cruz", "Male", "Faculty", "12345", 63, 81);
        Person p2 = new Person("321", "Maria", "Clara", "Female", "Maiden", "18721", 63, 122);
        Person p3 = new Person("67667", "Jose", "Rizal", "Male", "Makata", "19911", 60, 12);
        pb.insert(p1);
        pb.insert(p2);
        pb.insert(p3);
        pb.deleteContact(p1.getId());
        pb.deleteContact(p2.getId());
        assertEquals("Rizal", pb.getContactAtIndex(0).getLName());
        assertEquals(null, pb.getContactAtIndex(1));
    }
    @Test
    public void test3()
    {
        Person p1 = new Person("123", "Juan", "Dela Cruz", "Male", "Faculty", "12345", 63, 81);
        Person p2 = new Person("321", "Maria", "Clara", "Female", "Maiden", "18721", 63, 122);
        Person p3 = new Person("67667", "Jose", "Rizal", "Male", "Makata", "19911", 60, 12);
        pb.insert(p1);
        pb.insert(p2);
        pb.insert(p3);
        pb.deleteContact(p2.getId());
        assertEquals("Rizal", pb.getContactAtIndex(1).getLName());
        pb.deleteContact(p3.getId());
        assertEquals(null, pb.getContactAtIndex(1));
    }
    @Test
    public void test4()
    {
        Person p1 = new Person("123", "Juan", "Dela Cruz", "Male", "Faculty", "12345", 63, 81);
        Person p2 = new Person("321", "Maria", "Clara", "Female", "Maiden", "18721", 63, 122);
        Person p3 = new Person("67667", "Jose", "Rizal", "Male", "Makata", "19911", 60, 12);
        pb.insert(p1);
        pb.insert(p2);
        pb.insert(p3);
        assertEquals(pb.getSize(), 3);
        pb.deleteContact(p1.getId());
        pb.deleteContact(p2.getId());
        pb.deleteContact(p3.getId());
        assertEquals(pb.getSize(), 0);
        assertEquals(true, pb.isEmpty());
    }
}
