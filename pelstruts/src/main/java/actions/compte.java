package actions;

import com.opensymphony.xwork2.ActionSupport;
import facade.FacadeParisStaticImpl;
import facade.exceptions.InformationsSaisiesIncoherentesException;
import facade.exceptions.UtilisateurDejaConnecteException;
import modele.Match;
import modele.Pari;
import modele.Utilisateur;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class compte extends ActionSupport implements SessionAware {
    private String login, password;
    private Utilisateur user;
    private Map<String, Object> userSession;
    private Collection<Pari> allParis;

    @Override
    public String execute() throws Exception {
        FacadeParisStaticImpl facade = new FacadeParisStaticImpl();
        try {
            Utilisateur userConnected = facade.connexion(login, password);
            user = new Utilisateur(login, password);
            userSession.put("userConnected", userConnected);
            userSession.put("facade", facade);
        } catch (UtilisateurDejaConnecteException e) {
            e.printStackTrace();
        } catch (InformationsSaisiesIncoherentesException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public void validate() {
    }

    public String logout() {
        if (userSession.get("facade") != null) {
            FacadeParisStaticImpl facade = (FacadeParisStaticImpl) userSession.get("facade");
            facade.deconnexion(login);
        }
        return "logout";
    }

    public String menu() {
        return "menu";
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        userSession = map;
    }

    public String parisouverts() throws Exception
    {
        FacadeParisStaticImpl facade = (FacadeParisStaticImpl)
                ServletActionContext.getRequest().getSession().getAttribute("facade");
        this.user = (Utilisateur) ServletActionContext.getRequest().getSession().getAttribute("userConnected");
        setAllParis(facade.getAllParis());

        return "success";
    }

    public Collection<Pari> getAllParis() {
        return allParis;
    }

    public void setAllParis(Collection<Pari> allParis) {
        this.allParis = allParis;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
