package tn.isg.soa.gestion_elections.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class AvisID implements Serializable {
    private Long idElecteur ;
    private Long idCandidat ;
}

