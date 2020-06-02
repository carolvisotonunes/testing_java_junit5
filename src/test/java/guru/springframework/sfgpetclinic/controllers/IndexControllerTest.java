package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
@Tag("controllers")
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
        assertEquals("index", indexController.index(), () -> "Another expensive message " +
                "Make me only if you have to");
        assertThat(indexController.index()).isEqualTo("index");
    }

    @DisplayName("Test Exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () ->
                indexController.oopsHandler()
        );
    }

    @Disabled("Demo of timeout")
    @Test
    void timeOut() {
        assertTimeout(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(5000);
                    System.out.println("I got here");
                });
    }

    @Disabled("Demo of timeout")
    @Test
    void timeOutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(5000);
                    System.out.println("I got here Preemptively");
                });
    }

    @Test
    void assumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void assumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs({OS.WINDOWS})
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_12)
    @Test
    void testMeOnMac12() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "carolinenunes")
    @Test
    void tesIfUserCarolVNunes() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "Fred")
    @Test
    void testIfUserFred() {

    }


}