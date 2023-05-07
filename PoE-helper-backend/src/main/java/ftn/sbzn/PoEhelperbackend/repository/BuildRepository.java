package ftn.sbzn.PoEhelperbackend.repository;

import ftn.sbzn.PoEhelperbackend.model.Build;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends MongoRepository<Build, Long> {
}
