package net.luvina.backend.servicelayer;

import java.util.List;

import net.luvina.entity.Position;

public interface IPositionService {
	public List<Position> getAllPosition();

	public Position getPositionById(int id);

	public Position getPositionByName(String namePos);

}
