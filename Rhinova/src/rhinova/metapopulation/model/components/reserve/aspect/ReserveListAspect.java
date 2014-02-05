package rhinova.metapopulation.model.components.reserve.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import rhinova.metapopulation.model.components.reserve.ReserveList;

@Component
@Aspect
public class ReserveListAspect {
	
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@Autowired
	ReserveList reserveList;
	
	
	@AfterReturning("@annotation(rhinova.metapopulation.model.components.reserve.aspect.ReserveUpdate)")
	public void myAroundAnnotatedMethods() {
		
		// cause the GIS panel to be updated
		publisher.publishEvent(new ReserveListUpdateEvent(this, reserveList.getIds()));
	}
	
}
