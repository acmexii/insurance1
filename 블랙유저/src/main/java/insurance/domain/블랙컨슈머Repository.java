package insurance.domain;

import insurance.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "블랙컨슈머",
    path = "블랙컨슈머"
)
public interface 블랙컨슈머Repository
    extends PagingAndSortingRepository<블랙컨슈머, Long> {}
