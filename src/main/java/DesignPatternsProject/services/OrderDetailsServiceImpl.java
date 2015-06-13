package DesignPatternsProject.services;

import DesignPatternsProject.DTO.OrderDetailsDTOInfo;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Override
    public OrderDetailsDTOInfo createNewOrderDetails() {
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
}
