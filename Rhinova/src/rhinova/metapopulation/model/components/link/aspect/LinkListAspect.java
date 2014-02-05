package rhinova.metapopulation.model.components.link.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import rhinova.metapopulation.model.components.link.LinkList;



@Component
@Aspect
public class LinkListAspect {
	
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@Autowired
	LinkList linkList;
	
	
	@AfterReturning("@annotation(rhinova.metapopulation.model.components.link.aspect.LinkUpdate)")
	public void myAsdfds() {
		
		publisher.publishEvent(new LinkListUpdateEvent(this));
		
	}
	
	

}
