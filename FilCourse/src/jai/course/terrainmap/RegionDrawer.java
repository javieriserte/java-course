package jai.course.terrainmap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class RegionDrawer {
	
	public BufferedImage draw (Region region, int width) {
		
		BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
		
		return this.draw(image, region, width,0,0);
		
		
	}

	private BufferedImage draw(BufferedImage image, Region region, int width, int off_set_x, int off_set_y) {

		Terreno terrain = region.getTerreno();
		
		if (terrain != Terreno.Mezclado) {
			
			Color color = terrain==Terreno.Tierra?Color.black:Color.white;
			
			Graphics2D g = (Graphics2D) image.getGraphics();
			
			g.setColor(color);
			
			g.fillRect(off_set_x, off_set_y, width, width);
			
			g.setColor(Color.red);
			
			g.drawRect(off_set_x, off_set_y, width, width);
			
		} else {
			
			Bloque bloque = (Bloque) region;
			
			int subRegionWidth = (int) width/2;
			
			this.draw(image, bloque.getArribaIzquierda(),subRegionWidth,off_set_x,off_set_y);
			this.draw(image, bloque.getArribaDerecha()  ,subRegionWidth,off_set_x+subRegionWidth,off_set_y);
			this.draw(image, bloque.getAbajoIzquierda() ,subRegionWidth,off_set_x,off_set_y+subRegionWidth);
			this.draw(image, bloque.getAbajoDerecha()   ,subRegionWidth,off_set_x+subRegionWidth,off_set_y+subRegionWidth);
			
		}
		
		return image;
		
	}

}
