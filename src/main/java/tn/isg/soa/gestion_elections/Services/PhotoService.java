package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Photo;
import tn.isg.soa.gestion_elections.Repositories.ActiviteRepository;
import tn.isg.soa.gestion_elections.Repositories.PhotoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepos;
    @Autowired
    private ActiviteRepository actRepos;

    //Add
    public ResponseEntity<Photo> AddPhoto(Photo f, Long ActId)
    {
        Optional<Activite> res=actRepos.findById(ActId);
        if(res.isPresent())
        {
            f.setAct(res.get());
            Photo f1= photoRepos.save(f);
            return new ResponseEntity<Photo>(f1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //Get all activities
    public ResponseEntity<List<Photo>> GetAllPhotos()
    {
        List<Photo> lst= photoRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One
    public ResponseEntity<?> GetOnePhoto(Long id)
    {
        Optional<Photo> res=photoRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete
    public ResponseEntity DeletePhoto(Long id)
    {
        Optional<Photo> res=photoRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    photoRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> UpdatePhoto(Photo newphoto,Long id)
    {
        Optional<Photo> photo = photoRepos.findById(id);
        if(photo.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Photo t1= photo.get();
        t1.setContenu(newphoto.getContenu());
        Photo t2=photoRepos.save(t1);
        return  new ResponseEntity(t1,HttpStatus.OK);
    }
}
