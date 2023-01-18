package tech.tresearchgroup.libraries.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File initialFile = new File("test.json");
        InputStream targetStream = new FileInputStream(initialFile);
        JsonReader jsonReader = new JsonReader(new InputStreamReader(targetStream));
        while (jsonReader.hasNext()) {
            JsonToken nextToken = jsonReader.peek();
            System.out.println(nextToken);
            if (JsonToken.NAME.equals(nextToken)) {
                String name = jsonReader.nextName();
                System.out.println("Key: " + name);
            } else if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {
                jsonReader.beginObject();
            } else if (JsonToken.END_OBJECT.equals(nextToken)) {
                jsonReader.endObject();
            } else if (JsonToken.BEGIN_ARRAY.equals(nextToken)) {
                jsonReader.beginArray();
            } else if (JsonToken.END_ARRAY.equals(nextToken)) {
                jsonReader.endArray();
            } else if (JsonToken.STRING.equals(nextToken)) {
                String value = jsonReader.nextString();
                System.out.println("String: " + value);
            } else if (JsonToken.NUMBER.equals(nextToken)) {
                long value = jsonReader.nextLong();
                System.out.println("Long: " + value);
            } else if (JsonToken.NULL.equals(nextToken)) {
                jsonReader.nextNull();
                System.out.println("NULL: null");
            } else if(JsonToken.BOOLEAN.equals(nextToken)) {
                boolean value = jsonReader.nextBoolean();
                System.out.println("Boolean: " + value);
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        targetStream.close();
    }
}
