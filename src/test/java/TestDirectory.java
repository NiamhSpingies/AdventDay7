

import org.example.Database.Directory;
import org.example.Database.File;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


public class TestDirectory {

        @Test
        public void testDirectoryConstructor() {
            Directory parent = new Directory(null, "Parent");
            Directory directory = new Directory(parent, "Child");
            assertEquals("Child", directory.getName());
            assertEquals(0, directory.size());
            assertNotNull(directory.getParent());
            assertEquals("Parent", directory.getParent().getName());
        }


        @Test
        public void testGetFiles() {
            Directory parent = new Directory(null, "Parent");
            Directory directory = new Directory(parent, "Child");
            File file1 = new File("file1.txt", 100);
            File file2 = new File("file2.txt", 200);
            directory.addFile(file1);
            directory.addFile(file2);
            Collection<File> files = directory.getFiles();
            assertEquals(2, files.size());
            assertTrue(files.contains(file1));
            assertTrue(files.contains(file2));
        }


        @Test
        public void testAddFile() {
            Directory parent = new Directory(null, "Parent");
            Directory directory = new Directory(parent, "Child");
            File file1 = new File("file1.txt", 100);
            File file2 = new File("file2.txt", 200);
            directory.addFile(file1);
            directory.addFile(file2);
            Collection<File> files = directory.getFiles();
            assertEquals(2, files.size());
            assertTrue(files.contains(file1));
            assertTrue(files.contains(file2));
        }

        @Test
        public void testSize() {
            Directory parent = new Directory(null, "Parent");
            Directory directory = new Directory(parent, "Child");
            File file1 = new File("file1.txt", 100);
            File file2 = new File("file2.txt", 200);
            directory.addFile(file1);
            directory.addFile(file2);
            assertEquals(300, directory.size());
        }

}
