package tableview;

import java.time.ZoneId;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Country {

    @JsonProperty("alpha2Code") private String code;
    private String name;
    private String capital;
    private long population;
    private List<ZoneId> timezones;

}
