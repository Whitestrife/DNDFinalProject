package DungeonSource;

public class VisionPotion extends Items{

	private String name = "Vision Potion";
	
	public String getName() {
		return name;
	}
	
	public void useItem() {
		System.out.println("I used a vision potion");
	}
}
