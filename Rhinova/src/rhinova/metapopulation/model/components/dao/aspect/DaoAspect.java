package rhinova.metapopulation.model.components.dao.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import rhinova.gui.HomeView;
import rhinova.metapopulation.model.components.dao.MetapopulationDao;


@Aspect
public class DaoAspect {

	@Autowired
	ApplicationEventPublisher publisher;
	
	MetapopulationDao dao;
	
	HomeView homeView;
	
	public void setDao(MetapopulationDao dao) {
		this.dao = dao;
	}

	public void setHomeView(HomeView homeView) {
		this.homeView = homeView;
	}

	
	@AfterReturning("@annotation(rhinova.metapopulation.model.components.dao.aspect.DaoAction)")
	public void myAsdfds() {
		
		if (homeView != null) {
			homeView.setTitle(dao.getLastFilePath());
		}
	}
}
