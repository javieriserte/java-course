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
		
		RegionDrawer drawer = args[3].equals("cheap")?new RegionDrawerCheap():new RegionDrawerExpensive();

		Region region;
		try {
			long initial = System.currentTimeMillis();
			
			region = RegionFactory.fromReader(new FileReader(datafile.toFile()));
			
			long afterReading = System.currentTimeMillis();
			
			System.out.println("Time spent reading input file: " + (afterReading - initial));
			
			exportImage(outfile1, region, drawer);
			
			long afterExport = System.currentTimeMillis();
			
			System.out.println("Time spent exporting image: " + (afterExport - afterReading));
			
			System.out.println("Initial number of elements: " + region.countElements());

			long counting = System.currentTimeMillis();
			
			System.out.println("Time spent counting elements image: " + (counting - afterExport));

			region = region.simplificar();

			long simplify = System.currentTimeMillis();
			
			System.out.println("Time spent simplifying data: " + (simplify - counting));

			exportImage(outfile2, region, drawer);

			long secondExport = System.currentTimeMillis();
			
			System.out.println("Time spent in second export: " + (secondExport - simplify));
			
			System.out.println("Final number of elements: " + region.countElements());

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			
		}


	}

	private static void exportImage(Path outfile, Region region, RegionDrawer drawer) {
			
		BufferedImage image = drawer.draw(region, 3072);

		try {
			ImageIO.write(image, "PNG", outfile.toFile());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
