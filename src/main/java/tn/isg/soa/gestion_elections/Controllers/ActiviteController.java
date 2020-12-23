package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Candidat;
import tn.isg.soa.gestion_elections.Services.ActiviteService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/activites")
public class ActiviteController {

    @Autowired
    ActiviteService activiteSer;
    private final Logger log= LoggerFactory.getLogger(Activite.class);

    @PostMapping("/candidat/{candId}/newactivite")
    public ResponseEntity<Activite> addActivity(@Valid @RequestBody Activite a ,@PathVariable Long candId)
    {
        return activiteSer.AddActivite(a,candId);
    }

    @GetMapping("/activite/{id}")
    public ResponseEntity<?> GetActiviteById(@PathVariable Long id)
    {
        return activiteSer.GetOneActivity(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Activite>> GetAllActivities()
    {
        return activiteSer.GetAllActivities();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteActivity(@PathVariable Long id)
    {
        return activiteSer.DeleteActivity(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateActivity( @Valid @RequestBody Activite a,@PathVariable Long id)
    {
        return activiteSer.updateActivity(a,id);
    }







}
