package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Candidat;
import tn.isg.soa.gestion_elections.Models.Formation;
import tn.isg.soa.gestion_elections.Models.Poste;
import tn.isg.soa.gestion_elections.Repositories.CandidatRepository;
import tn.isg.soa.gestion_elections.Repositories.PosteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PosteService {
    @Autowired
    private CandidatRepository candidatRepos;
    @Autowired
    private PosteRepository posteRepos;

    //Add
    public ResponseEntity<Poste> AddPoste(Poste p, Long CandiId)
    {
        Optional<Candidat> res=candidatRepos.findById(CandiId);
        if(res.isPresent())
        {
            p.setCandidat(res.get());
            Poste p1= posteRepos.save(p);
            return new ResponseEntity<Poste>(p1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //Get all
   public ResponseEntity<List<Poste>> GetAllPostes()
    {
        List<Poste> lst= posteRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One
    public ResponseEntity<?> GetOnePoste(Long id)
    {
        Optional<Poste> res=posteRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete
    public ResponseEntity DeletePoste(Long id)
    {
        Optional<Poste> res=posteRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    posteRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update
    public ResponseEntity<?> updatePoste(Poste newposte,Long id)
    {
        Optional<Poste> poste = posteRepos.findById(id);
        if(poste.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Poste p1= poste.get();
        p1.setDate_debut(newposte.getDate_debut());
        p1.setDate_fin(newposte.getDate_fin());
        p1.setLieu(newposte.getLieu());
        //p1.setCandidat(newposte.getCandidat());
        p1.setTitre(newposte.getTitre());
        Poste p2=posteRepos.save(p1);
        return  new ResponseEntity(p1,HttpStatus.OK);
    }


}
