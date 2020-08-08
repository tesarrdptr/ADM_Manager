package adm.view;

import adm.model.AnggotaDKM;
import adm.view.util.JsfUtil;
import adm.view.util.PaginationHelper;
import adm.controller.AnggotaDKMFacade;
import adm.model.EventPK;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author RAKA
 */
@Named("anggotaDKMController")
@SessionScoped
public class AnggotaDKMController implements Serializable {

    private AnggotaDKM current;
    private DataModel items = null;
    @EJB
    private adm.controller.AnggotaDKMFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    private String id;
    private List<AnggotaDKM> anggotaDKMList;
    private String email;
    private String password;
    private String nama;
    private int role;
    private String pass;

    /**
     *
     */
    public AnggotaDKMController() {
    }

    public List<AnggotaDKM> getAnggotaDKMList() {
        return anggotaDKMList;
    }

    public void setAnggotaDKMList(List<AnggotaDKM> anggotaDKMList) {
        this.anggotaDKMList = anggotaDKMList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public String login() {
        try {
            boolean autentikasi = ejbFacade.getAutentikasi(email, password);
            anggotaDKMList = ejbFacade.getData(email);
            nama = anggotaDKMList.get(0).getNamaAnggota();
            role = anggotaDKMList.get(0).getRoleAnggota();

            if (autentikasi == true && role == 1) {
                return "/index.xhtml";
            } else if (autentikasi == true && role == 3) {
                return "/danaMasjid/List.xhtml";
            } else {
                JsfUtil.addSuccessMessage("Login Gagal");
                return "/loginAdmin.xhtml";
            }
        } catch (Exception e) {
            JsfUtil.addSuccessMessage("Data tidak terdaftar!");
            setEmail("");
            setPassword("");

            return "/loginAdmin.xhtml";
        }
    }
    
    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
         return "./loginAdmin.xhtml";
    }

    /**
     *
     * @return
     */
    public AnggotaDKM getSelected() {
        if (current == null) {
            current = new AnggotaDKM();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AnggotaDKMFacade getFacade() {
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
    public String prepareListForView() {
        return "List";
    }

    /**
     *
     * @return
     */
    public String prepareView() {
        current = (AnggotaDKM) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    
    public void id(){
        Random rd = new Random();
        id = String.valueOf(rd.nextInt(1000000000));
        current.setIdAnggota(id);
    }
    
    public void password(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (current.getRoleAnggota() == 1) {
            pass = "Admin@" + String.valueOf(year);
        } else if (current.getRoleAnggota() == 2) {
            pass = "Pengurus@" + String.valueOf(year);
        } else {
            pass = "Bendahara@" + String.valueOf(year);
        }
    }
    
    /**
     *
     * @return
     */
    public String prepareCreate() {
        current = new AnggotaDKM();
        selectedItemIndex = -1;
        id();
        return "Create";
    }

    /**
     *
     * @return
     */
    public String create() {
        try {
            password();
            current.setPassAnggota(pass);
            current.setStatus(1);
            getFacade().create(current);
            JsfUtil.addSuccessMessage("Data Anggota berhasil ditambahkan");
            recreateModel();
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AnggotaDKMCreated"));
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
        current = (AnggotaDKM) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    /**
     *
     * @return
     */
    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage("Data Anggota berhasil diubah");
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
        current = (AnggotaDKM) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }
    
    /**
     *
     */
    public void ubahStatus(){
        current = (AnggotaDKM) getItems().getRowData();
        if(current.getStatus() == 1){
            current.setStatus(0);
        }else if(current.getStatus() == 0){
            current.setStatus(1);
        }
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AnggotaDKMDeleted"));
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
    public AnggotaDKM getAnggotaDKM(java.lang.String id) {
        return ejbFacade.find(id);
    }

    /**
     *
     */
    @FacesConverter(forClass = AnggotaDKM.class)
    public static class AnggotaDKMControllerConverter implements Converter {

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
            AnggotaDKMController controller = (AnggotaDKMController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "anggotaDKMController");
            return controller.getAnggotaDKM(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
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
            if (object instanceof AnggotaDKM) {
                AnggotaDKM o = (AnggotaDKM) object;
                return getStringKey(o.getIdAnggota());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AnggotaDKM.class.getName());
            }
        }
        

    }
    

}
