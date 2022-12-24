package raf.dsw.gerumap.core;

import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import java.io.File;

public interface Serializer {
    Project loadProject(File file);
    void saveProject(Project project);

    void saveTemplate(MindMap map, String path);
}
