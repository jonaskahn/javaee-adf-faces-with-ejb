package com.tuyendev.controller;

import com.google.common.collect.Lists;

import com.tuyendev.common.*;
import com.tuyendev.dto.RegionsDTO;
import com.tuyendev.inject.Autoinjector;

import com.tuyendev.remote.RegionsFacadeRemote;

import javax.annotation.PostConstruct;

import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.data.RichTable;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class RegionController extends BaseController {

    private final static ADFLogger logger = ADFLogger.createADFLogger(RegionController.class);

    private RegionsDTO searchDTO;
    private List<RegionsDTO> lstRegions;

    @Autoinjector(mappedName = ServiceName.EJB_MAPPED_NAME.REGIONS_FACADE)
    private RegionsFacadeRemote regionsService;

    /*Bindings*/
    private ComponentReference tbRegions;

    @PostConstruct
    private void init() {
        try {
            searchDTO = new RegionsDTO();
            lstRegions = Lists.newArrayList();
        } catch (Exception e) {
            reportError(e);
        }
    }

    public String doPreapreView() {
        try {
            RegionsDTO regionsSelected = (RegionsDTO) ((RichTable) tbRegions.getComponent()).getSelectedRowData();
            JsUtil.callJS("showModal();");
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }

    public void onCloseRegionDetail(ActionEvent actionEvent) {
        JsUtil.callJS("hideModal();");
    }
    
    public String doSearch() {
        try {
            lstRegions = regionsService.findByCondition(searchDTO);
            reportSuccess("com.tuyendev.region.label.search.result", lstRegions.size());
        } catch (Exception e) {
            reportError(e);
        }
        return null;
    }

    public void setSearchDTO(RegionsDTO searchDTO) {
        this.searchDTO = searchDTO;
    }

    public RegionsDTO getSearchDTO() {
        return searchDTO;
    }

    public void setLstRegions(List lstRegions) {
        this.lstRegions = lstRegions;
    }

    public List getLstRegions() {
        return lstRegions;
    }


    public void setTbRegions(RichTable tbRegions) {
        this.tbRegions = ComponentReference.newUIComponentReference(tbRegions);
    }

    public RichTable getTbRegions() {
        return tbRegions != null ? ((RichTable) tbRegions.getComponent()) : null;
    }

}
