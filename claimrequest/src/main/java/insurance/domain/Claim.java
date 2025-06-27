package insurance.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import insurance.ClaimrequestApplication;
import insurance.domain.ClaimRequested;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Claim_table")
@Data
//<<< DDD / Aggregate Root
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String claimTitle;

    private Date acceptDate;

    @PostPersist
    public void onPostPersist() {
        ClaimRequested claimRequested = new ClaimRequested(this);
        claimRequested.publishAfterCommit();
    }

    public static ClaimRepository repository() {
        ClaimRepository claimRepository = ClaimrequestApplication.applicationContext.getBean(
            ClaimRepository.class
        );
        return claimRepository;
    }

    //<<< Clean Arch / Port Method
    public void accept(AcceptCommand acceptCommand) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
