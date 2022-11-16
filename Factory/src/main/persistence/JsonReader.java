package persistence;

import model.Factory;
import model.Worker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//reference: JsonSerializationDemo
// Represents a reader that reads factory from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads factory from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Factory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFactory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses factory from JSON object and returns it
    private Factory parseFactory(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Factory factory = new Factory("MyFactory");
        addWorkers(factory, jsonObject);
        return factory;
    }

    // MODIFIES: factory
    // EFFECTS: parses workers from JSON object and adds them to factory
    private void addWorkers(Factory factory, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("workers");
        for (Object json : jsonArray) {
            JSONObject nextWorker = (JSONObject) json;
            addWorker(factory, nextWorker);
        }
    }

    // MODIFIES: factory
    // EFFECTS: parses worker from JSON object and adds it to factory
    private void addWorker(Factory factory, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double hourlyRate = jsonObject.getDouble("hourly rate");
        //Category category = Category.valueOf(jsonObject.getString("category"));
        double hoursWorked = jsonObject.getDouble("hours worked");
        int numOfTasksCompleted = jsonObject.getInt("number of tasks completed");
        Worker worker = new Worker(name, hourlyRate, hoursWorked, numOfTasksCompleted);
        factory.addWorker(worker);
    }

}



