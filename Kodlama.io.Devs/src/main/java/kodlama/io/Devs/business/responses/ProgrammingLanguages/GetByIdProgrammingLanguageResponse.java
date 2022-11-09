package kodlama.io.Devs.business.responses.ProgrammingLanguages;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProgrammingLanguageResponse {
    private int id;
    private String name;
    private List<String> technologies;
}
