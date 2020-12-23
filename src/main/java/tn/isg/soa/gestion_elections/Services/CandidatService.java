package tn.isg.soa.gestion_elections.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.*;
import tn.isg.soa.gestion_elections.Repositories.CandidatRepository;
import tn.isg.soa.gestion_elections.Repositories.ListeLegislativeRepository;
import tn.isg.soa.gestion_elections.Repositories.ListePresidentielleRepository;
import tn.isg.soa.gestion_elections.Repositories.PartiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {
@Autowired
private CandidatRepository candidatRepos;




   /*public ResponseEntity<Candidat> AddCandidat(Candidat c,Long PartiId,Long Lid)
    {
        Optional<Parti> res1=partiRepos.findById(PartiId);
        Optional<ListeElectorale> res2=llRepos.findById(Lid);
        if(res1.isPresent() && res2.isPresent())
        {
            c.setParti(res1.get());
            c.setListe(res2.get());
            Candidat c1=  candidatRepos.save(c);
            return new ResponseEntity<Candidat>(c1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }*/


//Get all candidats
 public ResponseEntity<List<Candidat>> GetAllCandidats()
    {
        List<Candidat> lst= candidatRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

//Get One candidat
    public ResponseEntity<?> GetOneCandidat(Long id)
    {
        Optional<Candidat> res=candidatRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

 //Delete candidat
 public ResponseEntity DeleteCandidat(Long id)
 {
     Optional<Candidat> res=candidatRepos.findById(id);
     if(res.isEmpty())
         return new ResponseEntity(HttpStatus.NOT_FOUND);
     else
     {    candidatRepos.deleteById(id);
         return new ResponseEntity(res,HttpStatus.OK);
     }
 }

 //Update candidat
 public ResponseEntity<?> updateCandidat(Candidat newcandidat,Long id)
 {
     Optional<Candidat> candidat = candidatRepos.findById(id);
     if(candidat.isEmpty())
         return new ResponseEntity(HttpStatus.NOT_FOUND);
     Candidat c1= candidat.get();
     c1.setNom(newcandidat.getNom());
     c1.setPrenom(newcandidat.getPrenom());
     c1.setDate_naiss(newcandidat.getDate_naiss());
     c1.setMail(newcandidat.getMail());
     c1.setFb(newcandidat.getFb());
     c1.setTwitter(newcandidat.getTwitter());
     c1.setLinkedin(newcandidat.getLinkedin());
     c1.setScore(newcandidat.getScore());
     //c1.setPhoto(newcandidat.getPhoto());
     Candidat c2=candidatRepos.save(c1);
     return  new ResponseEntity(c1,HttpStatus.OK);
 }



}
