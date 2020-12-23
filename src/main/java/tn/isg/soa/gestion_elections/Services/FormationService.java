package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Candidat;
import tn.isg.soa.gestion_elections.Models.Electeur;
import tn.isg.soa.gestion_elections.Models.Formation;
import tn.isg.soa.gestion_elections.Repositories.CandidatRepository;
import tn.isg.soa.gestion_elections.Repositories.ElecteurRepository;
import tn.isg.soa.gestion_elections.Repositories.FormationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {
    @Autowired
    private FormationRepository formationRepos;
    @Autowired
    private CandidatRepository candidatRepos;

    //Add activity
    public ResponseEntity<Formation> AddFormation(Formation f, Long CandiId)
    {
        Optional<Candidat> res=candidatRepos.findById(CandiId);
        if(res.isPresent())
        {
            f.setCandidat(res.get());
            Formation f1= formationRepos.save(f);
            return new ResponseEntity<Formation>(f1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //Get all activities
    public ResponseEntity<List<Formation>> GetAllFormations()
    {
        List<Formation> lst= formationRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneFormation(Long id)
    {
        Optional<Formation> res=formationRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteFormation(Long id)
    {
        Optional<Formation> res=formationRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    formationRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateFormation(Formation newform,Long id)
    {
        Optional<Formation> formation = formationRepos.findById(id);
        if(formation.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Formation f1= formation.get();
        f1.setDateDebut(newform.getDateDebut());
        f1.setDateFin(newform.getDateFin());
        f1.setDomaine(newform.getDomaine());
        f1.setDomaine(newform.getDomaine());
        f1.setLieu(newform.getLieu());
        Formation f2=formationRepos.save(f1);
        return  new ResponseEntity(f1,HttpStatus.OK);
    }
}
