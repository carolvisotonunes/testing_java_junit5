package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CostumArgsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
       return Stream.of(Arguments.of("FL", 7,10),
                Arguments.of("OH", 6,5), Arguments.of("MI", 11,15));
    }
}
