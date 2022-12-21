package raf.dsw.gerumap.serializer.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.awt.*;
import java.io.IOException;

public class PointAdapter extends TypeAdapter<Point> {
    public Point read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String xy = reader.nextString();
        String[] parts = xy.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return new Point(x, y);
    }
    public void write(JsonWriter writer, Point value) throws IOException {
        if (value == null) {
            writer.nullValue();
            return;
        }
        String xy = (int) value.getX() + "," + (int) value.getY();
        writer.value(xy);
    }
}
