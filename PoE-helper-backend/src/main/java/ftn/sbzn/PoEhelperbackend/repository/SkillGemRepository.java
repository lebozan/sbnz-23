package ftn.sbzn.PoEhelperbackend.repository;

import ftn.sbzn.PoEhelperbackend.model.SkillGem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillGemRepository extends MongoRepository<SkillGem, Long> {

    Optional<SkillGem> findByName(String name);
    List<SkillGem> findAllByClassId(String classId);
}
