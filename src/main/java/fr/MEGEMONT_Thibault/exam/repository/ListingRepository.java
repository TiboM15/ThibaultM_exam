package fr.MEGEMONT_Thibault.exam.repository;

import fr.MEGEMONT_Thibault.exam.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findTop12ByOrderByCreatedAtDesc();
}