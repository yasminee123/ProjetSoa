package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Electeur;
import tn.isg.soa.gestion_elections.Models.Formation;
import tn.isg.soa.gestion_elections.Services.ElecteurService;
import tn.isg.soa.gestion_elections.Services.FormationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {
    @Autowired
    FormationService formationSer;

    private final Logger log= LoggerFactory.getLogger(Formation.class);

    @PostMapping("/formation/{candId}/newformation")
    public ResponseEntity<Formation> addFormation(@Valid @RequestBody Formation f,@PathVariable Long candId)
    {
        return formationSer.AddFormation(f,candId);
    }

    @GetMapping("/formation/{id}")
    public ResponseEntity<?> GetFormationById(@PathVariable Long id)
    {
        return formationSer.GetOneFormation(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Formation>> GetAllFormation()
    {
        return formationSer.GetAllFormations();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteFormation(@PathVariable Long id)
    { return formationSer.DeleteFormation(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFormation( @Valid @RequestBody Formation f,@PathVariable Long id)
    {
        return formationSer.updateFormation(f,id);
    }
}
