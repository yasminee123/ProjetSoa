package tn.isg.soa.gestion_elections.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.ListeLegislative;
import tn.isg.soa.gestion_elections.Models.ListePresidentielle;
import tn.isg.soa.gestion_elections.Repositories.ListePresidentielleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListePresidentielleService {
    @Autowired
    private ListePresidentielleRepository lpRepos;

    //Add activity
    public ResponseEntity<ListePresidentielle> AddLP(ListePresidentielle lp)
    {
        try {
            ListePresidentielle l1= lpRepos.save(lp);
            return new ResponseEntity<ListePresidentielle>(l1, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    //Get all activities
    public ResponseEntity<List<ListePresidentielle>> GetAllListePres()
    {
        List<ListePresidentielle> lst= lpRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One activity
    public ResponseEntity<?> GetOneListePres(Long id)
    {
        Optional<ListePresidentielle> res=lpRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete activity
    public ResponseEntity DeleteListePre(Long id)
    {
        Optional<ListePresidentielle> res=lpRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    lpRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> updateListePre(ListePresidentielle newl,Long id)
    {
        Optional<ListePresidentielle> liste = lpRepos.findById(id);
        if(liste.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        ListePresidentielle l1= liste.get();
        l1.setNbCandidats(newl.getNbCandidats());
        ListePresidentielle l2=lpRepos.save(l1);
        return  new ResponseEntity(l1,HttpStatus.OK);
    }
}
