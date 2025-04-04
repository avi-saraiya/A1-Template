package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class OutputFormatterTest {
    @Test
    public void testOutputFormatterForCanonicalForm() {
        OutputFormatter outputFormatter = new OutputFormatter();
        List<String> moves = List.of("R", "F", "L", "F");
        StringBuilder canonicalForm = outputFormatter.solFormat(moves);
        assertNotNull(canonicalForm, "Canonical form should not be null.");
    }
}