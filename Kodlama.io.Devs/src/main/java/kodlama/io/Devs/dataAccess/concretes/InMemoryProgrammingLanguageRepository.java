// package kodlama.io.Devs.dataAccess.concretes;

// import java.util.ArrayList;
// import java.util.List;


// import org.springframework.stereotype.Repository;

// import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
// import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

// @Repository
// public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

//     List<ProgrammingLanguage> pLanguages;

//     public InMemoryProgrammingLanguageRepository() {

//         pLanguages = new ArrayList<ProgrammingLanguage>();
//         pLanguages.add(new ProgrammingLanguage(1, "Java"));
//         pLanguages.add(new ProgrammingLanguage(2, ".NET"));

//     }

//     @Override
//     public List<ProgrammingLanguage> getAll() {

//         return pLanguages;
//     }

//     @Override
//     public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) {
        
//         pLanguages.add(programmingLanguage);
//         return programmingLanguage;
//     }

//     @Override
//     public void delete(ProgrammingLanguage programmingLanguage)  {
//         pLanguages.remove(programmingLanguage);
//     }

//     @Override
//     public ProgrammingLanguage getById(int id) {

//         return pLanguages.get(id-1);
        
         
//     }

//     @Override
//     public void update(ProgrammingLanguage programmingLanguage,int id) {
//        ProgrammingLanguage pLanguage = getById(id);
//        pLanguage.setName(programmingLanguage.getName());
//     }

        
        
    

// }
