package tn.isg.soa.gestion_elections.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "Photo")
public class Candidat {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom ;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_naiss ;
    @NonNull
    private String mail;
    @NonNull
    private String fb;
    @NonNull
    private String twitter;
    @NonNull
    private String linkedin;
    @NonNull
    private Long score;

    @NonNull
    @Lob
    private byte [] photo;

    @ManyToOne
    @JoinColumn (name="IdParti" )
    private Parti parti ;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private Set<Formation> Formations = new HashSet<>();

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private Set<Poste> Postes = new HashSet<>();

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private Set<Activite> Activites = new HashSet<>();

    @OneToMany(mappedBy = "can",cascade=CascadeType.ALL)
    private Set <Avis> avisCan = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="IdListe")
    private ListeElectorale Liste;


}

