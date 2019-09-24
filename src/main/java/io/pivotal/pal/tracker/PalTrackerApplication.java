package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
public class PalTrackerApplication {

    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    TimeEntryRepository timeEntryRepository(DataSource dataSource) {

       // MysqlDataSource dataSource = new MysqlDataSource();
        //dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        //jdbcTemplate = new JdbcTemplate(dataSource);
        return new JdbcTimeEntryRepository(dataSource);
    }
}
