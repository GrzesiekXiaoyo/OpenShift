package bootwildfly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController
{
	@Autowired
	private HelloWildFlyService service;

	@RequestMapping("hello")
	public String sayHello()
	{
		return service.getHello();
	}
}