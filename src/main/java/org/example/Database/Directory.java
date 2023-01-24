package org.example.Database;
import java.util.*;


/**
 * The type Directory.
 * This class represents a directory in a file system, which can contain other files and directories.
 * It extends the File class and adds a parent directory, a map of contained files, and methods for adding and accessing those files.
 */
public class Directory extends File {

    /**
     * The parent directory of this directory, or null if it is the root directory.
     */
    private final Directory parent;

    /**
     * The map of files contained in this directory, indexed by their names.
     */
    private Map<String, File> files = new HashMap();

    /**
     * Instantiates a new Directory.
     *
     * @param parent the parent directory of this directory, or null if it is the root directory
     * @param name   the name of this directory
     */
    public Directory(Directory parent, String name) {
        super(name, 0);
        this.parent = parent;
    }

    /**
     * Gets files.
     *
     * @return the files
     */
    public Collection<File> getFiles() {
        return files.values();
    }

    /**
     * Add file.
     *
     * @param file the file
     */
    public void addFile(File file) {
        files.put(file.getName(), file);
    }

    /**
     * Calculates the size of all files contained in this directory.
     *
     * @return the total size of all files contained in this directory
     */
    public long size() {
        long value = 0;
        for (File file : files.values()) {
            value += file.size();
        }
        return value;
    }

    /**
     * Gets the parent directory of this directory.
     *
     * @return the parent directory, or null if this is the root directory
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * Gets a directory contained in this directory by its name.
     *
     * @param string the name of the directory
     * @returns the directory
     */
    public Directory getDirectory(String string) {
        return (Directory) files.get(string);
    }
}
