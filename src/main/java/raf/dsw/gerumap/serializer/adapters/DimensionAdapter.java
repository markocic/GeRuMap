package raf.dsw.gerumap.serializer.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.awt.*;
import java.io.IOException;

public class DimensionAdapter extends TypeAdapter<Dimension> {
    @Override
    public void write(JsonWriter jsonWriter, Dimension dimension) throws IOException {
        String xy = (int) dimension.getWidth() + "x" + (int) dimension.getHeight();
        jsonWriter.value(xy);
    }

    public Dimension read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String wh = reader.nextString();
        String[] parts = wh.split("x");
        int w = Integer.parseInt(parts[0]);
        int h = Integer.parseInt(parts[1]);
        return new Dimension(w, h);
    }
}
