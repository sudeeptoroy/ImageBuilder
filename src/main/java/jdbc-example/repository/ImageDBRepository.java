package jdbcexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDBRepository extends JpaRepository<ImageDb, Long> {
/*
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_IMAGENAMES_QUERY = "SELECT image_name FROM ImageDB";

    @Autowired
    public ImageDBRepository(@Qualifier("mainDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getImageNames() {

        List<String> imageNames = jdbcTemplate.queryForList(SELECT_ALL_IMAGENAMES_QUERY,String.class);
        return imageNames;
    }
    */
}
