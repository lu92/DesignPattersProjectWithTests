package DesignPatternsProject.services;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.BaseProductFormDTO;
import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.repositories.BaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
@Service
@Transactional
public class BaseProductServiseImpl implements BaseProductService {

    @Autowired
    private BaseProductRepository baseProductRepository;


    @Override
    public BaseProduct createBaseProduct(BaseProductFormDTO baseProductFormDTO) {
        return baseProductRepository.save(DTOConverter.toBaseProduct(baseProductFormDTO));
    }

    @Override
    public void deleteBaseProduct(long id) {
        baseProductRepository.delete(id);
    }

    @Override
    public Set<BaseProductDTOInfo> getAllBaseProductDTOInfo() {
        Set<BaseProductDTOInfo> baseProductDTOInfoSet = new HashSet<>();
        for (BaseProduct baseProduct : baseProductRepository.findAll())
            baseProductDTOInfoSet.add(DTOConverter.toBaseProductDTOInfo(baseProduct));
        return baseProductDTOInfoSet;
    }
}
