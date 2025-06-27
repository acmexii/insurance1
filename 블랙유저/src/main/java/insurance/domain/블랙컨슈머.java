package insurance.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import insurance.블랙유저Application;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "블랙컨슈머_table")
@Data
//<<< DDD / Aggregate Root
public class 블랙컨슈머 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static 블랙컨슈머Repository repository() {
        블랙컨슈머Repository 블랙컨슈머Repository = 블랙유저Application.applicationContext.getBean(
            블랙컨슈머Repository.class
        );
        return 블랙컨슈머Repository;
    }
}
//>>> DDD / Aggregate Root
