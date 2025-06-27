package insurance.infra;

import insurance.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/claims")
@Transactional
public class ClaimController {

    @Autowired
    ClaimRepository claimRepository;

    @RequestMapping(
        value = "/claims/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Claim accept(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptCommand acceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /claim/accept  called #####");
        Optional<Claim> optionalClaim = claimRepository.findById(id);

        optionalClaim.orElseThrow(() -> new Exception("No Entity Found"));
        Claim claim = optionalClaim.get();
        claim.accept(acceptCommand);

        claimRepository.save(claim);
        return claim;
    }
}
//>>> Clean Arch / Inbound Adaptor
