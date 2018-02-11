package jdbcexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildDbRepository extends JpaRepository<BuildDb, Long> {

}
