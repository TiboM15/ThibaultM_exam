package fr.MEGEMONT_Thibault.exam.service;

import fr.MEGEMONT_Thibault.exam.DTO.ListingDTO;
import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.entity.Listing;
import fr.MEGEMONT_Thibault.exam.exception.NotFoundCentralishException;
import fr.MEGEMONT_Thibault.exam.repository.ListingRepository;
import fr.MEGEMONT_Thibault.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListingService implements DAOServiceInterface<Listing> {

    private ListingRepository listingRepository;

    private ModelService modelService;

    private UserService userService;

    public List<Listing> findTop12ByOrderByCreatedAtDesc() {
        return listingRepository.findTop12ByOrderByCreatedAtDesc();
    }

    public List<Listing> findAll(){
        return listingRepository.findAll();
    }

    public Listing getObjectById(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if (optionalListing.isEmpty()) {
            throw new NotFoundCentralishException("Listing", "id", id);
        }
        return optionalListing.get();
    }

    public Optional<Listing> findById(Long id) {
        return listingRepository.findById(id);
    }

    public Listing persist(ListingDTO listingDTO, Long id) {
        if (id != null && listingRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                    "Listing", "id", id
            );
        }
        Listing listing = new Listing();
        listing.setModel(modelService.getObjectById(listingDTO.getModel_id()));
        listing.setUser(userService.getObjectById(listingDTO.getUser_id()));
        listing.setTitle(listingDTO.getTitle());
        listing.setDescription(listingDTO.getDescription());
        listing.setProducedYear(listingDTO.getProducedYear());
        listing.setMileage(listingDTO.getMileage());
        listing.setPrice(listingDTO.getPrice());
        listing.setImage(listingDTO.getImage());

        return listingRepository.saveAndFlush(listing);
    }
}