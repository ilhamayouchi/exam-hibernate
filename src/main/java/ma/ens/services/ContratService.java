package ma.ens.services;

import ma.ens.models.Contrat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import ma.ens.models.StatutContrat;
import java.util.List;

public class ContratService extends AbstractFacade<Contrat>{

    public ContratService() {
        super(Contrat.class);
    }

    public void afficherContratsByCin(String cin) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            List<Contrat> list = session.createQuery("from Contrat c where c.client.cin = :cin", Contrat.class)
                    .setParameter("cin", cin).list();

            tx.commit();

            for (Contrat c : list) {
                System.out.println(c.getId() + "  " + c.getDateDebut() + "  " + c.getDateFin() + "  " + c.getStatut());
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void afficherContratByType(StatutContrat statut) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            List<Contrat> list = session.createQuery("from Contrat c where c.statut = :statut", Contrat.class)
                    .setParameter("statut", statut).list();

            tx.commit();

            for (Contrat c : list) {
                System.out.println(c.getId() + "  " + c.getDateDebut() + "  " + c.getDateFin() + "  " + c.getStatut());
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
