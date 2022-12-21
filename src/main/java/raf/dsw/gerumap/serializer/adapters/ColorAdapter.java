package raf.dsw.gerumap.serializer.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.awt.*;
import java.io.IOException;

public class ColorAdapter extends TypeAdapter<Color> {

    @Override
    public void write(JsonWriter jsonWriter, Color color) throws IOException {

        if (color == null) {
            jsonWriter.nullValue();
            return;
        }
        String colorString = color.getRed() + "," + color.getGreen() + ","+ color.getBlue();
        jsonWriter.value(colorString);
    }

    @Override
    public Color read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String color = jsonReader.nextString();
        String[] colorRGB = color.split(",");
        int red = Integer.parseInt(colorRGB[0]);
        int green = Integer.parseInt(colorRGB[1]);
        int blue = Integer.parseInt(colorRGB[2]);
        return new Color(red, green, blue);
    }
}
