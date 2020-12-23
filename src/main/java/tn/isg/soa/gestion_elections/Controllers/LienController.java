package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Formation;
import tn.isg.soa.gestion_elections.Models.Lien;
import tn.isg.soa.gestion_elections.Services.FormationService;
import tn.isg.soa.gestion_elections.Services.LienService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/liens")
public class LienController {
    @Autowired
    LienService lienSer;
    private final Logger log= LoggerFactory.getLogger(Lien.class);

    @PostMapping("/lien/{id}/newlien")
    public ResponseEntity<Lien> addLien(@Valid @RequestBody Lien l,@PathVariable Long id)
    {
        return lienSer.AddLien(l,id);
    }


    @GetMapping("/lien/{id}")
    public ResponseEntity<?> GetLienById(@PathVariable Long id)
    {
        return lienSer.GetOneLien(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lien>> GetAllLien()
    {
        return lienSer.GetAllLien();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteLien(@PathVariable Long id)
    { return lienSer.DeleteLien(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLien( @Valid @RequestBody Lien l,@PathVariable Long id)
    {
        return lienSer.updateLien(l,id);
    }
}
