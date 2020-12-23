package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.ListePresidentielle;
import tn.isg.soa.gestion_elections.Services.ListeLegislativeService;
import tn.isg.soa.gestion_elections.Services.ListePresidentielleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/listepres")
public class ListePresidentielleController {
    @Autowired
    ListePresidentielleService llSer;
    private final Logger log= LoggerFactory.getLogger(ListePresidentielle.class);

    @PostMapping("/newpres")
    public ResponseEntity<ListePresidentielle> addListe(@Valid @RequestBody ListePresidentielle l)
    {
        return llSer.AddLP(l);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetListeById(@PathVariable Long id)
    {
        return llSer.GetOneListePres(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ListePresidentielle>> GetAllPres()
    {
        return llSer.GetAllListePres();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteListe(@PathVariable Long id)
    { return llSer.DeleteListePre(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateListe( @Valid @RequestBody ListePresidentielle l,@PathVariable Long id)
    {
        return llSer.updateListePre(l,id);
    }
}
