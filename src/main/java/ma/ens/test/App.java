package ma.ens.test;

import ma.ens.models.Assurance;
import ma.ens.models.Client;
import ma.ens.models.Contrat;
import ma.ens.models.StatutContrat;
import ma.ens.services.AssuranceService;
import ma.ens.services.ClientService;
import ma.ens.services.ContratService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        System.out.println("Bien");

        session.close();
        factory.close();

        AssuranceService as = new AssuranceService();
        ClientService cls = new ClientService();
        ContratService cs = new ContratService();

        Assurance a = new Assurance(0, "Auto", 1600.0, "Bien");
        Client c = new Client(0, "A222", "Ayouchi", "ilhame", "ilhame@mail.com", "0717631173");
        Client c1 = new Client(0, "B324", "Ayouchi", "Youssef", "Youssef@mail.com", "0587766512");
        Client c2 = new Client(0, "C465", "Ayouchi", "Amina", "Amina@mail.com", "0687769812");
        Contrat ca = new Contrat(0, LocalDate.of(2026, 1, 1), LocalDate.of(2027, 1, 1), StatutContrat.ACTIF, c, a);
        Contrat ca1 = new Contrat(0, LocalDate.of(2026, 2, 1), LocalDate.of(2026, 8, 1), StatutContrat.SUSPENDU, c, a);

        System.out.println("Creation :");
        as.create(a);
        cls.create(c);
        cls.create(c1);
        cls.create(c2);
        cs.create(ca);
        cs.create(ca1);

        System.out.println("Modification");
        c.setPrenom("Amal");
        c.setEmail("amal@gmail.com");
        cls.update(c);

        cls.delete(c1);
        System.out.println("Affichage All : ");
        for (Client cc : cls.findAll())
            System.out.println("Nom : " + cc.getNom() + "  Prenom : " + cc.getPrenom());

        System.out.println("Affichage d'assurance par type:");
        as.afficherAssuranceParType("Auto");

        System.out.println("Afficher les contrats d’un client:");
        cs.afficherContratsByCin("A222");

        System.out.println("Afficher les contrats associés à une assurance par type:");
        cs.afficherContratByType(StatutContrat.ACTIF);

        System.exit(0);
    }
}