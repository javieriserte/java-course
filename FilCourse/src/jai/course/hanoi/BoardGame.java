package jai.course.hanoi;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

	////////////////////////////////////////////////////////////////////////////
	// Intance variables
	private int numberOfRings;
	private List<Ring> left;
	private List<Ring> middle;
	private List<Ring> right;
	private BoardStacks endingStack;
	////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public BoardGame(int numberOfRings, List<Ring> left, List<Ring> middle,
			List<Ring> right, BoardStacks ending) {
		super();
		this.setNumberOfRings(numberOfRings);
		this.setLeft(left);
		this.setMiddle(middle);
		this.setRight(right);
		this.setEndingStack(ending);
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Public interface
	public BoardResponse move(BoardStacks source, BoardStacks destination) {
		
		Ring ring = this.getRingFrom(source); 
		
		if (ring == null) {
			return BoardResponse.IlegalMove;
			
		}
		
		boolean success = this.putRingIn(destination,ring);
		
		if (!success) {
			
			this.putRingIn(source,ring);
			return BoardResponse.IlegalMove;
			
		}
		
		boolean win = this.checkWinnig();
		
		if (win) {
			
			return BoardResponse.YouWin;
					
		} else {
			
			return BoardResponse.ValidMode;
			
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		char base = '#';
		String eol = System.getProperty("line.separator");
		
		List<List<Ring>> stacks = new ArrayList<>();
		stacks.add(this.getLeft());
		stacks.add(this.getMiddle());
		stacks.add(this.getRight());
		
		sb.append(base + eol);
	
		
		for (List<Ring> stack : stacks) {
			
			sb.append(base);
			
			int counter = this.getNumberOfRings();
			
			for (Ring ring : stack) {
				
				sb.append(ring.getRadio() + "-");
				
				counter--;
				
			}
			
			while (counter>0) {
				
				sb.append("--");
				
				counter--;
				
			}
			
			sb.append(eol);
			
		}

		sb.append(base+eol);
		
		return sb.toString();
		
	}
	// End of publie interface
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Private methods
	private boolean checkWinnig() {
		
		int stackSize = this.getCurrentStack(this.getEndingStack()).size();
		int ringNumber = this.getNumberOfRings();
		
		System.out.println("stack size = "+stackSize+ "| number of rings in game = " + ringNumber + " | equals = " + (stackSize == ringNumber));
		return (stackSize == ringNumber);
		
	}
	
	private boolean putRingIn(BoardStacks destination,Ring ring) {
		
		List<Ring> currentStack = getCurrentStack(destination);
		
		if (currentStack.isEmpty()) {
			
			currentStack.add(ring);
			
			return true;
			
		} else {
			
			int radioOfLastRing = currentStack.get(currentStack.size()-1).getRadio();
			
			if (radioOfLastRing>ring.getRadio()) {
				
				currentStack.add(ring);

				return true;
			} else {
				
				return false;
				
			}
			
			
		}
		
	}

	private Ring getRingFrom(BoardStacks source) {

		List<Ring> currentStack = getCurrentStack(source);
		
		if (currentStack != null) {
			
			return currentStack.remove(currentStack.size()-1);
			
		} else {
			
			return null;
			
		}
	}

	private List<Ring> getCurrentStack(BoardStacks source) {
		List<Ring> currentStack = null;
		switch (source) {
		case left: currentStack = this.getLeft(); break;
		case middle: currentStack = this.getMiddle(); break;
		case right: currentStack = this.getRight(); break;
		}
		return currentStack;
	}
	
	private int getNumberOfRings() {
		return numberOfRings;
	}

	private List<Ring> getLeft() {
		return left;
	}

	private List<Ring> getMiddle() {
		return middle;
	}

	private List<Ring> getRight() {
		return right;
	}

	private BoardStacks getEndingStack() {
		return endingStack;
	}
	
	private void setNumberOfRings(int numberOfRings) {
		this.numberOfRings = numberOfRings;
	}

	private void setLeft(List<Ring> left) {
		this.left = left;
	}

	private void setMiddle(List<Ring> middle) {
		this.middle = middle;
	}

	private void setRight(List<Ring> right) {
		this.right = right;
	} 

	private void setEndingStack(BoardStacks endingStack) {
		this.endingStack = endingStack;
	}
	
	// End of private methods 
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Class methods
	public static BoardGame createBoardGame(BoardStacks initial, BoardStacks ending, int numberOfRings) {
		
		if (initial == ending) {
			
			return null;
			
		}
		
		List<Ring> initialStack = new ArrayList<>();
		
		for (int i = numberOfRings ; i> 0 ; i--) {
			
			initialStack.add(new Ring(i));
			
		}
		
		switch (initial) {
			case left: return new BoardGame(numberOfRings, initialStack, new ArrayList<Ring>(), new ArrayList<Ring>(), ending);
			case middle: return new BoardGame(numberOfRings,  new ArrayList<Ring>(), initialStack,new ArrayList<Ring>(), ending);
			case right: return new BoardGame(numberOfRings, new ArrayList<Ring>(), new ArrayList<Ring>(), initialStack, ending);
		}
		return null;
		
		
	}
	////////////////////////////////////////////////////////////////////////////


	
}
