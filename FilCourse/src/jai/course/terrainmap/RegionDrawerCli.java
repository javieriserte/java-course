package jai.course.terrainmap;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class RegionDrawerCli {

	public static void main(String[] args) {
		
		Path outfile1 = Paths.get(args[0]);
		
		Path outfile2 = Paths.get(args[1]);
		
		String data = "1110110010000000";
		
		StringReader sr = new StringReader(data);
		
		Region region = RegionFactory.fromReader(sr);
		
		exportImage(outfile1, region);
		
		region.simplificar();
		
		exportImage(outfile2, region);

	}

	private static void exportImage(Path outfile, Region region) {
			
		BufferedImage image = (new RegionDrawer()).draw(region, 64);

		try {
			ImageIO.write(image, "PNG", outfile.toFile());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
