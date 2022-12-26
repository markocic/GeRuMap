package raf.dsw.gerumap.serializer.custom;

import com.google.gson.*;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MindMapSerializer implements JsonSerializer<MindMap>, JsonDeserializer<MindMap> {
    @Override
    public JsonElement serialize(MindMap map, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("class", new JsonPrimitive(map.getClass().getSimpleName()));
        result.add("name", new JsonPrimitive(map.getName()));

        JsonArray models = new JsonArray();
        for (ElementModel model : map.getModels()) {
            models.add(jsonSerializationContext.serialize(model));
        }

        result.add("models", models);
        result.add("template", new JsonPrimitive(map.isTemplate()));
        result.add("centralniPojam", jsonSerializationContext.serialize(map.getCentralniPojam()));
        return result;
    }

    @Override
    public MindMap deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        boolean template = jsonObject.get("template").getAsBoolean();

        ArrayList<ElementModel> models = new ArrayList<>();

        for (JsonElement element : jsonObject.getAsJsonArray("models")) {
            models.add(jsonDeserializationContext.deserialize(element, ElementModel.class));
        }

        MindMap mindMap = new MindMap();
        mindMap.setName(name);
        mindMap.setTemplate(template);
        mindMap.setModels(models);

        return mindMap;
    }
}
