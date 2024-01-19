package fr.MEGEMONT_Thibault.exam.service;

import fr.MEGEMONT_Thibault.exam.DTO.BrandDTO;
import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.exception.NotFoundCentralishException;
import fr.MEGEMONT_Thibault.exam.repository.BrandRepository;
import fr.MEGEMONT_Thibault.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService implements DAOServiceInterface<Brand> {

    private BrandRepository brandRepository;

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand getObjectById(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isEmpty()) {
            throw new NotFoundCentralishException("Brand", "id", id);
        }
        return optionalBrand.get();
    }

    public Brand persist(BrandDTO brandDTO, Long id) {
        if (id != null && brandRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                    "Brand", "id", id
            );
        }
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(brandDTO.getName());
        return brandRepository.saveAndFlush(brand);
    }
}