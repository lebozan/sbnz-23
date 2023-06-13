package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "Mods")
public class Mods {
    @Id
    private Long id;

    private ModList quiverMods;
    private ModList amuletMods;
    private ModList ringMods;
    private ModList beltMods;
    private ModList shieldMods;
    private ModList helmetMods;
    private ModList bootsMods;
    private ModList glovesMods;
    private ModList bodyMods;

}
