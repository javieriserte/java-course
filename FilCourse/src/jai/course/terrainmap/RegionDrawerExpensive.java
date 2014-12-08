package jai.course.terrainmap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class RegionDrawerExpensive extends RegionDrawer {
	
	@Override
	protected BufferedImage draw(BufferedImage image, Region region, int width, int off_set_x, int off_set_y) {

		Terrain terrain = region.getTerrain();
		
		if (terrain != Terrain.MIXED) {
			
			Color color = terrain==Terrain.LAND?Color.black:Color.white;
			
			Graphics2D g = (Graphics2D) image.getGraphics();
			
			g.setColor(color);
			
			g.fillRect(off_set_x, off_set_y, width, width);
			
			g.setColor(Color.red);
			
			g.drawRect(off_set_x, off_set_y, width, width);
			
		} else {
			
			Block bloque = (Block) region;
			
			int subRegionWidth = (int) width/2;
			
			this.draw(image, bloque.getTopLeft(),subRegionWidth,off_set_x,off_set_y);
			this.draw(image, bloque.getTopRight()  ,subRegionWidth,off_set_x+subRegionWidth,off_set_y);
			this.draw(image, bloque.getBottomLeft() ,subRegionWidth,off_set_x,off_set_y+subRegionWidth);
			this.draw(image, bloque.getBottomRight()   ,subRegionWidth,off_set_x+subRegionWidth,off_set_y+subRegionWidth);
			
		}
		
		return image;
		
	}

}
