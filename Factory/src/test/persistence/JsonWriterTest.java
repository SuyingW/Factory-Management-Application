package persistence;

import model.Factory;
import model.Worker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            Factory wr = new Factory("MyFactory");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Factory factory = new Factory("MyFactory");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFactory.json");
            writer.open();
            writer.write(factory);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFactory.json");
            factory = reader.read();
            assertEquals("MyFactory", factory.getName());
            assertEquals(0, factory.numWorkers());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Factory factory = new Factory("MyFactory");
            factory.addWorker(new Worker("amy", 1, 0, 0));
            factory.addWorker(new Worker("zoe", 2, 0, 0));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFactory.json");
            writer.open();
            writer.write(factory);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFactory.json");
            factory = reader.read();
            assertEquals("MyFactory", factory.getName());
            List<Worker> workers = factory.getWorkers();
            assertEquals(2, workers.size());
            checkWorker("amy", 1,0,0,workers.get(0));
            checkWorker("zoe", 2, 0, 0, workers.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
