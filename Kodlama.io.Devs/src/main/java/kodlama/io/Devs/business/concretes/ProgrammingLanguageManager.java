package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.CreateProgrammingLangugageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> pLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses=new ArrayList<GetAllProgrammingLanguagesResponse>();
        
        for (ProgrammingLanguage programmingLanguage : pLanguages) {

            GetAllProgrammingLanguagesResponse responseItem =new GetAllProgrammingLanguagesResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());
            programmingLanguagesResponses.add(responseItem);
            
            
        }
        
        
        
        return programmingLanguagesResponses;
    }

    @Override
    public ProgrammingLanguage add(CreateProgrammingLangugageRequest programmingLanguageRequest) throws Exception {
        
        if (!isNameValid(programmingLanguageRequest.getName())) {
            throw new Exception("İsim alanı boş veya sistemdeki isimle aynı");
        }
        ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
        programmingLanguage.setName(programmingLanguageRequest.getName());
        return programmingLanguageRepository.save(programmingLanguage);
    }

    // @Override
    // public void delete(int id) throws Exception {

    //     ProgrammingLanguage pLanguageToDelete = getById(id);
    //     if (!isIdExist(pLanguageToDelete.getId())) {
    //         throw new Exception("ID BULUNAMADI");
    //     }
    //     programmingLanguageRepository.delete(pLanguageToDelete);

    // }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {

        if (!isIdExist(id)) {
            throw new Exception("ID BULUNAMADI");
        }
        return programmingLanguageRepository.getReferenceById(id);

    }

    // @Override
    // public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
    //     if (!isIdExist(id)) {
    //         throw new Exception("ID BULUNAMADI");

    //     }
    //     programmingLanguageRepository.save(programmingLanguage );
    // }

    private boolean isIdExist(int id) {
        for (ProgrammingLanguage pLanguage : programmingLanguageRepository.findAll()) {
            if (pLanguage.getId() == id) {
                return true;
            }

        }
        return false;
    }

    private boolean isNameValid(String name) throws Exception {
        if (name.isBlank()) {
            return false;
        }
        for (ProgrammingLanguage p : programmingLanguageRepository.findAll()) {

            if (name.equalsIgnoreCase(p.getName())) {

                return false;

            }

        }
        return true;
    }
   

}
