package fr.MEGEMONT_Thibault.exam.rest_controller;

import fr.MEGEMONT_Thibault.exam.DTO.BrandDTO;
import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.repository.BrandRepository;
import fr.MEGEMONT_Thibault.exam.service.BrandService;
import fr.MEGEMONT_Thibault.exam.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brand/")
public class BrandRestController {

    private BrandService brandService;

    private BrandRepository brandRepository;

    @GetMapping
    public List<Brand> list() {
        return this.brandRepository.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Brand> show(@PathVariable String field) {
        try {
            Long id = Long.parseLong(field);
            return this.brandRepository.findById(id);
        } catch (NumberFormatException e) {
            return this.brandRepository.findByNameLike(field);
        }
    }

    @PostMapping
    @Validated(ValidationGroup.OnPostItem.class)
    public Brand create(@Valid @RequestBody BrandDTO brandDTO) {
        return brandService.persist(brandDTO, null);
    }

    @PutMapping("/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Brand edit(@Valid @RequestBody BrandDTO brandDTO, @PathVariable Long id) {
        return brandService.persist(brandDTO, id);
    }

}