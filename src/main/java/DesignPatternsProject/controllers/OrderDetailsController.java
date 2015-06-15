package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.PodatkiDTO;
import DesignPatternsProject.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by lucjan on 14.06.15.
 */
@RestController
@RequestMapping(value = "/orderDetails")
public class OrderDetailsController {

    private Logger logger = Logger.getLogger(String.valueOf(this));


    @Autowired
    private OrderDetailsService orderDetailsService;


    @RequestMapping(value = "/obliczPodatek",method = RequestMethod.POST)
    public Double obliczPodatek(@RequestBody PodatkiDTO podatkiDTO){
        logger.info("typ podatku"+String.valueOf(podatkiDTO.getTaxationType()));
        logger.info("wielkosc zamuwiaenia "+ podatkiDTO.getProductDTOInfos().size());
        for (BaseProductDTOInfo baseProductDTOInfo : podatkiDTO.getProductDTOInfos())
            logger.info(baseProductDTOInfo.toString());
//        orderDetailsService.createNewOrderDetails()


        return Double.valueOf(2);
    }


}
