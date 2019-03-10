package persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import model.Activity;
import model.Task;

import java.io.*;

public class writeActivityJson {

    public writeActivityJson() {
    }

    //Serialization
    public void writeActivityJsonStream(OutputStream out, Activity activity) throws IOException {
        Gson gson = new Gson();
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writer.beginArray();
        for (Task t : activity.getTasks()) {
            gson.toJson(t, Task.class, writer);
        }
        writer.endArray();
        writer.close();
    }

}
