package raf.dsw.gerumap.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.serializer.adapters.ColorAdapter;
import raf.dsw.gerumap.serializer.custom.MapNodeSerializer;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//unutar command deasvanja ne smijemo da imamo zvanje view-a
public class GsonSerializer implements Serializer {

    private final Gson gson;
    private GsonBuilder gsonBuilder = new GsonBuilder();

    public GsonSerializer() {
        gsonBuilder.registerTypeAdapter(Color.class, new ColorAdapter());
        gsonBuilder.registerTypeAdapter(MapNode.class, new MapNodeSerializer());
        gson = gsonBuilder.create();
    }


    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getPath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
