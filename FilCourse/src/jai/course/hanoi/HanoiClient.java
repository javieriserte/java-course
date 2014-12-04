package jai.course.hanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HanoiClient {
	private static String MESSAGE_MOVE_REGEX="\\s*MOVE\\s+(?<from>[LRM])\\s+TO\\s+(?<to>[LRM])\\s*";
	private static String MESSAGE_END_REGEX="\\s*END\\s*";
	private static String MESSAGE_RESTART_REGEX="\\s*RESTART(\\s*(?<rings>[0-9]+))*";

	public static void main(String[] args) {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		
		String currentLine = "";
		
		boolean end = false;
		boolean start = true;
		int nRings=3;
		
		Pattern movePattern = Pattern.compile(MESSAGE_MOVE_REGEX);
		Pattern endPattern = Pattern.compile(MESSAGE_END_REGEX);
		Pattern restartPattern = Pattern.compile(MESSAGE_RESTART_REGEX);
		
		Map<String,BoardStacks> stackMap = new HashMap<>();
		stackMap.put("L", BoardStacks.LEFT);
		stackMap.put("M", BoardStacks.MIDDLE);
		stackMap.put("R", BoardStacks.RIGHT);
		
		BoardGame board = null;
		
		try {
		
			while (!end) {
				
				if (start) {
					start =false;
					board = BoardGame.createBoardGame(BoardStacks.LEFT, BoardStacks.RIGHT, nRings);
					System.out.println("Board:");
					System.err.println(board);
				}
				
				System.out.println("waiting for input");
				currentLine=in.readLine();
				
				Matcher endMatcher = endPattern.matcher(currentLine.toUpperCase());
				if (endMatcher.matches()) {
					System.out.println("Exit game!!");
					break;
				}
				
				Matcher restartMatcher = restartPattern.matcher(currentLine.toUpperCase());
				if (restartMatcher.matches()) {
					String rings = restartMatcher.group("rings");
					if (rings!= null) {
						nRings = Integer.valueOf(rings);
					}
					start = true;
					continue;
				}
				
				Matcher moveMatcher = movePattern.matcher(currentLine.toUpperCase());
				if (moveMatcher.matches()) {
					String from = moveMatcher.group("from");
					String to = moveMatcher.group("to");
					
					BoardResponse resp = board.move(stackMap.get(from), stackMap.get(to));
					
					switch (resp) {
					case ILLEGAL_MOVE:
						System.out.println("Ilegal move");
						break;
					case VALID_MOVE:
						System.out.println(board);
						break;
					case YOU_WIN:
						System.out.println(board);
						System.out.println("You Did It! play again...");
						start=true;
						break;
					}
					continue;
				}
				
				System.out.println("Unregcognized command");
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
