package jai.course.terrainmap;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class RegionDrawerCli {

	public static void main(String[] args) {

		Path outfile1 = Paths.get(args[0]);

		Path outfile2 = Paths.get(args[1]);

		Path datafile = Paths.get(args[2]);

		Region region;
		try {
			region = RegionFactory.fromReader(new FileReader(datafile.toFile()));

			exportImage(outfile1, region);
			
			System.out.println("Initial number of elements: " + region.countElements());

			region = region.simplificar();

			exportImage(outfile2, region);
			
			System.out.println("Final number of elements: " + region.countElements());

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			
		}


	}

	private static void exportImage(Path outfile, Region region) {
			
		BufferedImage image = (new RegionDrawer()).draw(region, 3072);

		try {
			ImageIO.write(image, "PNG", outfile.toFile());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
