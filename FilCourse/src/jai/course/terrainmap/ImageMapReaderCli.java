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
		System.out.println(infile.toAbsolutePath().toString());
		Path outfile = Paths.get(args[1]);
		Integer depth = Integer.valueOf(args[2]);
				
		try {

			BufferedImage image = ImageIO.read(infile.toFile());
			
			String sb = readImageData(image, depth);
			
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

	private static String readImageData(BufferedImage image, int depth) {
		
		
		int width = image.getWidth();
		int height = image.getHeight();
		StringBuilder sb = new StringBuilder();
		
		double pixWidth = Math.pow(2, depth);
		
		for (int i = 0; i< pixWidth ; i++) {
			
			for (int j = 0; j< pixWidth ; j++) {
				
				int pi = (int) (Math.floor(i/pixWidth * width));
				int pj = (int) (Math.floor(j/pixWidth * height));
				
				Color currentColor = new Color(image.getRGB(pj, pi));
				
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
