package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Group Assertion",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionsMessages() {
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Group Assertion",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last name Failed"));
    }

    @RepeatedTest(value = 10, name ="{displayName} : {currentRepetition} : - {totalRepetitions}" )
    @DisplayName("My repeated test")
    void myRepeatedTest(){
        //do nothing
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+":"+repetitionInfo.getCurrentRepetition());
    }

}