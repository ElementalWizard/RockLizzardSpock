package main;

public enum Move {
	SCISSOR("Scissor"),
	PAPER("Paper"),
	ROCK("Rock"),
	LIZZARD("Lizzard"),
	SPOK("Spok");
	
	private String name;
	
	Move(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Move getMove(String moveName) {
		return Move.valueOf(moveName.toUpperCase());
	}
}
