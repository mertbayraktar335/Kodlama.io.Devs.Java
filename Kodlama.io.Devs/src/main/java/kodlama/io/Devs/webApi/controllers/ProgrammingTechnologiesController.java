package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Devs.business.requests.ProgrammingTechnologies.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.ProgrammingTechnologies.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.responses.ProgrammingTechnologies.GetAllProgrammingTechnologiesResponse;
import kodlama.io.Devs.business.responses.ProgrammingTechnologies.GetByIdProgrammingTechnologyResponse;

@RestController // annotation
@RequestMapping("/api/pTechs")
public class ProgrammingTechnologiesController {
    

    private ProgrammingTechnologyService programmingTechnologyService;

    public ProgrammingTechnologiesController(ProgrammingTechnologyService programmingTechnologyService) {
        this.programmingTechnologyService = programmingTechnologyService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingTechnologiesResponse> getAll() {
        return programmingTechnologyService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateProgrammingTechnologyRequest programmingTechnologyRequest) throws Exception {
         programmingTechnologyService.add(programmingTechnologyRequest);
    }
    @DeleteMapping("/delete")
    public void delete(int id) throws Exception {
        programmingTechnologyService.delete(id);
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingTechnologyResponse getById(int id) throws Exception {
       return  programmingTechnologyService.getById(id);
    }

    @PutMapping("/update")

    public void update(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest,int id)throws Exception {
        programmingTechnologyService.update(updateProgrammingTechnologyRequest,id);
    }
}
