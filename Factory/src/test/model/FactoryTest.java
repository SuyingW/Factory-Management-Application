package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    private Factory testFactory;
    private List testWorkers;


    @BeforeEach
    void runBefore() {
        testFactory = new Factory("MyFactory");
        testWorkers = testFactory.getWorkers();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testWorkers.size());
        assertTrue(testWorkers.isEmpty());
    }

    @Test
    void testSelectWorker() {
        Worker suying = new Worker("Suying", 19.5, 0, 0);
        testFactory.addWorker(suying);
        testFactory.selectWorker(suying);
        assertEquals(suying, testFactory.getSelectedWorker());
    }


    @Test
    void testAddWoker() {
        Worker suying = new Worker("Suying", 19.5, 0, 0);
        Worker amy = new Worker("Amy", 17, 0,0);
        Worker zoe = new Worker("Zoe", 22.1,0,0);
        testFactory.addWorker(suying);
        assertEquals(1, testWorkers.size());

        testFactory.addWorker(amy);
        testFactory.addWorker(zoe);
        assertEquals(3, testWorkers.size());
        assertEquals(suying, testWorkers.get(0));
        assertEquals(amy, testWorkers.get(1));
        assertEquals(zoe, testWorkers.get(2));
    }

    @Test
    void testRemoveWorker() {
        Worker suying = new Worker("Suying", 19.5,0,0);
        Worker amy = new Worker("Amy", 17,0,0);
        Worker zoe = new Worker("Zoe", 22.1,0,0);
        testFactory.addWorker(suying);
        testFactory.addWorker(amy);
        testFactory.addWorker(zoe);
        testFactory.removeWorker(amy);
        assertEquals(2, testWorkers.size());
        assertEquals(zoe, testWorkers.get(1));
    }

    @Test
    void testGetWorker() {
        Worker suying = new Worker("Suying", 19.5,0,0);
        testFactory.addWorker(suying);
        assertEquals(suying, testFactory.getWorker(suying));
    }

    @Test
    void testGetNames() {
        Worker suying = new Worker("Suying", 19.5,0,0);
        Worker amy = new Worker("Amy", 17,0,0);
        testFactory.addWorker(suying);
        testFactory.addWorker(amy);
        assertEquals("Suying",testFactory.getNames().get(0));
        assertEquals("Amy",testFactory.getNames().get(1));
        assertEquals(2,testFactory.getNames().size());

    }

    @Test
    void testGetNumWorkers() {
        Worker suying = new Worker("Suying", 19.5,0,0);
        Worker amy = new Worker("Amy", 17,0,0);
        assertEquals(0, testFactory.numWorkers());
        testFactory.addWorker(suying);
        assertEquals(1, testFactory.numWorkers());
        testFactory.addWorker(amy);
        assertEquals(2, testFactory.numWorkers());

    }

    }



