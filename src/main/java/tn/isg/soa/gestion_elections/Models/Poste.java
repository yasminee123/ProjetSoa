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
public class Poste {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String titre ;
    @NonNull
    private String lieu ;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_debut ;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date_fin ;
    @ManyToOne
    @JoinColumn(name="IdCandidat")
    private Candidat candidat ;
}

