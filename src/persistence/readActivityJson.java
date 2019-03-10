package persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.Activity;
import model.Task;

import java.io.*;

public class readActivityJson {

    public readActivityJson() {
    }

    public Activity readActivityJsonStream(InputStream in) throws IOException {
        
        JsonReader reader = new JsonReader(new InputStreamReader( in, "UTF-8"));
        Gson gson = new Gson();
        Activity activity = new Activity();
        reader.beginArray();
        while (reader.hasNext()) {
            Task task = gson.fromJson(reader, Task.class);
            activity.addTask(task);
        }
        reader.endArray();
        reader.close();
        return activity;
    }
}
