package insurance.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import insurance.ClaimreviewApplication;
import insurance.domain.ReviewCompleted;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long claimId;

    private String userId;

    private String reviewResult;

    @PostPersist
    public void onPostPersist() {
        ReviewCompleted reviewCompleted = new ReviewCompleted(this);
        reviewCompleted.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ClaimreviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startReview(ClaimRequested claimRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        

        repository().findById(claimRequested.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
