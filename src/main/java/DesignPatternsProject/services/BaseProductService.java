package DesignPatternsProject.services;

import DesignPatternsProject.DTO.BaseProductDTOInfo;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface BaseProductService {
    Set<BaseProductDTOInfo> getAllBaseProductDTOInfo();
}
