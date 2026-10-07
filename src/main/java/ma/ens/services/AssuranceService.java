package ma.ens.services;

import ma.ens.models.Assurance;
import ma.ens.models.Contrat;
import ma.ens.models.StatutContrat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class AssuranceService extends AbstractFacade<Assurance>{

    public AssuranceService() {
        super(Assurance.class);
    }

    public void afficherAssuranceParType(String type) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            List<Assurance> list = session.createQuery("from Assurance a where a.type = :type", Assurance.class)
                    .setParameter("type", type).list();

            tx.commit();

            for (Assurance a : list) {
                System.out.println(a.getId() + "  " + a.getType() + "  " + a.getMontant() + "  " + a.getCouverture());
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
