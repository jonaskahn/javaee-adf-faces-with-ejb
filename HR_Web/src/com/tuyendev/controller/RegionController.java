package com.tuyendev.controller;

import com.google.common.collect.Lists;

import com.tuyendev.common.ServiceName;
import com.tuyendev.entities.Regions;
import com.tuyendev.inf.RegionsFacadeRemote;
import com.tuyendev.inject.Autoinjector;

import javax.annotation.PostConstruct;

import java.util.List;

import javax.faces.component.UIComponent;

import oracle.adf.share.logging.ADFLogger;

public class RegionController extends BaseController {

    private final static ADFLogger logger = ADFLogger.createADFLogger(RegionController.class);

    private Regions searchDTO;
    private List<Regions> lstRegions;

    @Autoinjector(mappedName = ServiceName.EJB_MAPPED_NAME.REGIONS_FACADE)
    private RegionsFacadeRemote regionsService;

    @PostConstruct
    private void init() {
        try {
            searchDTO = new Regions();
            lstRegions = Lists.newArrayList();
        } catch (Exception e) {
            logger.severe(e.getMessage(), e);
            reportError(e);
        }
    }

    public void setSearchDTO(Regions searchDTO) {
        this.searchDTO = searchDTO;
    }

    public Regions getSearchDTO() {
        return searchDTO;
    }

    public void setLstRegions(List lstRegions) {
        this.lstRegions = lstRegions;
    }

    public List getLstRegions() {
        return lstRegions;
    }

}
