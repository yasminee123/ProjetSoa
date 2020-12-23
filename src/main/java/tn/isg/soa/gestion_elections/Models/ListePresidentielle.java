package tn.isg.soa.gestion_elections.Models;


import lombok.*;
import javax.persistence.*;
    @Entity
    @Data
    @ToString
    @NoArgsConstructor
    @RequiredArgsConstructor
    @DiscriminatorValue("LP")
    public class ListePresidentielle extends ListeElectorale {
        @NonNull
        private Long NbCandidats;
    }


