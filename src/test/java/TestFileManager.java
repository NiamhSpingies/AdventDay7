import org.example.Database.FileManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestFileManager {

    @Test
    public void testStorage() throws IOException {
        FileManager fileManager = new FileManager("src/main/resources/testFile.txt");
        assertEquals(24933642, fileManager.justEnoughStorage());
    }

    @Test
    public void testSpecifiedDeletion() throws IOException {
        FileManager fileManager = new FileManager("src/main/resources/testFile.txt");
        assertEquals(584, fileManager.specifiedDeletion(2000));
    }

    @Test
    public void testFileManagerConstructor() throws IOException {
        FileManager fileManager = new FileManager("src/main/resources/testFile.txt");
        assertNotNull(fileManager);
        assertNotNull(fileManager.sourceDirectory);
        assertNotNull(fileManager.currentDirectory);
        assertNotNull(fileManager.allDirectories);
    }

}
