package kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguages;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {


    boolean existsByNameIgnoreCase(String name);
}
