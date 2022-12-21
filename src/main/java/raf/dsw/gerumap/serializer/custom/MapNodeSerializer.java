package raf.dsw.gerumap.serializer.custom;

import com.google.gson.*;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import java.lang.reflect.Type;

public class MapNodeSerializer implements JsonSerializer<MapNode>, JsonDeserializer<MapNode> {
    @Override
    public JsonElement serialize(MapNode mapNode, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("class", new JsonPrimitive(mapNode.getClass().getSimpleName()));
        MindMap map = (MindMap) mapNode;
        result.add("name", new JsonPrimitive(map.getName()));

        JsonArray models = new JsonArray();
        for (ElementModel model : map.getModels()) {
            // za sad ovako, treba sacuvati sve informacije u vezi modela
            models.add(jsonSerializationContext.serialize(model));
        }

        result.add("models", models);
        result.add("template", new JsonPrimitive(map.isTemplate()));
        return result;
    }

    @Override
    public MapNode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.get("class") == null) return null;
        String className = jsonObject.get("class").getAsString();
        if (className.equals("ProjectExplorer")) {
            return jsonDeserializationContext.deserialize(jsonObject, ProjectExplorer.class);
        } else if (className.equals("Project")) {
            return jsonDeserializationContext.deserialize(jsonObject, Project.class);
        } else if (className.equals("MindMap")) {
            return jsonDeserializationContext.deserialize(jsonObject, MindMap.class);
        } else if (className.equals("Element")) {
            return jsonDeserializationContext.deserialize(jsonObject, Element.class);
        }
        return null;
    }
}
