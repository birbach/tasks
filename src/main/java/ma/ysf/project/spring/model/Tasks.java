package ma.ysf.project.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TASKS")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NUMERO_TACHE",unique=true)
    private String numeroTache;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATE_DEBUT")
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    private Date dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SENT_TO",nullable = true, updatable = true)
    private Users sentTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SENT_BY",nullable = true, updatable = true)
    private Users sentBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUT_ID",nullable = true, updatable = true)
    private Statut statut;


}
