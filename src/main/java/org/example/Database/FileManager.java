package org.example.Database;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * FileManager class provides functionality to manage files and directories.
 * It reads a file and creates a directory structure based on the contents of the file.
 * It also provides methods to check the storage usage and delete files and directories.
 */
public class FileManager {
    private long ED_SystemStorage = 70000000;
    private long SoftwareUpdate = 30000000;
    public Directory sourceDirectory = new Directory(null, "/");
    public Directory currentDirectory = sourceDirectory;
    public List<Directory> allDirectories = new ArrayList<>();

    /**
     * Instantiates a new File manager.
     *
     * @param file the file to read and create the directory structure
     * @throws IOException the io exception if there is a problem reading the file
     */
    public FileManager(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] stringList = line.split(" ");
            if ("$".equals(stringList[0])) {
                if ("cd".equals(stringList[1])) {
                    if ("/".equals(stringList[2])) {
                        currentDirectory = sourceDirectory;
                    } else if ("..".equals(stringList[2])) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
                        currentDirectory = currentDirectory.getDirectory(stringList[2]);
                    }
                }
            } else if ("dir".equals(stringList[0])) {
                Directory dir = new Directory(currentDirectory, stringList[1]);
                currentDirectory.addFile(dir);
                allDirectories.add(dir);
            } else {
                currentDirectory.addFile(new File(stringList[1], Long.parseLong(stringList[0])));
            }
        }
    }

    /**
     * justEnoughStorage method returns the total space needed in the file manager.
     *
     * @return the long value of the smallest dir that can be deleted to free up just enough space
     */
    public long justEnoughStorage() {
        List<Directory> removal = new ArrayList<>();
        long deleteNeeded = SoftwareUpdate-(ED_SystemStorage-sourceDirectory.size());
        for (Directory dir : allDirectories) {
            if (dir.size() > deleteNeeded) {
                removal.add(dir);
            }
        }
        removal.add(sourceDirectory);
        removal.sort((a, b) -> (int) (a.size() - b.size()));
        long toDelete = removal.get(0).size();
        return toDelete;
    }

    /**
     * SpecifiedDeletion method deletes files and directories to free up a specific amount of space.
     *
     * @param spaceNeeded the space needed to be freed up
     * @return the amount of space that can be safely deleted
     */
    public long specifiedDeletion(long spaceNeeded) {
        long toDelete = 0;
        for (Directory dir : allDirectories) {
            long nextDeletion = dir.size();
            if (nextDeletion < spaceNeeded) {
                toDelete += nextDeletion;
            }
        }
        return toDelete;
    }
}


