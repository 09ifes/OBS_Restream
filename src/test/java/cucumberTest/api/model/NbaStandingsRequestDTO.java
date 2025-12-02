package cucumberTest.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class NbaStandingsRequestDTO {
    private String league;
    private String season;
    private String team;
    private String conference;
    private String division;
}
