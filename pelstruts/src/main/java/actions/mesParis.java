package actions;

import com.opensymphony.xwork2.ActionSupport;

import facade.FacadeParisStaticImpl;
import modele.Pari;
import modele.Utilisateur;
import org.apache.struts2.ServletActionContext;

import java.util.Collection;

public class mesParis extends ActionSupport {
    private Utilisateur user;
    private Collection<Pari> mesparis;
    private FacadeParisStaticImpl facade;
    private Pari pariAnnule;

    public mesParis() {
        this.facade = (FacadeParisStaticImpl) ServletActionContext.getRequest().getSession().getAttribute("facade");
        this.user = (Utilisateur) ServletActionContext.getRequest().getSession().getAttribute("userConnected");
    }

    public Pari getPariAnnule() {
        return pariAnnule;
    }

    public void setPariAnnule(Pari pariAnnule) {
        this.pariAnnule = pariAnnule;
    }

    public FacadeParisStaticImpl getFacade() {
        return facade;
    }

    public void setFacade(FacadeParisStaticImpl facade) {
        this.facade = facade;
    }

    public Collection<Pari> getMesparis() {
        return mesparis;
    }

    public void setMesparis(Collection<Pari> mesparis) {
        this.mesparis = mesparis;
    }


    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }


    @Override
    public String execute() throws Exception {
        mesparis = facade.getMesParis(user.getLogin());
        return "success";
    }

    public String annulerPari() throws Exception {
        Long id = Long.valueOf(ServletActionContext.getRequest().getParameter("id"));
        Pari pari = facade.getPari(id);
        setPariAnnule(pari);
        facade.annulerPari(user.getLogin(), id);
        return "success";
    }
}
