package bootwildfly;

import org.springframework.stereotype.Service;

@Service
public class HelloWildFlyService
{
	public String getHello()
	{
		return "hello";
	}
}
