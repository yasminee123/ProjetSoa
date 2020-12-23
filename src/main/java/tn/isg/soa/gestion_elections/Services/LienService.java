package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.*;
import tn.isg.soa.gestion_elections.Repositories.ActiviteRepository;
import tn.isg.soa.gestion_elections.Repositories.FormationRepository;
import tn.isg.soa.gestion_elections.Repositories.LienRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LienService {
    @Autowired
    private LienRepository lienRepos;
    @Autowired
    private ActiviteRepository actRepos;

    //Add
    public ResponseEntity<Lien> AddLien(Lien l, Long ActId)
    {
        Optional<Activite> res=actRepos.findById(ActId);
        if(res.isPresent())
        {
            l.setAct(res.get());
           Lien l1= lienRepos.save(l);
            return new ResponseEntity<Lien>(l1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



    //Get all activities
    public ResponseEntity<List<Lien>> GetAllLien()
    {
        List<Lien> lst= lienRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneLien(Long id)
    {
        Optional<Lien> res=lienRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteLien(Long id)
    {
        Optional<Lien> res=lienRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    lienRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateLien(Lien newlien,Long id)
    {
        Optional<Lien> lien = lienRepos.findById(id);
        if(lien.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Lien l1= lien.get();
        l1.setContenu(newlien.getContenu());
        Lien l2=lienRepos.save(l1);
        return  new ResponseEntity(l1,HttpStatus.OK);
    }
}
