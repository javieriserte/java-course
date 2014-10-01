package jai.course.terrainmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RegionFactory {

	//////////////////////////////////////////////////////////
	// Static methods
	public static Region fromFile(File file) {
		
		try {
			
			Reader fileReader = new FileReader(file);
			
			return fromReader(fileReader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public static Region fromReader(Reader fileReader) {
		List<Terreno> terrainList = new ArrayList<>();
		int c=-1;
		
		try {
			while ((c=fileReader.read())>0) {
			
				Terreno current;
				switch ((char)c) {
				case '1':
					current=Terreno.Tierra;
					break;
				default:
					current=Terreno.Agua;
				
				}
				
				terrainList.add(current);
				
			}

		fileReader.close();
		
		int numberOfElements = terrainList.size();
		
		if (!((numberOfElements & -numberOfElements)==numberOfElements)) {
			
			return null;
			
		}
		
		int terrainMapWidth = (int) Math.sqrt((double)numberOfElements);
		
		Region[][] map = new Region[terrainMapWidth][terrainMapWidth];
		
		
		for (int i = 0; i < terrainMapWidth; i++)  {
			
			for (int j = 0; j < terrainMapWidth; j++)  {
				
				int listIndex = j + (i*terrainMapWidth);
				
				map[j][i] = new Unidad(terrainList.get(listIndex));
				
			}
			
		}
		
		Region[][] newMap = map;
		
		while (terrainMapWidth>1) {
			
			terrainMapWidth = terrainMapWidth/2;
			
			Region[][] oldMap = newMap;
			
			newMap = new Region[terrainMapWidth][terrainMapWidth];

			for (int i = 0; i < terrainMapWidth; i++)  {
				
				for (int j = 0; j < terrainMapWidth; j++)  {
					
					newMap[i][j] = new Bloque(
							oldMap[2*i+1] [2*j], 
							oldMap[2*i]   [2*j], 
							oldMap[2*i+1] [2*j+1], 
							oldMap[2*i]   [2*j+1]);

				}

			}
			
		}
		
		return newMap[0][0];
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
