package ftn.sbzn.PoEhelperbackend.mapper;

import ftn.sbzn.PoEhelperbackend.dto.GemDTO;
import ftn.sbzn.PoEhelperbackend.dto.KeystoneDataDTO;
import ftn.sbzn.PoEhelperbackend.model.Keystone;
import ftn.sbzn.PoEhelperbackend.model.SkillGem;

public class DataMapper {

    public GemDTO gemToDTO(SkillGem gem) {
        return new GemDTO(gem.getName(), gem.getClassId(), gem.getGemTags());
    }

    public KeystoneDataDTO keystoneToDTO(Keystone keystone) {
        return new KeystoneDataDTO(keystone.getName());
    }
}
