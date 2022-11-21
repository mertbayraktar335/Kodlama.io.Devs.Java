package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Devs.business.requests.ProgrammingTechnologies.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.ProgrammingTechnologies.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.responses.ProgrammingTechnologies.GetAllProgrammingTechnologiesResponse;
import kodlama.io.Devs.business.responses.ProgrammingTechnologies.GetByIdProgrammingTechnologyResponse;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguages.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologies.ProgrammingTechnologyRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

    private ProgrammingTechnologyRepository programmingTechnologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingTechnologyManager(ProgrammingTechnologyRepository programmingTechnologyRepository,
            ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingTechnologyRepository = programmingTechnologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllProgrammingTechnologiesResponse> getAll() {
        List<ProgrammingTechnology> pTechnologies = programmingTechnologyRepository.findAll();
        List<GetAllProgrammingTechnologiesResponse> programmingTechnologiesResponses = new ArrayList<GetAllProgrammingTechnologiesResponse>();

        for (ProgrammingTechnology programmingTechnology : pTechnologies) {

            GetAllProgrammingTechnologiesResponse responseItem = new GetAllProgrammingTechnologiesResponse();
            responseItem.setId(programmingTechnology.getId());
            responseItem.setName(programmingTechnology.getName());
            responseItem.setProgrammingLanguageId(programmingTechnology.getProgrammingLanguage().getId());
            responseItem.setProgrammingLanguageName(programmingTechnology.getProgrammingLanguage().getName());
            programmingTechnologiesResponses.add(responseItem);

        }
        return programmingTechnologiesResponses;
    }

    @Override
    public void add(CreateProgrammingTechnologyRequest programmingTechnologyRequest) throws Exception {
        if (!isNameValid(programmingTechnologyRequest.getName())) {
            throw new Exception("İsim alanı boş veya sistemdeki isimle aynı");
        }

        ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository
                .findById(programmingTechnologyRequest.getProgrammingLanguageId())
                .orElseThrow(() -> new EntityNotFoundException("Programming Language Not Found"));
        programmingTechnology.setName(programmingTechnologyRequest.getName());
        programmingTechnology.setProgrammingLanguage(programmingLanguage);
        programmingTechnologyRepository.save(programmingTechnology);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("Programlama teknolojisi bulunamadı");
        }
        ProgrammingTechnology pTechnologyToDelete = programmingTechnologyRepository.getReferenceById(id);
        programmingTechnologyRepository.delete(pTechnologyToDelete);
    }

    @Override
    public GetByIdProgrammingTechnologyResponse getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("Programlama teknolojisi bulunamadı");
        }
        ProgrammingTechnology programmingTechnology = programmingTechnologyRepository.findById(id).get();
        GetByIdProgrammingTechnologyResponse responseItem = new GetByIdProgrammingTechnologyResponse();
        responseItem.setId(programmingTechnology.getId());
        responseItem.setName(programmingTechnology.getName());
        responseItem.setProgrammingLanguageId(programmingTechnology.getProgrammingLanguage().getId());
        return responseItem;
    }

    @Override
    public void update(UpdateProgrammingTechnologyRequest updateProgrammingLanguageRequest, int id)
            throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("Programlama teknolojisi bulunamadı");

        }
        if (!isNameValid(updateProgrammingLanguageRequest.getName())) {
            throw new Exception("İsim alanı boş veya sistemdeki isimle aynı");
        }
        ProgrammingTechnology programmingTechnology = programmingTechnologyRepository.getReferenceById(id);

        programmingTechnology.setName(updateProgrammingLanguageRequest.getName());

        programmingTechnologyRepository.save(programmingTechnology);

    }

    private boolean isIdExist(int id) {
        for (ProgrammingTechnology pTechnology : programmingTechnologyRepository.findAll()) {
            if (pTechnology.getId() == id) {
                return true;
            }

        }
        return false;
    }

    private boolean isNameValid(String name) throws Exception {
        if (name.isBlank()) {
            return false;
        }
        for (ProgrammingTechnology p : programmingTechnologyRepository.findAll()) {

            if (name.equalsIgnoreCase(p.getName())) {

                return false;

            }

        }
        return true;
    }

    private boolean isPLanguageIdExist(int id) {
        for (ProgrammingLanguage pLanguage : programmingLanguageRepository.findAll()) {
            if (pLanguage.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
