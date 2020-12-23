package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Texte;
import tn.isg.soa.gestion_elections.Services.LienService;
import tn.isg.soa.gestion_elections.Services.TexteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/textes")
public class TexteController {
    @Autowired
    TexteService texteSer;
    private final Logger log= LoggerFactory.getLogger(Texte.class);

    @PostMapping("/texte/{actId}/newtexte")
    public ResponseEntity<Texte> addTexte(@Valid @RequestBody Texte l, @PathVariable Long ActId)
    {
        return texteSer.AddTexte(l,ActId);
    }

    @GetMapping("/texte/{id}")
    public ResponseEntity<?> GetLienById(@PathVariable Long id)
    {
        return texteSer.GetOneTexte(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Texte>> GetAllTextes()
    {
        return texteSer.GetAllTextes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteTexte(@PathVariable Long id)
    { return texteSer.DeleteTexte(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLien( @Valid @RequestBody Texte t,@PathVariable Long id)
    {
        return texteSer.updateTexte(t,id);
    }
}
