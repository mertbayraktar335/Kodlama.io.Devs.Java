package kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologies;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology,Integer> {
    
}
