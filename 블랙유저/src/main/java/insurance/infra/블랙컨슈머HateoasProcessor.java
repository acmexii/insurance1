package insurance.infra;

import insurance.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class 블랙컨슈머HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<블랙컨슈머>> {

    @Override
    public EntityModel<블랙컨슈머> process(EntityModel<블랙컨슈머> model) {
        return model;
    }
}
