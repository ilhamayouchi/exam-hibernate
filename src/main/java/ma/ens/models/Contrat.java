package ma.ens.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    @ManyToOne
    private Client client;


    @ManyToOne
    private Assurance assurance;
    public Contrat() {
    }

    public Contrat(long id, LocalDate dateDebut, LocalDate dateFin, StatutContrat statut, Client client, Assurance assurance) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.client = client;
        this.assurance = assurance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public StatutContrat getStatut() {
        return statut;
    }

    public void setStatut(StatutContrat statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }
}
