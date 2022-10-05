package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    private final Sample sample = new Sample();
    @ParameterizedTest
    @CsvSource({
        "0, 3, 3",
        "3, 4, 7",
        "-1, -4, -5"
    })
    void addition_cases(int a, int b, int expectedResult) {
        int result = sample.op(Sample.Operation.ADD, a, b);

        Assertions.assertThat(result)
            .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "3, 4, 12",
        "-2, -4, 8"
    })
    void multi_cases(int a, int b, int expectedResult) {
        int result = sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(result)
            .isEqualTo(expectedResult);
    }

    @Test
    void test_negatif_factor_throw(){

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) // (5)
            .isThrownBy(() -> sample.fact(-5)) // (6)
            .withMessage("N should be positive");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "3, 6",
        "6, 720"
    })
    void test_factor_cases(int a, int expectedResult){
        int result = sample.fact(a);
        Assertions.assertThat(result)
            .isEqualTo(expectedResult);
    }
}
