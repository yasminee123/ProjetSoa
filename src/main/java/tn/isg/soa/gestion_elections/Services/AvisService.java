package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Avis;
import tn.isg.soa.gestion_elections.Models.AvisID;
import tn.isg.soa.gestion_elections.Repositories.ActiviteRepository;
import tn.isg.soa.gestion_elections.Repositories.AvisRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AvisService {
    @Autowired
    private AvisRepository avisRepos;
    //Add activity
    public ResponseEntity<Avis> AddAvis(Avis av)
    {
        try {
            Avis av1= avisRepos.save(av);
            return new ResponseEntity<Avis>(av1, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    //Get all activities
    public ResponseEntity<List<Avis>> GetAllAvis()
    {
        List<Avis> lst= avisRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneAvis(AvisID id)
    {
        Optional<Avis> res=avisRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteAvis(AvisID id)
    {
        Optional<Avis> res=avisRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    avisRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateAvis(Avis newavis,AvisID id)
    {
        Optional<Avis> avis = avisRepos.findById(id);
        if(avis.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Avis av1= avis.get();
        av1.setNote(newavis.getNote());
        av1.setCommentaire(newavis.getCommentaire());
        Avis av2=avisRepos.save(av1);
        return  new ResponseEntity(av1,HttpStatus.OK);
    }

}
