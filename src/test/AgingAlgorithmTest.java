import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgingAlgorithmTest {
    AgingAlgorithm ageing = new AgingAlgorithm();
    FReader read = new FReader();

    @Test
    void AgingAlgorithmTest(){

    }

    @Test
    void ageingAlgorithm() {
        assertAll(
                ()->
                    assertEquals(11, ageing.ageingAlgorithm(
                            read.readFile("examples/test_A_R32_P8.txt"),
                            4,
                            4
                    )),
                ()->
                        assertEquals(12, ageing.ageingAlgorithm(
                                read.readFile("examples/test_B_R32_P8.txt"),
                                4,
                                4
                        )),
                ()->
                        assertEquals(7, ageing.ageingAlgorithm(
                                read.readFile("examples/test_A2_R32_P8.txt"),
                                4,
                                4
                        )),
                ()->
                        assertEquals(15, ageing.ageingAlgorithm(
                                read.readFile("examples/test_B2_R32_P8.txt"),
                                4,
                                4
                        ))
                );

    }

}
