package tn.isg.soa.gestion_elections.Models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Entity
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeLst", discriminatorType=DiscriminatorType.STRING, length=2)
public abstract class ListeElectorale{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id_lst;
    @OneToMany(mappedBy = "Liste", cascade = CascadeType.ALL)
    private Set<Candidat> Candidats = new HashSet<>();

}

