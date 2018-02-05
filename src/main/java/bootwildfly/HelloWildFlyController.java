package bootwildfly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController
{
	//	@Autowired
	//	private HelloWildFlyService service;

	@RequestMapping("hello")
	public String sayHello()
	{
		return "tt";//service.getHello();
	}
}