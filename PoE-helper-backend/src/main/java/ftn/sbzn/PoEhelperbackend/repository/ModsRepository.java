package ftn.sbzn.PoEhelperbackend.repository;

import ftn.sbzn.PoEhelperbackend.model.Build;
import ftn.sbzn.PoEhelperbackend.model.Mods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModsRepository extends MongoRepository<Mods, Long> {
}
