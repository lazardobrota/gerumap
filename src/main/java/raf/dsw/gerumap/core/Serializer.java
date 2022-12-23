package raf.dsw.gerumap.core;

import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    void saveProject(Project project);
    MindMap loadSablon(File file);
    void saveSablon(MindMap mindMap);
}
