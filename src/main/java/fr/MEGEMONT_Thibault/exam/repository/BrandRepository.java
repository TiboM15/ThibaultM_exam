package fr.MEGEMONT_Thibault.exam.repository;

import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.repository.interfaces.EntityNameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, EntityNameRepository<Brand> {

    Optional<Brand> findByNameLike(String field);
}