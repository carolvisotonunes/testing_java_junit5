package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class OwnerTest implements ModelTest {
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
                        () -> assertEquals("City", owner.getCity(), "City name did not match"),
                        () -> assertEquals("123123123", owner.getTelephone()))
        );
        MatcherAssert.assertThat(owner.getCity(), Matchers.is("City"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void valueSource(String value) {
        System.out.println(value);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @CsvSource({
            "FL, 1,1",
            "OH, 2,2",
            "MI, 1,1",
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+ val1 +" : "+ val2);
    }

    @DisplayName("CSV File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+ val1 +" : "+ val2);
    }


    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName +" = "+ val1 +" : "+ val2);
    }
    //TODO check whats going on

    static Stream<Arguments> getArgs(){
        return Stream.of(Arguments.of("FL", 1,1),
                Arguments.of("OH", 2,2), Arguments.of("MI", 1,1));

    }
}