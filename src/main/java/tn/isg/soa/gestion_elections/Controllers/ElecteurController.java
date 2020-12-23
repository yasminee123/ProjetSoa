package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Candidat;
import tn.isg.soa.gestion_elections.Models.Electeur;
import tn.isg.soa.gestion_elections.Services.CandidatService;
import tn.isg.soa.gestion_elections.Services.ElecteurService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/electeurs")
public class ElecteurController {

    @Autowired
    ElecteurService electeurSer;

    private final Logger log= LoggerFactory.getLogger(Electeur.class);

    @PostMapping("/newelecteur")
    public ResponseEntity<Electeur> addElecteur(@Valid @RequestBody Electeur elt)
    {
        return electeurSer.AddElecteur(elt);
    }

    @GetMapping("/electeur/{id}")
    public ResponseEntity<?> GetElecteurById(@PathVariable Long id)
    {
        return electeurSer.GetOneElecteur(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Electeur>> GetAllElecteurs()
    {
        return electeurSer.GetAllElecteurs();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteElecteur(@PathVariable Long id)
    {
        return electeurSer.DeleteElecteur(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateElecteur( @Valid @RequestBody Electeur el,@PathVariable Long id)
    {
        return electeurSer.updateElecteur(el,id);
    }


}
