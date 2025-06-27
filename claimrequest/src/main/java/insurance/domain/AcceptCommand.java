package insurance.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AcceptCommand {

    private Long claimId;
    private Boolean acceptYn;
}
