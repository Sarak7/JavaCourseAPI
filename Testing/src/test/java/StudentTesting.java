import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentTesting {

    //    private int count;
    private static Student s1;

    @BeforeEach
    public void createObjects() {


        s1 = new Student("Sara", 26, "KSA", 1234567, "Java");
        System.out.println("creating before each");
    }

    @Test
    public void setName() {
        String actual = s1.getName();
        String expected = "Sara";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void setcourse() {
        String  actual = s1.getCourse();
        String expected = "Java";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void setaddress() {
        String  actual = s1.getAddress();
        String expected = "KSA";
        Assertions.assertEquals(expected, actual);
    }
}
