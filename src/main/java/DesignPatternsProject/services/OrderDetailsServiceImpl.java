package DesignPatternsProject.services;

import DesignPatternsProject.DTO.OrderDetailsDTOInfo;
import DesignPatternsProject.DTO.OrderDetailsFormDTO;
import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.repositories.OrderDetailsRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.resources.CountryResources;
import DesignPatternsProject.strategies.taxations.PolishTaxation08;
import DesignPatternsProject.strategies.taxations.TaxationType;
import DesignPatternsProject.strategies.taxations.UsaTaxation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public OrderDetailsDTOInfo createNewOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO) {



        return null;
    }

    @Override
    public boolean addBaseProductToOrderDetails(long orderId, long baseProductId) {

        AbstractOrderDetails orderDetails = null;
        BaseProduct baseProduct = null;


        try {

        } catch (Exception e) {

        }

        try {

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public void deleteBaseProductFromOrderDetails(long orderId, long baseProductId) {

    }

    @Override
    public Set<OrderDetailsDTOInfo> getAllOrdersForSelectedClient(long clientId) {
        return null;
    }

    @Override
    public OrderDetailsDTOInfo getOrderDetails(long id) {
        return null;
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
}
