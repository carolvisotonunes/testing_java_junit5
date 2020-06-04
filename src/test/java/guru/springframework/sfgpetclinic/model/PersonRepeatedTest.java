package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepeatedTest {

    @RepeatedTest(value = 10, name ="{displayName} : {currentRepetition} : - {totalRepetitions}" )
    @DisplayName("My repeated test")
    void myRepeatedTest(){
        //do nothing
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+":"+repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5)
    @DisplayName("My assignment repeated Test")
    void assignmentRepeated(){

    }
}
