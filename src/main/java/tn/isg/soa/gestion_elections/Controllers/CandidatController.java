package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Candidat;
import tn.isg.soa.gestion_elections.Services.CandidatService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/candidats")
public class CandidatController {

    @Autowired
    CandidatService candidatSer;

    private final Logger log= LoggerFactory.getLogger(Candidat.class);

   /*@PostMapping("/parti/{idParti}/liste/{idListe}/newcandidat")
    public ResponseEntity<Candidat> addCandidat(@Valid @RequestBody Candidat c, @PathVariable Long idParti,@PathVariable Long idListe)
    { return candidatSer.AddCandidat(c,idParti,idListe);}*/

    @GetMapping("/candidat/{id}")
    public ResponseEntity<?> GetCandidatById(@PathVariable Long id)
    {
        return candidatSer.GetOneCandidat(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidat>> GetAllCandidats()
    {
        return candidatSer.GetAllCandidats();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteCandidat(@PathVariable Long id)
    {
        return candidatSer.DeleteCandidat(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCandidat( @Valid @RequestBody Candidat c,@PathVariable Long id)
    {
        return candidatSer.updateCandidat(c,id);
    }





}
