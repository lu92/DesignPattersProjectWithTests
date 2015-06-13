package DesignPatternsProject.services;

import DesignPatternsProject.DTO.OrderDetailsDTOInfo;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface OrderDetailsService {

    OrderDetailsDTOInfo createNewOrderDetails();

    boolean addBaseProductToOrderDetails(long orderId, long baseProductId);
    void deleteBaseProductFromOrderDetails(long orderId, long baseProductId);



    Set<OrderDetailsDTOInfo> getAllOrdersForSelectedClient(long clientId);
    OrderDetailsDTOInfo getOrderDetails(long id);
}
