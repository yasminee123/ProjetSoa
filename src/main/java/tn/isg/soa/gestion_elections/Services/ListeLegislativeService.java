package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Lien;
import tn.isg.soa.gestion_elections.Models.ListeLegislative;
import tn.isg.soa.gestion_elections.Repositories.LienRepository;
import tn.isg.soa.gestion_elections.Repositories.ListeLegislativeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListeLegislativeService {
    @Autowired
    private ListeLegislativeRepository llRepos;

    //Add activity
    public ResponseEntity<ListeLegislative> AddLL(ListeLegislative l)
    {
        try {
            ListeLegislative l1= llRepos.save(l);
            return new ResponseEntity<ListeLegislative>(l1, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    //Get all activities
    public ResponseEntity<List<ListeLegislative>> GetAllListeLeg()
    {
        List<ListeLegislative> lst= llRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneListeLeg(Long id)
    {
        Optional<ListeLegislative> res=llRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteListeLeg(Long id)
    {
        Optional<ListeLegislative> res=llRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    llRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateListeLeg(ListeLegislative newl,Long id)
    {
        Optional<ListeLegislative> liste = llRepos.findById(id);
        if(liste.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        ListeLegislative l1= liste.get();
        l1.setType(newl.getType());
        l1.setRegion(newl.getRegion());
        l1.setPartis(newl.getPartis());
        l1.setTeteDeListe(newl.getTeteDeListe());
        l1.setScore(newl.getScore());
        ListeLegislative l2=llRepos.save(l1);
        return  new ResponseEntity(l1,HttpStatus.OK);
    }
}
