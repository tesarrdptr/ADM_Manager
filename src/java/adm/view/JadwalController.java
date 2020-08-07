package adm.view;

import adm.model.Jadwal;
import adm.view.util.JsfUtil;
import adm.view.util.PaginationHelper;
import adm.controller.JadwalFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
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
@Named("jadwalController")
@SessionScoped
public class JadwalController implements Serializable {

    private Jadwal current;
    private DataModel items = null;
    @EJB
    private adm.controller.JadwalFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    /**
     *
     */
    public JadwalController() {
    }

    /**
     *
     * @return
     */
    public Jadwal getSelected() {
        if (current == null) {
            current = new Jadwal();
            current.setJadwalPK(new adm.model.JadwalPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private JadwalFacade getFacade() {
        return ejbFacade;
    }

    /**
     *
     * @return
     */
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

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
        current = (Jadwal) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    /**
     *
     * @return
     */
    public String prepareCreate() {
        current = new Jadwal();
        current.setJadwalPK(new adm.model.JadwalPK());
        selectedItemIndex = -1;
        return "Create";
    }

    /**
     *
     * @return
     */
    public String create() {
        try {
            current.setStatus(1);
            current.getJadwalPK().setIdImam(current.getImam().getIdImam());
            current.getJadwalPK().setIdAnggota(current.getAnggotaDKM().getIdAnggota());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("JadwalCreated"));
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
        current = (Jadwal) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    /**
     *
     * @return
     */
    public String update() {
        try {
            current.getJadwalPK().setIdImam(current.getImam().getIdImam());
            current.getJadwalPK().setIdAnggota(current.getAnggotaDKM().getIdAnggota());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("JadwalUpdated"));
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
        current = (Jadwal) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("JadwalDeleted"));
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
    public Jadwal getJadwal(adm.model.JadwalPK id) {
        return ejbFacade.find(id);
    }

    /**
     *
     */
    @FacesConverter(forClass = Jadwal.class)
    public static class JadwalControllerConverter implements Converter {

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
            JadwalController controller = (JadwalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "jadwalController");
            return controller.getJadwal(getKey(value));
        }

        adm.model.JadwalPK getKey(String value) {
            adm.model.JadwalPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new adm.model.JadwalPK();
            key.setIdImam(Integer.parseInt(values[0]));
            key.setIdAnggota(values[1]);
            return key;
        }

        String getStringKey(adm.model.JadwalPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdImam());
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
            if (object instanceof Jadwal) {
                Jadwal o = (Jadwal) object;
                return getStringKey(o.getJadwalPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Jadwal.class.getName());
            }
        }

    }

}
