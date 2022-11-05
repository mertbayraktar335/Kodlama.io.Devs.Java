package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.ProgrammingLanguages.CreateProgrammingLangugageRequest;
import kodlama.io.Devs.business.requests.ProgrammingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.ProgrammingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.ProgrammingLanguages.GetByIdProgrammingLanguageResponse;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguagesResponse> getAll();

    ProgrammingLanguage add(CreateProgrammingLangugageRequest programmingLanguageRequest) throws Exception;

     void delete(int id) throws Exception;

     GetByIdProgrammingLanguageResponse getById(int id) throws Exception;

     void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception;

}
