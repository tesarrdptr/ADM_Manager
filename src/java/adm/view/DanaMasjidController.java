package adm.view;

import adm.model.DanaMasjid;
import adm.view.util.JsfUtil;
import adm.view.util.PaginationHelper;
import adm.controller.DanaMasjidFacade;
import adm.model.DanaMasjidPK;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author RAKA
 */
@Named("danaMasjidController")
@SessionScoped
public class DanaMasjidController implements Serializable {

    private DanaMasjid current;
    private DataModel items = null;
    @EJB
    private adm.controller.DanaMasjidFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String id;
    
    private List<DanaMasjid> danaMasjidList;

    /**
     *
     */
    public DanaMasjidController() {
    }

    public List<DanaMasjid> getDanaMasjidList() {
        return danaMasjidList;
    }

    public void setDanaMasjidList(List<DanaMasjid> danaMasjidList) {
        this.danaMasjidList = danaMasjidList;
    }
    
    @PostConstruct
    public void populateReport(){
        danaMasjidList = ejbFacade.getDataPemasukan();
//        reportList = ejbFacade.getReportRekapStatus();
//        reportListSeluruh = ejbFacade.getReportSeluruh();
//        reportListZona = ejbFacade.getReportZona();
    }

    /**
     *
     * @return
     */
    public DanaMasjid getSelected() {
        if (current == null) {
            current = new DanaMasjid();
            current.setDanaMasjidPK(new adm.model.DanaMasjidPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private DanaMasjidFacade getFacade() {
        return ejbFacade;
    }

    /**
     *
     * @return
     */
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper() {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    /**
     *
     * @return
     */
    public String prepareList() {
        recreateModel();
        return "List";
    }

    /**
     *
     * @return
     */
    public String prepareView() {
        current = (DanaMasjid) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    /**
     *
     * @return
     */
    public String prepareCreate() {
        current = new DanaMasjid();
        current.setDanaMasjidPK(new adm.model.DanaMasjidPK());
        id();
        selectedItemIndex = -1;
        return "Create" ;
    }

    /**
     *
     * @return
     */
    
    public void id(){
        Random rd = new Random();
        id = String.valueOf(rd.nextInt(1000000000));
        DanaMasjidPK dm = new DanaMasjidPK();
        dm.setIdDana(id);
        current.setDanaMasjidPK(dm);
    }
    
    public String create() {
        try {
            current.getDanaMasjidPK().setIdAnggota(current.getAnggotaDKM().getIdAnggota());
            getFacade().create(current);
            JsfUtil.addSuccessMessage("Data Pemasukan berhasil ditambahkan");
            recreateModel();
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String prepareEdit() {
        current = (DanaMasjid) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    /**
     *
     * @return
     */
    public String update() {
        try {
            current.getDanaMasjidPK().setIdAnggota(current.getAnggotaDKM().getIdAnggota());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DanaMasjidUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String destroy() {
        current = (DanaMasjid) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    /**
     *
     * @return
     */
    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DanaMasjidDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    /**
     *
     * @return
     */
    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    /**
     *
     * @return
     */
    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    /**
     *
     * @return
     */
    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    /**
     *
     * @return
     */
    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    /**
     *
     * @return
     */
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    /**
     *
     * @param id
     * @return
     */
    public DanaMasjid getDanaMasjid(adm.model.DanaMasjidPK id) {
        return ejbFacade.find(id);
    }

    /**
     *
     */
    @FacesConverter(forClass = DanaMasjid.class)
    public static class DanaMasjidControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        /**
         *
         * @param facesContext
         * @param component
         * @param value
         * @return
         */
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DanaMasjidController controller = (DanaMasjidController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "danaMasjidController");
            return controller.getDanaMasjid(getKey(value));
        }

        adm.model.DanaMasjidPK getKey(String value) {
            adm.model.DanaMasjidPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new adm.model.DanaMasjidPK();
            key.setIdDana(values[0]);
            key.setIdAnggota(values[1]);
            return key;
        }

        String getStringKey(adm.model.DanaMasjidPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdDana());
            sb.append(SEPARATOR);
            sb.append(value.getIdAnggota());
            return sb.toString();
        }

        /**
         *
         * @param facesContext
         * @param component
         * @param object
         * @return
         */
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DanaMasjid) {
                DanaMasjid o = (DanaMasjid) object;
                return getStringKey(o.getDanaMasjidPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + DanaMasjid.class.getName());
            }
        }

    }

}
