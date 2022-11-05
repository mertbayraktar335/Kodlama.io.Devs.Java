package kodlama.io.Devs.business.requests.ProgrammingTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateProgrammingTechnologyRequest {
    int programmingLanguageId;
    private String name;
}
