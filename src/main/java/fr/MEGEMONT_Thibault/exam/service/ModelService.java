package fr.MEGEMONT_Thibault.exam.service;

import fr.MEGEMONT_Thibault.exam.DTO.BrandDTO;
import fr.MEGEMONT_Thibault.exam.DTO.ModelDTO;
import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.entity.Model;
import fr.MEGEMONT_Thibault.exam.exception.NotFoundCentralishException;
import fr.MEGEMONT_Thibault.exam.repository.BrandRepository;
import fr.MEGEMONT_Thibault.exam.repository.ModelRepository;
import fr.MEGEMONT_Thibault.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService implements DAOServiceInterface<Model> {

    private ModelRepository modelRepository;

    private BrandService brandService;

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model getObjectById(Long id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isEmpty()) {
            throw new NotFoundCentralishException("Model", "id", id);
        }
        return optionalModel.get();
    }

    public Model persist(ModelDTO modelDTO, Long id) {
        if (id != null && modelRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                    "Model", "id", id
            );
        }
        Model model = new Model();
        model.setId(id);
        model.setName(modelDTO.getName());
        model.setBrand(brandService.getObjectById(modelDTO.getBrand_id()));
        return modelRepository.saveAndFlush(model);
    }
}