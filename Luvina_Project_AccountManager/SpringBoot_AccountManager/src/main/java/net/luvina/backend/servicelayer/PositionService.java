package net.luvina.backend.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.backend.datalayer.IPositionRepository;
import net.luvina.entity.Position;

@Service
public class PositionService implements IPositionService {

	@Autowired
	private IPositionRepository repository;

	@Override
	public List<Position> getAllPosition() {
		return repository.findAll();
	}

	@Override
	public Position getPositionById(int idInput) {
		return repository.findById(idInput).get();
	}

	@Override
	public Position getPositionByName(String namePos) {
		return repository.findByName(namePos);
	}

}
