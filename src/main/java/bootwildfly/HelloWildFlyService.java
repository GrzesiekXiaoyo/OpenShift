package bootwildfly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWildFlyService
{
	@Autowired
	private HelloRepository repository;

	public String getHello()
	{
		return String.valueOf(repository.count());
	}
}
