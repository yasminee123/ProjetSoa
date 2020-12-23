package tn.isg.soa.gestion_elections.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.isg.soa.gestion_elections.Models.Photo;
import tn.isg.soa.gestion_elections.Models.Texte;
import tn.isg.soa.gestion_elections.Services.PhotoService;
import tn.isg.soa.gestion_elections.Services.TexteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    PhotoService photoSer;
    private final Logger log= LoggerFactory.getLogger(Photo.class);

    @PostMapping("/photo/{actId}/newphoto")
    public ResponseEntity<Photo> addPhoto(@Valid @RequestBody Photo f, @PathVariable Long ActId)
    {
        return photoSer.AddPhoto(f,ActId);
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<?> GetPhotoById(@PathVariable Long id)
    {
        return photoSer.GetOnePhoto(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Photo>> GetAllPhotos()
    {
        return photoSer.GetAllPhotos();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeletePhoto(@PathVariable Long id)
    { return  photoSer.DeletePhoto(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLien( @Valid @RequestBody Photo f,@PathVariable Long id)
    {
        return photoSer.UpdatePhoto(f,id);
    }
}
