package jai.course.terrainmap;

import java.awt.image.BufferedImage;

public abstract class RegionDrawer {

	public RegionDrawer() {
		super();
	}

	protected abstract BufferedImage draw(BufferedImage image, Region region, int width,
			int off_set_x, int off_set_y);

	public BufferedImage draw(Region region, int width) {
		
		BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
		
		return this.draw(image, region, width,0,0);
		
		
	}

}