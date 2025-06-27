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
// @RequestMapping(value="/블랙컨슈머")
@Transactional
public class 블랙컨슈머Controller {

    @Autowired
    블랙컨슈머Repository 블랙컨슈머Repository;
}
//>>> Clean Arch / Inbound Adaptor
