package insurance.domain;

import insurance.domain.*;
import insurance.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewCompleted extends AbstractEvent {

    private Long id;
    private Long claimId;
    private String userId;
    private String reviewResult;

    public ReviewCompleted(Review aggregate) {
        super(aggregate);
    }

    public ReviewCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
