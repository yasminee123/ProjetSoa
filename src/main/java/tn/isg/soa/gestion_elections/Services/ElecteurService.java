package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Avis;
import tn.isg.soa.gestion_elections.Models.AvisID;
import tn.isg.soa.gestion_elections.Models.Electeur;
import tn.isg.soa.gestion_elections.Repositories.CandidatRepository;
import tn.isg.soa.gestion_elections.Repositories.ElecteurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ElecteurService {
    @Autowired
    private ElecteurRepository electeurRepos;

    //Add activity
    public ResponseEntity<Electeur> AddElecteur(Electeur el)
    {
        try {
            Electeur el1= electeurRepos.save(el);
            return new ResponseEntity<Electeur>(el1, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    //Get all activities
    public ResponseEntity<List<Electeur>> GetAllElecteurs()
    {
        List<Electeur> lst= electeurRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneElecteur(Long id)
    {
        Optional<Electeur> res=electeurRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteElecteur(Long id)
    {
        Optional<Electeur> res=electeurRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    electeurRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateElecteur(Electeur newel,Long id)
    {
        Optional<Electeur> electeur = electeurRepos.findById(id);
        if(electeur.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Electeur el1= electeur.get();
        el1.setNom(newel.getNom());
        el1.setPrenom(newel.getNom());
        el1.setDate_naiss(newel.getDate_naiss());
        el1.setMail(newel.getMail());
        el1.setMdp(newel.getMdp());
        Electeur el2=electeurRepos.save(el1);
        return  new ResponseEntity(el1,HttpStatus.OK);
    }
}
