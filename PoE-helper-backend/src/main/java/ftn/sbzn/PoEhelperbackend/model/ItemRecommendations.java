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

    public List<ModList> quiverMods;
    public List<ModList> amuletMods;
    public List<ModList> ringMods;
    public List<ModList> beltMods;
    public List<ModList> shieldMods;
    public List<ModList> helmetMods;
    public List<ModList> bootsMods;
    public List<ModList> glovesMods;
    public List<ModList> bodyMods;

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
    }
}
