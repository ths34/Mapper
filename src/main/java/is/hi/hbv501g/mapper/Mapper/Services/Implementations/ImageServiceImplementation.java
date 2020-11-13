package is.hi.hbv501g.mapper.Mapper.Services.Implementations;

import is.hi.hbv501g.mapper.Mapper.Entities.Comment;
import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Repositories.ImageRepository;
import is.hi.hbv501g.mapper.Mapper.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImplementation implements ImageService {

/*    Image save(Image image);
    List<Image> findAllImages();
    List<Image> findByLocation(Location location);
    List<Image> findByUsername(String userName);
    void delete(Image image);
    List<User> getLikes(Integer imageID);
    List<Comment> getComments(Integer imageID);
    Image findOne(Integer imageID);

 */

    ImageRepository theImageRepository;

    @Autowired
    public ImageServiceImplementation(ImageRepository imageRepository){this.theImageRepository = imageRepository;}

    @Override
    public Image save(Image image) {
        return theImageRepository.save(image);
    }

    @Override
    public List<Image> findAllImages() {
       return theImageRepository.findAllImages();
    }

    @Override
    public List<Image> findByLocationID(Location location) {
        return theImageRepository.findByLocationID(location);
    }

    @Override
    public List<Image> findByUsername(String userName) {
        return null;
    }

    @Override
    public void delete(Image image) {

    }

    @Override
    public List<User> getLikes(Integer imageID) {
        return null;
    }

    @Override
    public List<Comment> getComments(Integer imageID) {
        return null;
    }

    @Override
    public Image findOne(Integer imageID) {
        return null;
    }

    @Override
    public List<Image> findAllByUser(long UserID) {
        return theImageRepository.findAllByUser(UserID);
    }

    @Override
    public Optional<Image> findById(long id) {
        return theImageRepository.findById(id);
    }
}
