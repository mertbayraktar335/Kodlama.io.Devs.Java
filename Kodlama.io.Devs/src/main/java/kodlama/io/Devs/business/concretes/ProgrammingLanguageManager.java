package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.ProgrammingLanguages.CreateProgrammingLangugageRequest;
import kodlama.io.Devs.business.requests.ProgrammingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.ProgrammingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.ProgrammingLanguages.GetByIdProgrammingLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguages.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;

    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> pLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

        for (ProgrammingLanguage programmingLanguage : pLanguages) {

            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());
            List<String> pLanguageTechs = new ArrayList<>();
            getTechList(pLanguageTechs, programmingLanguage);
            responseItem.setTechnologies(pLanguageTechs);
            programmingLanguagesResponses.add(responseItem);
        }

        return programmingLanguagesResponses;
    }

    @Override
    public ProgrammingLanguage add(CreateProgrammingLangugageRequest programmingLanguageRequest) throws Exception {

        if (!isNameValid(programmingLanguageRequest.getName())) {
            throw new Exception("İsim alanı boş veya sistemdeki isimle aynı");
        }
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(programmingLanguageRequest.getName());
        return programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {

        if (!isIdExist(id)) {
            throw new Exception("Programlama Dili Bulunamadı");
        }

        programmingLanguageRepository.deleteById(id);

    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) throws Exception {

        if (!isIdExist(id)) {
            throw new Exception("Programlama Dili Bulunamadı");
        }
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        GetByIdProgrammingLanguageResponse responseItem = new GetByIdProgrammingLanguageResponse();

        responseItem.setId(programmingLanguage.getId());
        responseItem.setName(programmingLanguage.getName());
        List<String> pLanguageTechs = new ArrayList<>();
        getTechList(pLanguageTechs, programmingLanguage);
        responseItem.setTechnologies(pLanguageTechs);
        return responseItem;

    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("Programlama Dili Bulunamadı");

        }
        if (!isNameValid(updateProgrammingLanguageRequest.getName())) {
            throw new Exception("İsim alanı boş veya sistemdeki isimle aynı");
        }
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(id);
        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
        programmingLanguageRepository.save(programmingLanguage);
    }

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

    private void getTechList(List<String> list, ProgrammingLanguage programmingLanguage) {
        for (ProgrammingTechnology pTechnology : programmingLanguage.getTechnologies()) {
            list.add(pTechnology.getName());
        }
    }

}
