package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Parti;
import tn.isg.soa.gestion_elections.Services.ListeLegislativeService;
import tn.isg.soa.gestion_elections.Services.PartiService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partis")
public class PartiController {
    @Autowired
    PartiService partiSer;
    private final Logger log= LoggerFactory.getLogger(Parti.class);

    @PostMapping("/newparti")
    public ResponseEntity<Parti> addParti(@Valid @RequestBody Parti p)
    {
        return partiSer.AddParti(p);
    }

    @GetMapping("/parti/{id}")
    public ResponseEntity<?> GetPartiById(@PathVariable Long id)
    {
        return partiSer.GetOneParti(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Parti>> GetAllParti()
    {
        return  partiSer.GetAllParti();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteParti(@PathVariable Long id)
    { return partiSer.DeleteParti(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateListe( @Valid @RequestBody Parti p,@PathVariable Long id)
    {
        return partiSer.updateParti(p,id);
    }
}
