package tn.isg.soa.gestion_elections.Models;
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

public class Electeur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String nom ;
    @NonNull
    private String prenom;
    @NonNull
    private Date date_naiss;
    @NonNull
    private String mail ;
    @NonNull
    private String mdp;
    @NonNull
    private Boolean role;
    @OneToMany(mappedBy = "elec",cascade=CascadeType.ALL)
    private Set <Avis> avisElec = new HashSet<>();
}
