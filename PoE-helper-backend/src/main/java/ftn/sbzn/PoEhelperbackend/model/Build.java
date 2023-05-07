package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@Document(collection = "Builds")
public class Build {

    @Transient
    public static final String SEQUENCE_NAME = "builds_sequence";


    @Id
    private Long id;
    private WeaponType weaponType;
    private List<String> mainSkills;
    private String damageType;
    private Set<String> tags;

    public Build() {
        this.mainSkills = new ArrayList<>();
    }
}
