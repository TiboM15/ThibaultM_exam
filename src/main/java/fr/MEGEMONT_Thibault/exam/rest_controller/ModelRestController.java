package fr.MEGEMONT_Thibault.exam.rest_controller;

import fr.MEGEMONT_Thibault.exam.DTO.BrandDTO;
import fr.MEGEMONT_Thibault.exam.DTO.ModelDTO;
import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.entity.Model;
import fr.MEGEMONT_Thibault.exam.json_views.JsonViews;
import fr.MEGEMONT_Thibault.exam.repository.ModelRepository;
import fr.MEGEMONT_Thibault.exam.service.ModelService;
import fr.MEGEMONT_Thibault.exam.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/model/")
public class ModelRestController {

    private ModelRepository modelRepository;

    private ModelService modelService;


    @GetMapping
    public List<Model> list() {
        return this.modelRepository.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Model> show(@PathVariable String field) {
        try {
            Long id = Long.parseLong(field);
            return this.modelRepository.findById(id);
        } catch (NumberFormatException e) {
            return this.modelRepository.findByNameLike(field);
        }
    }

    @PostMapping
    @Validated(ValidationGroup.OnPostItem.class)
    public Model create(@Valid @RequestBody ModelDTO modelDTO) {
        return modelService.persist(modelDTO, null);
    }

    @PutMapping("/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Model edit(@Valid @RequestBody ModelDTO modelDTO, @PathVariable Long id) {
        return modelService.persist(modelDTO, id);
    }


}