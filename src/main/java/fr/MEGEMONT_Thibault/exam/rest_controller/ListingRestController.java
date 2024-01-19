package fr.MEGEMONT_Thibault.exam.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.MEGEMONT_Thibault.exam.DTO.ListingDTO;
import fr.MEGEMONT_Thibault.exam.DTO.ModelDTO;
import fr.MEGEMONT_Thibault.exam.entity.Listing;
import fr.MEGEMONT_Thibault.exam.entity.Model;
import fr.MEGEMONT_Thibault.exam.json_views.JsonViews;
import fr.MEGEMONT_Thibault.exam.repository.ListingRepository;
import fr.MEGEMONT_Thibault.exam.service.ListingService;
import fr.MEGEMONT_Thibault.exam.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/listing/")
public class ListingRestController {

    private ListingService listingService;

    @GetMapping
    @JsonView(JsonViews.ListingListView.class)
    public List<Listing> list() {
        return this.listingService.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.ListingListView.class)
    public Optional<Listing> show(@PathVariable Long id) {
        return this.listingService.findById(id);
    }

    @PostMapping
    @Validated(ValidationGroup.OnPostItem.class)
    public Listing create(@Valid @RequestBody ListingDTO listingDTO) {
        return listingService.persist(listingDTO, null);
    }

    @PutMapping("/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Listing edit(@Valid @RequestBody ListingDTO listingDTO, @PathVariable Long id) {
        return listingService.persist(listingDTO, id);
    }
}