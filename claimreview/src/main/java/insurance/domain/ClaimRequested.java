package insurance.domain;

import insurance.domain.*;
import insurance.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ClaimRequested extends AbstractEvent {

    private Long id;
    private String userId;
    private String claimTitle;
    private Date acceptDate;
}
