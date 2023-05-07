package ftn.sbzn.PoEhelperbackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class ItemRecommendations {
    private boolean helmetSelected;
    private boolean bodyArmourSelected;
    private boolean glovesSelected;
    private boolean bootsSelected;
    private boolean ring1Selected;
    private boolean ring2Selected;
    private boolean amuletSelected;
    private boolean beltSelected;
    private boolean mainHandSelected;
    private boolean offHandSelected;

    private List<String> helmetMods;
    private List<String> bodyArmourMods;
    private List<String> glovesMods;
    private List<String> bootsMods;
    private List<String> ring1Mods;
    private List<String> ring2Mods;
    private List<String> amuletMods;
    private List<String> beltMods;
    private List<String> mainHandMods;
    private List<String> offHandMods;

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
