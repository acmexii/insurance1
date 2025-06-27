package insurance.domain;

import insurance.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewCompleted extends AbstractEvent {

    private Long id;
    private Long claimId;
    private String userId;
    private String reviewResult;
}
