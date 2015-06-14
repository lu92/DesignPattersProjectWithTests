package DesignPatternsProject.services;

import DesignPatternsProject.DTO.OrderDetailsDTOInfo;
import DesignPatternsProject.DTO.OrderDetailsFormDTO;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */

public interface OrderDetailsService {

    AbstractOrderDetails createNewOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO);

    boolean addBaseProductToOrderDetails(long orderId, long baseProductId);
    void deleteBaseProductFromOrderDetails(long orderId, long baseProductId);



    Set<AbstractOrderDetails> getAllOrdersForSelectedClient(long clientId);
    OrderDetailsDTOInfo getOrderDetailsDtoInfo(long id);
    AbstractOrderDetails getOrderDetails(long id);
    AbstractOrderDetails toOrderDetails(OrderDetailsFormDTO orderDetailsFormDTO) throws IllegalArgumentException;
    long getNumberOfOrders();
}
