package ftn.sbzn.PoEhelperbackend.service;

import ftn.sbzn.PoEhelperbackend.model.Build;
import ftn.sbzn.PoEhelperbackend.model.Keystone;
import ftn.sbzn.PoEhelperbackend.repository.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildService {


    @Autowired
    BuildRepository buildRepository;


    public Optional<Build> getById(Long id) {
        return buildRepository.findById(id);
    }

    public List<Build> getAll() {
        return buildRepository.findAll();
    }

    public Build save(Build build) {
        return  buildRepository.save(build);
    }

    public void delete(Build build) {
        buildRepository.delete(build);
    }

}
