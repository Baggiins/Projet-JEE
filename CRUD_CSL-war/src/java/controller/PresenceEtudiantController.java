package controller;

import Entities.PresenceEtudiant;
import Sessionbean.PresenceEtudiantFacadeLocal;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;

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

@Named("presenceEtudiantController")
@SessionScoped
public class PresenceEtudiantController implements Serializable {

    private PresenceEtudiant current;
    private DataModel items = null;
    @EJB
    private PresenceEtudiantFacadeLocal ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public PresenceEtudiantController() {
    }

    public PresenceEtudiant getSelected() {
        if (current == null) {
            current = new PresenceEtudiant();
            current.setPresenceEtudiantPK(new Entities.PresenceEtudiantPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private PresenceEtudiantFacadeLocal getFacade() {
        return ejbFacade;
    }

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

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (PresenceEtudiant) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new PresenceEtudiant();
        current.setPresenceEtudiantPK(new Entities.PresenceEtudiantPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getPresenceEtudiantPK().setIdEtudiant(current.getEtudiant().getIdEtudiant());
            current.getPresenceEtudiantPK().setNbrJour(current.getCalendrier().getNbrJour());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ressources/Bundle").getString("PresenceEtudiantCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ressources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PresenceEtudiant) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getPresenceEtudiantPK().setIdEtudiant(current.getEtudiant().getIdEtudiant());
            current.getPresenceEtudiantPK().setNbrJour(current.getCalendrier().getNbrJour());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ressources/Bundle").getString("PresenceEtudiantUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ressources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (PresenceEtudiant) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ressources/Bundle").getString("PresenceEtudiantDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ressources/Bundle").getString("PersistenceErrorOccured"));
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

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public PresenceEtudiant getPresenceEtudiant(Entities.PresenceEtudiantPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = PresenceEtudiant.class)
    public static class PresenceEtudiantControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PresenceEtudiantController controller = (PresenceEtudiantController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "presenceEtudiantController");
            return controller.getPresenceEtudiant(getKey(value));
        }

        Entities.PresenceEtudiantPK getKey(String value) {
            Entities.PresenceEtudiantPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Entities.PresenceEtudiantPK();
            key.setNbrJour(Integer.parseInt(values[0]));
            key.setIdEtudiant(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(Entities.PresenceEtudiantPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNbrJour());
            sb.append(SEPARATOR);
            sb.append(value.getIdEtudiant());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PresenceEtudiant) {
                PresenceEtudiant o = (PresenceEtudiant) object;
                return getStringKey(o.getPresenceEtudiantPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PresenceEtudiant.class.getName());
            }
        }

    }

}
