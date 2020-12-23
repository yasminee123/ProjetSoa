package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Texte;
import tn.isg.soa.gestion_elections.Models.Video;
import tn.isg.soa.gestion_elections.Services.TexteService;
import tn.isg.soa.gestion_elections.Services.VideoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    VideoService vidSer;
    private final Logger log= LoggerFactory.getLogger(Video.class);

    @PostMapping("/video/{actId}/newvideo")
    public ResponseEntity<Video> addVideo(@Valid @RequestBody Video v, @PathVariable Long ActId)
    {
        return vidSer.AddVideo(v,ActId);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<?> GetVideoById(@PathVariable Long id)
    {
        return vidSer.GetAllVideos();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Video>> GetAllVideos()
    {
        return vidSer.GetAllVideos();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteVideo(@PathVariable Long id)
    { return vidSer.DeleteVideo(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVideo( @Valid @RequestBody Video v,@PathVariable Long id)
    {
        return vidSer.UpdateVideo(v,id);
    }
}
