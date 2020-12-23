package tn.isg.soa.gestion_elections.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Formation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long Id;
    @NonNull
    private String Diplome ;
    @NonNull
    private String Domaine ;
    @NonNull
    private String Lieu ;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date DateDebut ;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date DateFin ;
    @ManyToOne
    @JoinColumn(name = "IdCandidat")
    private Candidat candidat ;

}
