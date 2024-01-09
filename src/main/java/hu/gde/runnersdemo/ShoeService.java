package hu.gde.runnersdemo;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ShoeService {

    private final ShoeRepository shoeRepository;

    public List<ShoeEntity> getAllShoes() {
        return shoeRepository.findAll();
    }
}
