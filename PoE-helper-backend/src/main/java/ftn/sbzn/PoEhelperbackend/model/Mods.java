package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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

    public Mods(Long id, ModList quiverMods, ModList amuletMods, ModList ringMods, ModList beltMods, ModList shieldMods, ModList helmetMods, ModList bootsMods, ModList glovesMods, ModList bodyMods) {
        this.id = id;
        this.quiverMods = quiverMods;
        this.amuletMods = amuletMods;
        this.ringMods = ringMods;
        this.beltMods = beltMods;
        this.shieldMods = shieldMods;
        this.helmetMods = helmetMods;
        this.bootsMods = bootsMods;
        this.glovesMods = glovesMods;
        this.bodyMods = bodyMods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModList getQuiverMods() {
        return quiverMods;
    }

    public void setQuiverMods(ModList quiverMods) {
        this.quiverMods = quiverMods;
    }

    public ModList getAmuletMods() {
        return amuletMods;
    }

    public void setAmuletMods(ModList amuletMods) {
        this.amuletMods = amuletMods;
    }

    public ModList getRingMods() {
        return ringMods;
    }

    public void setRingMods(ModList ringMods) {
        this.ringMods = ringMods;
    }

    public ModList getBeltMods() {
        return beltMods;
    }

    public void setBeltMods(ModList beltMods) {
        this.beltMods = beltMods;
    }

    public ModList getShieldMods() {
        return shieldMods;
    }

    public void setShieldMods(ModList shieldMods) {
        this.shieldMods = shieldMods;
    }

    public ModList getHelmetMods() {
        return helmetMods;
    }

    public void setHelmetMods(ModList helmetMods) {
        this.helmetMods = helmetMods;
    }

    public ModList getBootsMods() {
        return bootsMods;
    }

    public void setBootsMods(ModList bootsMods) {
        this.bootsMods = bootsMods;
    }

    public ModList getGlovesMods() {
        return glovesMods;
    }

    public void setGlovesMods(ModList glovesMods) {
        this.glovesMods = glovesMods;
    }

    public ModList getBodyMods() {
        return bodyMods;
    }

    public void setBodyMods(ModList bodyMods) {
        this.bodyMods = bodyMods;
    }
}
