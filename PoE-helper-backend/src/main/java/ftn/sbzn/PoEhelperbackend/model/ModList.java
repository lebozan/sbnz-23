package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModList {

    public List<Mod> prefixes;

    public List<Mod> suffixes;

    public Mod findRandomPrefWithTag(String tag) {
        for (Mod m: prefixes) {
            if (m.tags.contains(tag)) {
                return m;
            }
        }
        return null;
    }
}
