package net.luvina.DTO;

import net.luvina.entity.EPositionName;

public class PositionDTO {

	private int id;
	private EPositionName name;

	public PositionDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EPositionName getName() {
		return name;
	}

	public void setName(EPositionName name) {
		this.name = name;
	}

}
