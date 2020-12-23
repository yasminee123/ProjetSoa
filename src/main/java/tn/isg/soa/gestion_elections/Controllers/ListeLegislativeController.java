package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Lien;
import tn.isg.soa.gestion_elections.Models.ListeLegislative;
import tn.isg.soa.gestion_elections.Services.LienService;
import tn.isg.soa.gestion_elections.Services.ListeLegislativeService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/listelegistlatives")
public class ListeLegislativeController {

    @Autowired
    ListeLegislativeService llSer;
    private final Logger log= LoggerFactory.getLogger(ListeLegislative.class);

    @PostMapping("/newlegistlative")
    public ResponseEntity<ListeLegislative> addListe(@Valid @RequestBody ListeLegislative l)
    {
        return llSer.AddLL(l);
    }

    @GetMapping("/legistlative/{id}")
    public ResponseEntity<?> GetListeById(@PathVariable Long id)
    {
        return llSer.GetOneListeLeg(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ListeLegislative>> GetAllLegist()
    {
        return llSer.GetAllListeLeg();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteListe(@PathVariable Long id)
    { return llSer.DeleteListeLeg(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateListe( @Valid @RequestBody ListeLegislative l,@PathVariable Long id)
    {
        return llSer.updateListeLeg(l,id);
    }


}
