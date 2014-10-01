package jai.course.terrainmap;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class ImageMapReaderCli {

	public static void main(String[] args) {
		
		Path infile = Paths.get(args[0]);
		Path outfile = Paths.get(args[1]);
		
		
		try {

			BufferedImage image = ImageIO.read(infile.toFile());
			
			String sb = readImageData(image);
			
			exportData(outfile, sb);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("There was an error trying to read file: "+infile.getFileName());
			System.exit(1);
		}
		

	}

	private static void exportData(Path outfile, String sb)
			throws FileNotFoundException {
		PrintStream ps = new PrintStream(outfile.toFile());
		
		ps.print(sb);
		
		ps.flush();
		
		ps.close();
	}

	private static String readImageData(BufferedImage image) {
		
		int width = image.getWidth();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i< width ; i++) {
			
			for (int j = 0; j< width ; j++) {
				
				Color currentColor = new Color(image.getRGB(j, i));
				
				int currentColorR = currentColor.getRed();
				int currentColorG = currentColor.getGreen();
				int currentColorB = currentColor.getBlue();
				
				char current; 
				
				if (currentColorR <100  && currentColorG <100 && currentColorB <100) {
					
					current = '1';
					
				} else {
					
					current = '0';
				}
				
				sb.append(current);
				
				
			}
			
		}
		return sb.toString();
	}

}
