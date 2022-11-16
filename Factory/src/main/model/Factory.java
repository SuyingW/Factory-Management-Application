package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//represents a factory that contains a list of workers
public class Factory implements Writable {
    private String name;
    private List<Worker> workers;
    private Worker selectedWorker;

    // EFFECTS: constructs a factory with no workers
    public Factory(String name) {
        this.name = name;
        workers = new ArrayList<>();
        selectedWorker = null;
    }

    public String getName() {
        return name;
    }

    //REQUIRES: worker is in workers
    //MODIFIES: this
    //EFFECTS: select a worker
    public void selectWorker(Worker worker) {
        for (Worker next : workers) {
            if (workers.contains(worker)) {
                this.selectedWorker = worker;
            }
        }
    }


    public Worker getSelectedWorker() {
        return selectedWorker;
    }

    // REQUIRES: each worker is added to the list only once, and each worker has a unique name
    // MODIFIES: this
    // EFFECTS:  adds a worker to the factory at the end of the list
    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }


    // MODIFIES: this
    // EFFECTS:  remove a worker from the factory
    public void removeWorker(Worker worker) {
        this.workers.remove(worker);
    }

    // EFFECTS: return the list of workers
    public List<Worker> getWorkers() {
        return this.workers;
    }

    //EFFECTS: return the list of workers' names
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Worker worker : workers) {
            names.add(worker.getName());
        }
        return names;
    }

    public Worker getWorker(Worker worker) {
        return worker;
    }

    //EFFECTS: return number of workers in this factory
    public int numWorkers() {
        return workers.size();
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("workers", workersToJson());
        return json;
    }

    // EFFECTS: returns workers in this factory as a JSON array
    private JSONArray workersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Worker worker : workers) {
            jsonArray.put(worker.toJson());
        }

        return jsonArray;
    }
}
