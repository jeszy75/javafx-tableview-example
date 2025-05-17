package tableview.countries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.List;

public class CountryManager {

    public List<Country> getAll() throws IOException {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .readValue(CountryManager.class.getResourceAsStream("/countries.json"),
                        new TypeReference<List<Country>>() {});
    }

}
