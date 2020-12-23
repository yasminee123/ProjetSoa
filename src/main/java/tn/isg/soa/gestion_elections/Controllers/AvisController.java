package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Avis;
import tn.isg.soa.gestion_elections.Models.AvisID;
import tn.isg.soa.gestion_elections.Services.ActiviteService;
import tn.isg.soa.gestion_elections.Services.AvisService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avis")
public class AvisController {
    @Autowired
    AvisService avisSer;
    private final Logger log= LoggerFactory.getLogger(Avis.class);

    @PostMapping("/newavis")
    public ResponseEntity<Avis> addAvis(@Valid @RequestBody Avis a)
    {
        return avisSer.AddAvis(a);
    }

    @GetMapping("/avis/{id}")
    public ResponseEntity<?> GetAvisById(@PathVariable AvisID id)
    {
        return avisSer.GetOneAvis(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Avis>> GetAllAvis()
    {
        return avisSer.GetAllAvis();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteAvis(@PathVariable AvisID id)
    {
        return avisSer.DeleteAvis(id);
    }
    // /id/id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateAvis( @Valid @RequestBody Avis a,@PathVariable AvisID id)
    {
        return avisSer.updateAvis(a,id);
    }
}
