package DesignPatternsProject.services;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.ProductFormDTO;
import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.DTO.ServiceFormDTO;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.CategoryRepository;
import DesignPatternsProject.repositories.PersonRepository;
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
public class BaseProductServiceImpl implements BaseProductService {

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public BaseProduct createProduct(ProductFormDTO productFormDTO) {
        Product product = DTOConverter.toProduct(productFormDTO);
        product.setCategory(categoryRepository.findOne(productFormDTO.getCategoryId()));
        return baseProductRepository.save(product);
    }

    @Override
    public BaseProduct createService(ServiceFormDTO serviceFormDTO) {
        DesignPatternsProject.entities.productsAndServices.Service service = DTOConverter.toService(serviceFormDTO);
        service.setCategory(categoryRepository.findOne(serviceFormDTO.getCategoryId()));
        service.setWorker(personRepository.findOne(serviceFormDTO.getWorkerId()));
        return baseProductRepository.save(service);
    }

    @Override
    public void deleteBaseProduct(long id) {
        baseProductRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        baseProductRepository.deleteAll();
    }

    @Override
    public Set<BaseProduct> getAllBaseProducts() {
        Set<BaseProduct> allBaseProducts = new HashSet<>();
        for (BaseProduct baseProduct : baseProductRepository.findAll())
            allBaseProducts.add(baseProduct);
        return allBaseProducts;
    }

    @Override
    public Set<BaseProductDTOInfo> getAllBaseProductDTOInfo() {
        Set<BaseProductDTOInfo> baseProductDTOInfoSet = new HashSet<>();
        for (BaseProduct baseProduct : baseProductRepository.findAll())
            baseProductDTOInfoSet.add(DTOConverter.toBaseProductDTOInfo(baseProduct));
        return baseProductDTOInfoSet;
    }

    @Override
    public Set<Product> getAllProducts() {
        Set<Product> allProducts = new HashSet<>();
        for (BaseProduct baseProduct : baseProductRepository.findAll())
            if (baseProduct instanceof Product)
                allProducts.add((Product) baseProduct);

        return allProducts;
    }

    @Override
    public Set<DesignPatternsProject.entities.productsAndServices.Service> getAllServices() {
        Set<DesignPatternsProject.entities.productsAndServices.Service> allServices = new HashSet<>();
        for (BaseProduct baseProduct : baseProductRepository.findAll())
            if (baseProduct instanceof DesignPatternsProject.entities.productsAndServices.Service)
                allServices.add((DesignPatternsProject.entities.productsAndServices.Service) baseProduct);
        return allServices;
    }

    @Override
    public long getNumberOfBaseProducts() {
        return baseProductRepository.count();
    }

    @Override
    public long getNumberOfProducts() {
        return getAllProducts().size();
    }

    @Override
    public long getNumberOfServices() {
        return getAllServices().size();
    }
}
