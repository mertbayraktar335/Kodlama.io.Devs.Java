package kodlama.io.Devs.business.responses.ProgrammingTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingTechnologiesResponse {
    private int id;
    private String name;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
