package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.ProgrammingLanguages.CreateProgrammingLangugageRequest;
import kodlama.io.Devs.business.requests.ProgrammingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.ProgrammingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.ProgrammingLanguages.GetByIdProgrammingLanguageResponse;

@RestController // annotation
@RequestMapping("/api/pLangs")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return programmingLanguageService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateProgrammingLangugageRequest programmingLanguageRequest) throws Exception {
         programmingLanguageService.add(programmingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(int id) throws Exception {
        programmingLanguageService.delete(id);
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingLanguageResponse getById(int id) throws Exception {
        return programmingLanguageService.getById(id);
    }

    @PutMapping("/update")

    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest,int id)throws Exception {
        programmingLanguageService.update(updateProgrammingLanguageRequest,id);
    }

}
