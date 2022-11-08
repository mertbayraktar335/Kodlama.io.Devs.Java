package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.ProgrammingTechnologies.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.ProgrammingTechnologies.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.responses.ProgrammingTechnologies.GetAllProgrammingTechnologiesResponse;
import kodlama.io.Devs.business.responses.ProgrammingTechnologies.GetByIdProgrammingTechnologyResponse;


public interface ProgrammingTechnologyService {
    List<GetAllProgrammingTechnologiesResponse> getAll();

    void add(CreateProgrammingTechnologyRequest programmingTechnologyRequest) throws Exception;

    void delete(int id) throws Exception;

    GetByIdProgrammingTechnologyResponse getById(int id) throws Exception;

    void update(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest, int id) throws Exception;

    
}
