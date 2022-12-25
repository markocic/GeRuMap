package raf.dsw.gerumap.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.serializer.adapters.ColorAdapter;
import raf.dsw.gerumap.serializer.adapters.DimensionAdapter;
import raf.dsw.gerumap.serializer.adapters.PointAdapter;
import raf.dsw.gerumap.serializer.custom.ElementModelSerializer;
import raf.dsw.gerumap.serializer.custom.MindMapSerializer;
import raf.dsw.gerumap.serializer.custom.ProjectSerializer;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {

    private final Gson gson;
    private GsonBuilder gsonBuilder = new GsonBuilder();

    public GsonSerializer() {
        ElementModelSerializer elementModelSerializer = new ElementModelSerializer();
        gsonBuilder.registerTypeAdapter(Color.class, new ColorAdapter());
        gsonBuilder.registerTypeAdapter(MindMap.class, new MindMapSerializer());
        gsonBuilder.registerTypeAdapter(Project.class, new ProjectSerializer());
        gsonBuilder.registerTypeAdapter(ElementModel.class, elementModelSerializer);
        gsonBuilder.registerTypeAdapter(PojamModel.class, elementModelSerializer);
        gsonBuilder.registerTypeAdapter(VezaModel.class, elementModelSerializer);
        gsonBuilder.registerTypeAdapter(Point.class, new PointAdapter());
        gsonBuilder.registerTypeAdapter(Dimension.class, new DimensionAdapter());
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

    @Override
    public void saveTemplate(MindMap map, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(map, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MindMap loadTemplate(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, MindMap.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
