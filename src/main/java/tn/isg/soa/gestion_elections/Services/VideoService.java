package tn.isg.soa.gestion_elections.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.soa.gestion_elections.Models.Activite;
import tn.isg.soa.gestion_elections.Models.Video;
import tn.isg.soa.gestion_elections.Repositories.ActiviteRepository;
import tn.isg.soa.gestion_elections.Repositories.VideoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepos;
    @Autowired
    private ActiviteRepository actRepos;

    //Add
    public ResponseEntity<Video> AddVideo(Video v, Long ActId)
    {
        Optional<Activite> res=actRepos.findById(ActId);
        if(res.isPresent())
        {
            v.setAct(res.get());
            Video f1= videoRepos.save(v);
            return new ResponseEntity<Video>(f1, HttpStatus.CREATED);
        }

        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //Get all activities
    public ResponseEntity<List<Video>> GetAllVideos()
    {
        List<Video> lst= videoRepos.findAll();
        if(lst.isEmpty())
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(lst,HttpStatus.OK);
    }

    //Get One
    public ResponseEntity<?> GetOneVideo(Long id)
    {
        Optional<Video> res=videoRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(res,HttpStatus.OK);
    }

    //Delete
    public ResponseEntity DeleteVideo(Long id)
    {
        Optional<Video> res=videoRepos.findById(id);
        if(res.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {    videoRepos.deleteById(id);
            return new ResponseEntity(res,HttpStatus.OK);
        }
    }
    //Update activity
    public ResponseEntity<?> UpdateVideo(Video newvideo,Long id)
    {
        Optional<Video>  vid= videoRepos.findById(id);
        if(vid.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        Video t1= vid.get();
        t1.setContenu(newvideo.getContenu());
        Video t2=videoRepos.save(t1);
        return  new ResponseEntity(t1,HttpStatus.OK);
    }
}
