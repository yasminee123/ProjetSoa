package tn.isg.soa.gestion_elections.Models;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Papier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long Id;
    @NonNull
    @Lob
    private byte contenu ;
    @ManyToOne
    @JoinColumn(name="IdActivite")
    private Activite act;
}
