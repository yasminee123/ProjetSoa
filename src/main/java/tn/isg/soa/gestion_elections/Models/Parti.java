package tn.isg.soa.gestion_elections.Models;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parti {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long Id;
    @NonNull
    private String Nom ;
    @NonNull
    private Long NbAdh ;
    @OneToMany(mappedBy = "parti", cascade = CascadeType.ALL)
    private Set <Candidat> Candidats =new HashSet();



}
