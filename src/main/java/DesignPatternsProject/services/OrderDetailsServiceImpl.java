package DesignPatternsProject.services;

import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.DTO.OrderDetailsDTOInfo;
import DesignPatternsProject.DTO.OrderDetailsFormDTO;
import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.OrderDetailsRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.resources.CountryResources;
import DesignPatternsProject.strategies.taxations.PolishTaxation08;
import DesignPatternsProject.strategies.taxations.TaxationType;
import DesignPatternsProject.strategies.taxations.UsaTaxation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BaseProductRepository baseProductRepository;



    @Override
    public AbstractOrderDetails createNewOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO) {
        return orderDetailsRepository.save(toOrderDetails(orderDetailsFormDTO));
    }

    @Override
    public boolean addBaseProductToOrderDetails(long orderId, long baseProductId) {

        AbstractOrderDetails orderDetails = null;
        BaseProduct baseProduct = null;
        try {
            orderDetails = orderDetailsRepository.findOne(orderId);
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find order with Id "+orderId);
        }

        try {
            baseProduct = baseProductRepository.findOne(baseProductId);
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find baseproduct with id " + baseProductId);
        }


        orderDetails.addAnyBaseProduct(baseProduct);
        orderDetailsRepository.save(orderDetails);
//        System.out.println("zapisano");
        return true;
    }

    @Override
    public void deleteBaseProductFromOrderDetails(long orderId, long baseProductId) {
        AbstractOrderDetails orderDetails = null;
        BaseProduct baseProduct = null;
        try {
            orderDetails = orderDetailsRepository.findOne(orderId);
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find order with Id "+orderId);
        }

        try {
            baseProduct = baseProductRepository.findOne(baseProductId);
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find baseproduct with id " + baseProductId);
        }

        orderDetails.getOrder().remove(baseProduct);
        orderDetailsRepository.save(orderDetails);
    }

    @Override
    public Set<AbstractOrderDetails> getAllOrdersForSelectedClient(long clientId) {
        Client client = null;
        try {
            client = (Client) personRepository.findOne(clientId);
            return client.getOrderStorage();
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find client with id " + clientId);
        }
    }

    @Override
    public OrderDetailsDTOInfo getOrderDetailsDtoInfo(long id) {
        return DTOConverter.toOrderDetailsDTOInfo(orderDetailsRepository.findOne(id));
    }

    @Override
    public AbstractOrderDetails getOrderDetails(long id) {
        return orderDetailsRepository.findOne(id);
    }

    @Override
    public AbstractOrderDetails toOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO) throws IllegalArgumentException {

        Client client = null;

        try {
            client = (Client) personRepository.findOne(orderDetailsFormDTO.getClientId());
        } catch (Exception e) {

        }

        AbstractOrderDetails orderDetails = new OrderDetails();
        orderDetails.setDate(new Date(orderDetailsFormDTO.getDate()));
        orderDetails.setClient(client);

        switch (orderDetailsFormDTO.getTaxationType()) {
            case PolishTaxation08:
                orderDetails.setTaxation(new PolishTaxation08(CountryResources.getPoland()));
                orderDetails.setTaxationType(TaxationType.PolishTaxation08);
                break;

            case PolishTaxation15:
                orderDetails.setTaxation(new PolishTaxation08(CountryResources.getPoland()));
                orderDetails.setTaxationType(TaxationType.PolishTaxation15);
                break;

            case PolishTaxation23:
                orderDetails.setTaxation(new PolishTaxation08(CountryResources.getPoland()));
                orderDetails.setTaxationType(TaxationType.PolishTaxation23);
                break;

            case UsaTaxation:
                orderDetails.setTaxation(new UsaTaxation(CountryResources.getUnitedStates()));
                orderDetails.setTaxationType(TaxationType.UsaTaxation);
                break;
        }

        return orderDetails;
    }

    @Override
    public long getNumberOfOrders() {
        return orderDetailsRepository.count();
    }
}
