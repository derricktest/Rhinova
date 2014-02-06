package resoursource;

public class ResourceLoader {
	
	private ResourceLoader(){};
	
	private static ResourceLoader rl = new ResourceLoader();
	
	public static String getImagePath(String image) {
		return rl.getClass().getResource("img"+"/"+image).getPath();
	}
	
	public static String getIconPath(String icon) {
		return rl.getClass().getResource("icon"+"/"+icon).getPath();
	}
	
}
