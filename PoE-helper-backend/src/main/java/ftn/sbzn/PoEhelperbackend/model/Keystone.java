package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Keystones")
public class Keystone {

    @Transient
    public static final String SEQUENCE_NAME = "keystones_sequence";

    @Id
    private Long id;
    private String name;

    public Keystone(String name) {
        this.name = name;
    }
}
