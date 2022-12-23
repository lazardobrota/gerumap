package raf.dsw.gerumap.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Node;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {

    private final Gson gson = new GsonBuilder().registerTypeAdapter(MapNode.class, new MapNodeAdapter()).create();

    @Override
    public Project loadProject(File file) {
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(file);
            return gson.fromJson(fileReader, Project.class);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveProject(Project project) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(project.getFilePath());
            gson.toJson(project, writer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
