package dishes.model;

import dishes.Type;

public class Dish {
	private String name;
	private int colories;
	private boolean vegetarian;
	private Type type;

	

	public Dish(String name, int colories, boolean vegetarian, Type type) {		
		this.name = name;
		this.colories = colories;
		this.vegetarian = vegetarian;
		this.type = type;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColories() {
		return colories;
	}

	public void setColories(int colories) {
		this.colories = colories;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", colories=" + colories + ", vegetarian=" + vegetarian + ", type=" + type + "]";
	}

}
