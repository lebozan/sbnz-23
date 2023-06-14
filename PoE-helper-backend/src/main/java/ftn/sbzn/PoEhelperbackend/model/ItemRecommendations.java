package ftn.sbzn.PoEhelperbackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class ItemRecommendations {
    public boolean helmetSelected;
    public boolean bodyArmourSelected;
    public boolean glovesSelected;
    public boolean bootsSelected;
    public boolean ring1Selected;
    public boolean ring2Selected;
    public boolean amuletSelected;
    public boolean beltSelected;
    public boolean mainHandSelected;
    public boolean offHandSelected;

    public ModList quiverMods;
    public ModList amuletMods;
    public ModList ring1Mods;
    public ModList ring2Mods;
    public ModList beltMods;
    public ModList shieldMods;
    public ModList helmetMods;
    public ModList bootsMods;
    public ModList glovesMods;
    public ModList bodyMods;

    public ItemRecommendations() {
        this.helmetSelected = false;
        this.bodyArmourSelected = false;
        this.glovesSelected = false;
        this.bootsSelected = false;
        this.ring1Selected = false;
        this.ring2Selected = false;
        this.amuletSelected = false;
        this.beltSelected = false;
        this.mainHandSelected = false;
        this.offHandSelected = false;
        this.quiverMods = new ModList();
        this.amuletMods = new ModList();
        this.beltMods = new ModList();
        this.bootsMods = new ModList();
        this.helmetMods = new ModList();
        this.bodyMods = new ModList();
        this.glovesMods = new ModList();
        this.ring1Mods = new ModList();
        this.ring2Mods = new ModList();
        this.shieldMods = new ModList();
    }
}
