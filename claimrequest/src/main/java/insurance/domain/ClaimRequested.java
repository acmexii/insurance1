package insurance.domain;

import insurance.domain.*;
import insurance.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClaimRequested extends AbstractEvent {

    private Long id;
    private String userId;
    private String claimTitle;
    private Date acceptDate;

    public ClaimRequested(Claim aggregate) {
        super(aggregate);
    }

    public ClaimRequested() {
        super();
    }
}
//>>> DDD / Domain Event
