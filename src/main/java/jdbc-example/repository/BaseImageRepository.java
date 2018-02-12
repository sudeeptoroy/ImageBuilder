package jdbcexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseImageRepository extends JpaRepository<BaseImage, Long> {

}
