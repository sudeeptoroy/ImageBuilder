package jdbcexample.repository;

import jdbcexample.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseImageRepository extends JpaRepository<BaseImage, Long> {

    BaseImage findByName(String name);

}
