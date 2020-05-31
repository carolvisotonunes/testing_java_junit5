package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {
    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
        assertEquals("index", indexController.index(), ()->"Another expensive message " +
                "Make me only if you have to");
    }

    @DisplayName("Test Exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, ()->
            indexController.oopsHandler()
        );
    }
    @Disabled("Demo of timeout")
    @Test
    void timeOut(){
        assertTimeout(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(5000);
                    System.out.println("I got here");
                });
    }
    @Disabled("Demo of timeout")
    @Test
    void timeOutPreemptively(){
        assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(5000);
                    System.out.println("I got here Preemptively");
                });
    }

    @Test
    void assumptionTrue(){
       assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void assumptionTrueAssumptionIsTrue(){
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
}