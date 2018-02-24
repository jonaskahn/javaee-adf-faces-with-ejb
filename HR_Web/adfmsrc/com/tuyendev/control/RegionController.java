package com.tuyendev.control;

import com.google.common.collect.Lists;

import com.tuyendev.common.*;
import com.tuyendev.fw.*;
import com.tuyendev.controller.BaseController;
import com.tuyendev.dto.RegionsDTO;
import com.tuyendev.exception.LogicException;
import com.tuyendev.inject.Autoinjector;

import com.tuyendev.remote.RegionsFacadeRemote;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.render.ClientEvent;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class RegionController extends BaseController {

    private final static ADFLogger logger = ADFLogger.createADFLogger(RegionController.class);

    private RegionsDTO searchDTO;
    private RegionsDTO viewDTO;
    private RegionsDTO editDTO;
    private RegionsDTO delDTO;
    private String mode;
    private List<RegionsDTO> lstRegions;
    private List<RegionsDTO> lstRegionsDel;

    @Autoinjector(mappedName = Constant.EJB_MAPPED_NAME.REGIONS_FACADE)
    private RegionsFacadeRemote regionsService;

    /*Bindings*/
    private ComponentReference tbRegions;
    private ComponentReference popupDetail;
    private ComponentReference popupAddOrEdit;
    private ComponentReference popupConfirmDel;


    @PostConstruct
    private void init() {
        try {
            searchDTO = new RegionsDTO();
            viewDTO = new RegionsDTO();
            delDTO = null;
            lstRegions = Lists.newArrayList();
            
        } catch (Exception e) {
            reportError(e);
        }
    }

    public void prepareView(ClientEvent clientEvent) {
        try {
            viewDTO = (RegionsDTO) ((RichTable) tbRegions.getComponent()).getSelectedRowData();
            openExtendedPopup(popupDetail);
        } catch (Exception e) {
            reportError(e, logger);
        }
    }
    
    public String onView(BigDecimal regionId) {
        try {
            viewDTO = regionsService.findOne(regionId);
            openExtendedPopup(popupDetail);
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    public String preEdit(BigDecimal regionId) {
        try {
            mode = "edit";
            editDTO = regionsService.findOne(regionId);
            openExtendedPopup(popupAddOrEdit);
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    public String preDelMulti(){
        try {
            lstRegionsDel = Lists.newArrayList();
            if(DataUtil.isNullOrEmpty(lstRegions)) return null;
            for(RegionsDTO dto: lstRegions){
                if(dto.isSelected()){
                    lstRegionsDel.add(dto);
                }
            }
            if(DataUtil.isNullOrEmpty(lstRegionsDel)) throw new LogicException("","com.tuyendev.common.message.table.selectedvalue.empty");
            openExtendedPopup(popupConfirmDel);
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    public String preAdd() {
        try {
            mode = "add";
            editDTO = new RegionsDTO();
            openExtendedPopup(popupAddOrEdit);
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    public String onAddOrUpdate() {
        try {
            if(DataUtil.isNullOrZero(editDTO.getRegionId())){
                //do create
                regionsService.doCreateOrUpdate(editDTO);
                editDTO = new RegionsDTO();
                reportSuccess("com.tuyendev.country.message.create.success", editDTO.getRegionName());
            }else {
                //do update
                regionsService.doCreateOrUpdate(editDTO);
                reportSuccess("com.tuyendev.country.message.edit.success", editDTO.getRegionName());
            }
            lstRegions = regionsService.findByCondition(searchDTO);
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    public String onAddOrUpdateClose() {
        try {
            if(DataUtil.isNullOrZero(editDTO.getRegionId())){
                //do create
                regionsService.doCreateOrUpdate(editDTO);
                reportSuccess("com.tuyendev.country.message.create.success", editDTO.getRegionName());
            }else {
                //do update
                regionsService.doCreateOrUpdate(editDTO);
                reportSuccess("com.tuyendev.country.message.edit.success", editDTO.getRegionName());
            }
            lstRegions = regionsService.findByCondition(searchDTO);
            closePopup(popupAddOrEdit);
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    public String preDel(RegionsDTO dto) {
        try {
            delDTO = dto;
        } catch (Exception e) {
            reportError(e, logger);
        }
        return null;
    }
    
    
    public void onOKDel(DialogEvent event) {
        try {
            
            regionsService.delete(delDTO);
            reportSuccess("com.tuyendev.country.message.del.success", delDTO.getRegionName());
            lstRegions = regionsService.findByCondition(searchDTO);
        } catch (Exception e) {
            reportError(e, logger);
        } 
    }
    
    public void onOKDelMutil(DialogEvent event) {
        try {
            String names = regionsService.doDelete(lstRegionsDel);
            reportSuccess("com.tuyendev.country.message.del.success",names);
            lstRegions = regionsService.findByCondition(searchDTO);
        } catch (Exception e) {
            reportError(e, logger);
        } 
    }
    
    public void onCloseRegionDetail(ActionEvent actionEvent) {
        closePopup(popupDetail);
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

    public void setViewDTO(RegionsDTO viewDTO) {
        this.viewDTO = viewDTO;
    }

    public RegionsDTO getViewDTO() {
        return viewDTO;
    }

    public void setEditDTO(RegionsDTO editDTO) {
        this.editDTO = editDTO;
    }

    public RegionsDTO getEditDTO() {
        return editDTO;
    }

    public void setPopupDetail(RichPopup popupDetail) {
        this.popupDetail = ComponentReference.newUIComponentReference(popupDetail);
    }

    public RichPopup getPopupDetail() {
        return popupDetail != null ? ((RichPopup) popupDetail.getComponent()) : null;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setPopupAddOrEdit(RichPopup popupAddOrEdit) {
        this.popupAddOrEdit = ComponentReference.newUIComponentReference(popupAddOrEdit);
    }

    public RichPopup getPopupAddOrEdit() {
        return popupAddOrEdit != null ? ((RichPopup) popupAddOrEdit.getComponent()) : null;
    }


    public void setPopupConfirmDel(RichPopup popupConfirmDel) {
        this.popupConfirmDel = ComponentReference.newUIComponentReference(popupConfirmDel);
    }

    public RichPopup getPopupConfirmDel() {
        return popupConfirmDel != null ? ((RichPopup) popupConfirmDel.getComponent()) : null;
    }

}
