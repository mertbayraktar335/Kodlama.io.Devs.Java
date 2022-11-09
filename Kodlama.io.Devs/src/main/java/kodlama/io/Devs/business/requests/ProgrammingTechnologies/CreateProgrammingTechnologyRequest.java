package kodlama.io.Devs.business.requests.ProgrammingTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateProgrammingTechnologyRequest {
    private String name;
    int programmingLanguageId;
}
