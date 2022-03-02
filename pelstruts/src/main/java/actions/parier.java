package actions;

import com.opensymphony.xwork2.ActionSupport;
import facade.FacadeParisStaticImpl;
import modele.Pari;
import modele.Utilisateur;
import org.apache.struts2.ServletActionContext;

public class parier extends ActionSupport {
    private Utilisateur user;
    private Pari pari;
    private String[] listVerdict;
    private double montant;
    private String vainqueur;
    private Long id;

    public String getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(String vainqueur) {
        this.vainqueur = vainqueur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public parier()
    {
        String myid = ServletActionContext.getRequest().getParameter("id");
        if (myid != null) {
            id = Long.valueOf(myid);
            ServletActionContext.getRequest().getSession().setAttribute("id", myid);

        }
        else {
            id = (Long) ServletActionContext.getRequest().getSession().getAttribute("id");
        }
        user = (Utilisateur) ServletActionContext.getRequest().getSession().getAttribute("userConnected");
        FacadeParisStaticImpl facade = (FacadeParisStaticImpl)
                ServletActionContext.getRequest().getSession().getAttribute("facade");
        pari = facade.getPari(id);
        listVerdict = new String[] {"nul", pari.getMatch().getEquipe1(), pari.getMatch().getEquipe2()};
        ServletActionContext.getRequest().getSession().setAttribute("listVerdict", listVerdict);
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Pari getPari() {
        return pari;
    }

    public void setPari(Pari pari) {
        this.pari = pari;
    }

    public String[] getListVerdict() {
        return listVerdict;
    }

    public void setListVerdict(String[] listVerdict) {
        this.listVerdict = listVerdict;
    }


    @Override
    public String execute() throws Exception {
        id = Long.valueOf(ServletActionContext.getRequest().getParameter("id"));
        ServletActionContext.getRequest().getSession().setAttribute("id", id);

        listVerdict = (String[]) ServletActionContext.getRequest().getSession().getAttribute("listVerdict");
        return "success";
    }

    public String confirmationPari() throws Exception {
        id = (Long) ServletActionContext.getRequest().getSession().getAttribute("id");
        vainqueur = ServletActionContext.getRequest().getParameter("vainqueur");

        montant = Double.parseDouble(ServletActionContext.getRequest().getParameter("montant"));
        System.out.println(vainqueur);
        System.out.println(montant);
        FacadeParisStaticImpl facade = (FacadeParisStaticImpl)
                ServletActionContext.getRequest().getSession().getAttribute("facade");
        facade.parier(user.getLogin(), id, vainqueur, montant);
        return "success";
    }
}
