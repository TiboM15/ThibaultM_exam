package fr.MEGEMONT_Thibault.exam.repository;

import fr.MEGEMONT_Thibault.exam.entity.Model;
import fr.MEGEMONT_Thibault.exam.repository.interfaces.EntityNameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>, EntityNameRepository<Model> {

    Optional<Model> findByNameLike(String field);
}