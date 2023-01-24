
import org.example.Database.File;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestFile {

    @Test
    public void testFileConstructor() {
        File file = new File("test.txt", 1024);
        assertEquals("test.txt", file.getName());
        assertEquals(1024, file.size());
    }

    @Test
    public void testGetName() {
        File file = new File("test.txt", 1024);
        assertEquals("test.txt", file.getName());
    }

    @Test
    public void testSize() {
        File file = new File("test.txt", 1024);
        assertEquals(1024, file.size());
    }

}
