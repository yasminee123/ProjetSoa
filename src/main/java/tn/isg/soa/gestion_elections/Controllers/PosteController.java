package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Formation;
import tn.isg.soa.gestion_elections.Models.Poste;
import tn.isg.soa.gestion_elections.Services.PosteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/postes")
public class PosteController {
    @Autowired
    PosteService posteSer;
    private final Logger log= LoggerFactory.getLogger(Poste.class);


    @PostMapping("/poste/{candId}/newposte")
    public ResponseEntity<Poste> addPost(@Valid @RequestBody Poste p, @PathVariable Long candId)
    {
        return posteSer.AddPoste(p,candId);
    }

    @GetMapping("/poste/{id}")
    public ResponseEntity<?> GetPosteById(@PathVariable Long id)
    {
        return posteSer.GetOnePoste(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Poste>> GetAllPostes()
    {
        return posteSer.GetAllPostes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeletePoste(@PathVariable Long id)
    { return posteSer.DeletePoste(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePoste( @Valid @RequestBody Poste p,@PathVariable Long id)
    {
        return posteSer.updatePoste(p,id);
    }
}
