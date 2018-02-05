package bootwildfly;

import org.springframework.data.repository.CrudRepository;

public interface HelloRepository extends CrudRepository<HelloWildFlyModel, Long>
{
}
