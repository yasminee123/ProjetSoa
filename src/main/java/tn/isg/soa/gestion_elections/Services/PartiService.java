package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Candidat;
import tn.isg.soa.gestion_elections.Models.ListePresidentielle;
import tn.isg.soa.gestion_elections.Models.Parti;
import tn.isg.soa.gestion_elections.Repositories.ActiviteRepository;
import tn.isg.soa.gestion_elections.Repositories.PartiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PartiService {
    @Autowired
    private PartiRepository partiRepos;
    //Add activity
    public ResponseEntity<Parti> AddParti(Parti p)
    {
        try {
            Parti p1= partiRepos.save(p);
            return new ResponseEntity<Parti>(p1, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


    //Get all activities
    public ResponseEntity<List<Parti>> GetAllParti()
    {
        List<Parti> lst= partiRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneParti(Long id)
    {
        Optional<Parti> res=partiRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteParti(Long id)
    {
        Optional<Parti> res=partiRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    partiRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateParti(Parti newp,Long id)
    {
        Optional<Parti> parti =  partiRepos.findById(id);
        if(parti.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Parti p=parti.get();
        p.setNbAdh(newp.getNbAdh());
        p.setNom(newp.getNom());
        Parti l2=partiRepos.save(p);
        return  new ResponseEntity(p,HttpStatus.OK);
    }
}
