package raf.dsw.gerumap.serializer.custom;

import com.google.gson.*;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProjectSerializer implements JsonSerializer<Project>, JsonDeserializer<Project>{

    public JsonElement serialize(Project project, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.add("name", new JsonPrimitive(project.getName()));
        result.add("author", new JsonPrimitive(project.getAuthor()));
        result.add("path", new JsonPrimitive(project.getPath()));

        JsonArray children = new JsonArray();

        for (MapNode map : project.getChildren()) {
            children.add(jsonSerializationContext.serialize(map, MindMap.class));
        }

        result.add("children", children);

        return result;
    }

    @Override
    public Project deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        String author = jsonObject.get("author").getAsString();
        String path = jsonObject.get("path").getAsString();

        ArrayList<MapNode> children = new ArrayList<>();

        for (JsonElement element : jsonObject.getAsJsonArray("children")) {
            children.add(jsonDeserializationContext.deserialize(element, MindMap.class));
        }

        Project project = new Project();
        project.setName(name);
        project.setAuthor(author);
        project.setPath(path);
        project.setChildren(children);

        return project;
    }
}
