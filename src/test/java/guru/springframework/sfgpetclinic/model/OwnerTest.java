package guru.springframework.sfgpetclinic.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {
    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("City");
        owner.setTelephone("123123123");
        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name did not match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("City", owner.getCity(),"City name did not match"),
                        () -> assertEquals("123123123", owner.getTelephone()))
        );
        MatcherAssert.assertThat(owner.getCity(), Matchers.is("City"));
    }

}