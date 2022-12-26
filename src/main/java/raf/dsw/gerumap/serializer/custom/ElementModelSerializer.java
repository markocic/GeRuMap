package raf.dsw.gerumap.serializer.custom;

import com.google.gson.*;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ElementModelSerializer implements JsonSerializer<ElementModel>, JsonDeserializer<ElementModel> {

    private ArrayList<ElementModel> vezaModels = new ArrayList<>();

    @Override
    public JsonElement serialize(ElementModel elementModel, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("class", new JsonPrimitive(elementModel.getClass().getSimpleName()));
        jsonObject.add("color", jsonSerializationContext.serialize(elementModel.getColor()));
        jsonObject.add("stroke", new JsonPrimitive(elementModel.getStroke()));
        if (elementModel instanceof PojamModel) {
            PojamModel pojam = (PojamModel) elementModel;
            jsonObject.add("name", new JsonPrimitive(pojam.getName()));
            jsonObject.add("coordinates", jsonSerializationContext.serialize(pojam.getCoordinates()));
            jsonObject.add("size", jsonSerializationContext.serialize(pojam.getSize()));

            JsonArray odlazeceVeze = new JsonArray();
            for (VezaModel veza : pojam.getOdlazeceVeze()) {
                odlazeceVeze.add(jsonSerializationContext.serialize(veza));
            }

            jsonObject.add("odlazeceVeze", odlazeceVeze);

            JsonArray dolazeceVeze = new JsonArray();
            for (VezaModel veza : pojam.getDolazeceVeze()) {
                dolazeceVeze.add(jsonSerializationContext.serialize(veza));
            }

            jsonObject.add("dolazeceVeze", dolazeceVeze);
            jsonObject.add("isCentralni", new JsonPrimitive(pojam.isCentralni()));

        } else if (elementModel instanceof VezaModel) {
            VezaModel veza = (VezaModel) elementModel;
            jsonObject.add("pocetnaTacka", jsonSerializationContext.serialize(veza.getPocetnaTacka(), Point.class));
            jsonObject.add("krajnjaTacka", jsonSerializationContext.serialize(veza.getKrajnjaTacka(), Point.class));
        }

        return jsonObject;
    }
    @Override
    public ElementModel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.get("class") == null) return null;

        Color color = jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class);
        int stroke = jsonObject.get("stroke").getAsInt();

        String className = jsonObject.get("class").getAsString();
        if (className.equals("PojamModel")) {
            String name = jsonObject.get("name").getAsString();
            Point coords = jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Point.class);
            Dimension dimension = jsonDeserializationContext.deserialize(jsonObject.get("size"), Dimension.class);
            ArrayList<VezaModel> odlazeceVeze = new ArrayList<>();

            for (JsonElement element : jsonObject.getAsJsonArray("odlazeceVeze")) {
                odlazeceVeze.add(jsonDeserializationContext.deserialize(element, VezaModel.class));
            }
            ArrayList<VezaModel> dolazeceVeze = new ArrayList<>();

            for (JsonElement element : jsonObject.getAsJsonArray("dolazeceVeze")) {
                dolazeceVeze.add(jsonDeserializationContext.deserialize(element, VezaModel.class));
            }

            boolean isCentralni = jsonObject.get("isCentralni").getAsBoolean();

            PojamModel pojam = new PojamModel(name, coords, dimension, stroke, color);

            for (VezaModel veza : dolazeceVeze) {
                veza.setDoPojma(pojam);
            }

            for (VezaModel veza : odlazeceVeze) {
                veza.setOdPojma(pojam);
            }

            pojam.setDolazeceVeze(dolazeceVeze);
            pojam.setOdlazeceVeze(odlazeceVeze);
            pojam.setCentralni(isCentralni);
            return pojam;

        } else if (className.equals("VezaModel")) {
            Point pocetnaTacka = jsonDeserializationContext.deserialize(jsonObject.get("pocetnaTacka"), Point.class);
            Point krajnjaTacka = jsonDeserializationContext.deserialize(jsonObject.get("krajnjaTacka"), Point.class);

            // proverava da li smo vec napravili ovakvu vezu i ako jesmo, vraca nju
            VezaModel veza = new VezaModel(color, stroke, pocetnaTacka, krajnjaTacka);
            for (ElementModel model : vezaModels) {
                if (veza.equals(model)) {
                    return model;
                }
            }

            vezaModels.add(veza);
            return veza;
        }
        return null;
    }


}
