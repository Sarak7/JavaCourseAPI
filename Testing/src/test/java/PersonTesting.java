
import org.example.PERSON;
import org.junit.jupiter.api.*;


public class PersonTesting {

    private PERSON p;

    @BeforeEach
    public void createObjects() {

        p= new PERSON("Sara", 25,"KSA");
        System.out.println("creating before each");
    }
    @Test
    public void setAge(){
        int actual = p.getAge();
        int expected = 25;
        Assertions.assertEquals(expected,actual);
    }
}
