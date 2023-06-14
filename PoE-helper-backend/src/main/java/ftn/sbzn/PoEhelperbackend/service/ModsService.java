package ftn.sbzn.PoEhelperbackend.service;

import ftn.sbzn.PoEhelperbackend.model.Mods;
import ftn.sbzn.PoEhelperbackend.repository.ModsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModsService {

    @Autowired
    private ModsRepository modsRepository;

    public Mods getAllMods() {
        return modsRepository.findAll().get(0);
    }

    public Mods saveMods(Mods m) {
        return modsRepository.save(m);
    }
}
