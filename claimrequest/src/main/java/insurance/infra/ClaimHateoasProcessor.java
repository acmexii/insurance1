package insurance.infra;

import insurance.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClaimHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Claim>> {

    @Override
    public EntityModel<Claim> process(EntityModel<Claim> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );

        return model;
    }
}
