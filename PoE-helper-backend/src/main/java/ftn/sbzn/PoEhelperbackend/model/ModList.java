package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModList {

    public List<Mod> prefixes;

    public List<Mod> suffixes;

    public Mod findRandomPrefWithTag(String tag, ModList current) {
        Collections.shuffle(suffixes);
        for (Mod m: prefixes) {
            if (m.tags.contains(tag) && !current.prefixes.contains(m)) {
                return m;
            }
        }
        return null;
    }

    public Mod findRandomSufWithTag(String tag, ModList current) {
        Collections.shuffle(suffixes);
        for (Mod m: suffixes) {
            if (m.tags.contains(tag) && !current.suffixes.contains(m)) {
                return m;
            }
        }
        return null;
    }

    public ModList() {
        this.prefixes = new ArrayList<>(3);
        this.suffixes = new ArrayList<>(3);
    }

    public ModList(List<Mod> prefixes, List<Mod> suffixes) {
        this.prefixes = prefixes;
        this.suffixes = suffixes;
    }


    public List<Mod> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(List<Mod> prefixes) {
        this.prefixes = prefixes;
    }

    public List<Mod> getSuffixes() {
        return suffixes;
    }

    public void setSuffixes(List<Mod> suffixes) {
        this.suffixes = suffixes;
    }
}
