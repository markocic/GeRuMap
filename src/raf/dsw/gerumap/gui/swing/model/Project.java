package raf.dsw.gerumap.gui.swing.model;

import java.io.File;

public class Project {
    private final String name;
    private final String author;
    private  final File filePath;


    public Project(String name, String author, File filePath) {
        this.name = name;
        this.author = author;
        this.filePath = filePath;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public File getFilePath() {
        return filePath;
    }
}
