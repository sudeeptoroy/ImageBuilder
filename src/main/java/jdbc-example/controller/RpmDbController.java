package jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rpm")
public class RpmDbController {

    @Autowired
    private RpmDbRepository rpmDbRepository;

    @RequestMapping("/all")
    public List<RpmDb> getAllRpms() {
        return rpmDbRepository.findAll();
    }

    @PostMapping("/rpm")
    public RpmDb createRpm (@Valid @RequestBody RpmDb rpm) {
        return rpmDbRepository.save(rpm);
    }
}