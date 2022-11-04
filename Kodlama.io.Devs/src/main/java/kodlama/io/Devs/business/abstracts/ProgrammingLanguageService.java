package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateProgrammingLangugageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguagesResponse> getAll();

    ProgrammingLanguage add(CreateProgrammingLangugageRequest programmingLanguageRequest) throws Exception;

    // void delete(int id) throws Exception;

     ProgrammingLanguage getById(int id) throws Exception;

    // void update(ProgrammingLanguage programmingLanguage, int id) throws Exception;

}
