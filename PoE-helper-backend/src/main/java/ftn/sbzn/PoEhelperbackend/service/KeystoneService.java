package ftn.sbzn.PoEhelperbackend.service;

import ftn.sbzn.PoEhelperbackend.model.Keystone;
import ftn.sbzn.PoEhelperbackend.repository.KeystoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeystoneService {

    @Autowired
    KeystoneRepository keystoneRepository;

    public Optional<Keystone> getByName(String name) {
        return keystoneRepository.findByName(name);
    }

    public Optional<Keystone> getById(Long id) {
        return keystoneRepository.findById(id);
    }

    public List<Keystone> getAll() {
        return keystoneRepository.findAll();
    }

    public Keystone save(Keystone keystone) {
        return  keystoneRepository.save(keystone);
    }

    public void delete(Keystone keystone) {
        keystoneRepository.delete(keystone);
    }
}
