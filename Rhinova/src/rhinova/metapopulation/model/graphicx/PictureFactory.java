package rhinova.metapopulation.model.graphicx;

import resoursource.ResourceLoader;
import rhinova.framework.drawable.CircleList;
import rhinova.framework.drawable.LineList;
import rhinova.metapopulation.model.graphicx.picture.ArrowCirclePicture;
import rhinova.metapopulation.model.graphicx.picture.CircleLinePicture;
import rhinova.metapopulation.model.graphicx.picture.JustCirclePicture;
import rhinova.metapopulation.model.graphicx.picture.SimulatedPicture;


public class PictureFactory {

	private String backGroundPath = ResourceLoader.getImagePath("Map.png");

	public PictureFactory()
	{
		super();
	}


	public PictureFactory(String backGroundPath) {
		super();
		this.backGroundPath = backGroundPath;
	}


	public SimulatedPicture createJustCirclePicture(
			LineList lines,
			CircleList circles,
			int pause,
			int year,
			String stage,
			double population,
			int populationIndex) {

		return new JustCirclePicture(
				lines,
				circles,
				pause,
				backGroundPath, 
				year,
				stage,
				population,
				populationIndex);
	}



	public CircleLinePicture createCirclePicture(
			LineList lines,
			CircleList circles,
			int pause,
			int year,
			String stage,
			double population,
			int populationIndex) {

		return new CircleLinePicture(
				lines,
				circles,
				pause,
				backGroundPath,
				year,
				stage,
				population,
				populationIndex);
	}

	public CircleLinePicture createCircleLinePicture(
			LineList lines,
			CircleList circles,
			int pause,
			int year,
			String stage,
			double population,
			int populationIndex) {

		return new CircleLinePicture(
				lines,
				circles,
				pause,
				backGroundPath,
				year,
				stage,
				population,
				populationIndex);		
	}


	public ArrowCirclePicture createArrowCirclePicture(
			LineList lines,
			CircleList circles,
			int pause,
			double t,
			int year,
			String stage,
			double population,
			int populationIndex)  {

		return new ArrowCirclePicture(
				lines,
				circles,
				pause,
				backGroundPath,
				t,
				year,
				stage,
				population,
				populationIndex);
	}


}
