package tn.isg.soa.gestion_elections.Models;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@DiscriminatorValue("LL")

public class ListeLegislative extends ListeElectorale{
    @NonNull
    private String Type;
    @NonNull
    private String Region;
    @NonNull
    private Long Partis[] ;
    @NonNull
    private Long TeteDeListe;
    @NonNull
    private Long Score;}
