package ftn.sbzn.PoEhelperbackend.repository;

import ftn.sbzn.PoEhelperbackend.model.Keystone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KeystoneRepository extends MongoRepository<Keystone, Long> {
    Optional<Keystone> findByName(String name);
}
