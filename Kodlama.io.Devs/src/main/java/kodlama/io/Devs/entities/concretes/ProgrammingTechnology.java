package kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "programmingTechnologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingTechnology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    
    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "programming_languages_id", referencedColumnName = "id")
    private ProgrammingLanguage programmingLanguage;
}
