package DesignPatternsProject.services;

import DesignPatternsProject.DTO.OrderDetailsDTOInfo;
import DesignPatternsProject.DTO.OrderDetailsFormDTO;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface OrderDetailsService {

    OrderDetailsDTOInfo createNewOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO);

    boolean addBaseProductToOrderDetails(long orderId, long baseProductId);
    void deleteBaseProductFromOrderDetails(long orderId, long baseProductId);



    Set<OrderDetailsDTOInfo> getAllOrdersForSelectedClient(long clientId);
    OrderDetailsDTOInfo getOrderDetails(long id);
    AbstractOrderDetails toOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO) throws IllegalArgumentException;

}
