package persistence;

import model.Factory;
import model.Worker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Factory factory = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFactory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFactory.json");
        try {
            Factory factory = reader.read();
            assertEquals("MyFactory", factory.getName());
            assertEquals(0, factory.numWorkers());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralFactory() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFactory.json");
        try {
            Factory factory = reader.read();
            assertEquals("MyFactory", factory.getName());
            List<Worker> workers = factory.getWorkers();
            assertEquals(2, workers.size());
            checkWorker("amy", 1,0,0, workers.get(0));
            checkWorker("zoe", 2,0,0, workers.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

