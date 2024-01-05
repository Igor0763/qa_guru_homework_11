import com.fasterxml.jackson.databind.ObjectMapper;
import models.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class ReadingJsonTest {
    ObjectMapper mapper = new ObjectMapper();
    ClassLoader cl = ReadingJsonTest.class.getClassLoader();

    @Test
    void jsonFileParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("pet.json")) {
            Pet pet = mapper.readValue(is, Pet.class);


            Assertions.assertEquals(44, pet.getId());
            Assertions.assertEquals(45, pet.getCategory().getId());
            Assertions.assertEquals("dog", pet.getCategory().getName());
            Pet.Specifics ps = pet.getSpecifics().get(0);
            Assertions.assertEquals(46, ps.getId());
            Assertions.assertEquals("small", ps.getName());


        }
    }
}
