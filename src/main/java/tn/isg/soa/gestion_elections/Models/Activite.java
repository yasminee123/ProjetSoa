package tn.isg.soa.gestion_elections.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Activite {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String type;
    @NonNull
    private String duree;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    @NonNull
    private String lieu;
    @ManyToOne
    @JoinColumn(name="IdCandidat")
    private Candidat candidat ;

    @OneToMany(mappedBy = "act",cascade=CascadeType.ALL)
    private Set<Lien> liens = new HashSet<>();
    @OneToMany(mappedBy = "act",cascade=CascadeType.ALL)
    private Set<Papier> papiers = new HashSet<>();
    @OneToMany(mappedBy = "act",cascade=CascadeType.ALL)
    private Set<Photo> photos = new HashSet<>();
    @OneToMany(mappedBy = "act",cascade=CascadeType.ALL)
    private Set<Texte> textes = new HashSet<>();
    @OneToMany(mappedBy = "act",cascade=CascadeType.ALL)
    private Set<Video> videos = new HashSet<>();
}
