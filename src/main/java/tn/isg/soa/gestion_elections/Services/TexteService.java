package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Texte;
import tn.isg.soa.gestion_elections.Repositories.ActiviteRepository;
import tn.isg.soa.gestion_elections.Repositories.TexteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TexteService {
    @Autowired
    private TexteRepository texteRepos;
    @Autowired
    private ActiviteRepository actRepos;

    //Add
    public ResponseEntity<Texte> AddTexte(Texte t, Long ActId)
    {
        Optional<Activite> res=actRepos.findById(ActId);
        if(res.isPresent())
        {
            t.setAct(res.get());
            Texte t1= texteRepos.save(t);
            return new ResponseEntity<Texte>(t1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //Get all activities
    public ResponseEntity<List<Texte>> GetAllTextes()
    {
        List<Texte> lst= texteRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One
    public ResponseEntity<?> GetOneTexte(Long id)
    {
        Optional<Texte> res=texteRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete
    public ResponseEntity DeleteTexte(Long id)
    {
        Optional<Texte> res=texteRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    texteRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateTexte(Texte newtexte,Long id)
    {
        Optional<Texte> lien = texteRepos.findById(id);
        if(lien.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Texte t1= lien.get();
        t1.setContenu(newtexte.getContenu());
        Texte t2=texteRepos.save(t1);
        return  new ResponseEntity(t1,HttpStatus.OK);
    }
}
