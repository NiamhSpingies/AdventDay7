package org.example.Database;

/**
 * The Object File.
 */
public class File {

    private String fileName;
    private long fileSize;


    /**
     * Instantiates a new File.
     *
     * @param name the name
     * @param size the size
     */
    public File(String name, long size) {
        this.fileName = name;
        this.fileSize = size;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return fileName;
    }

    /**
     * Size long.
     *
     * @return the long
     */
    public long size() {
        return fileSize;
    }
}
