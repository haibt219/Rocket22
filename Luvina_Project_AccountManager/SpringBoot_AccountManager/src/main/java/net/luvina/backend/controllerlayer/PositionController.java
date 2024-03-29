package net.luvina.backend.controllerlayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.luvina.DTO.PositionDTO;
import net.luvina.backend.servicelayer.IPositionService;
import net.luvina.entity.Position;

@RestController
@RequestMapping(value = "api/v1/positions")
@CrossOrigin("*")
public class PositionController {

	@Autowired
	private IPositionService service;

	// Get All Position
	@GetMapping()
	public ResponseEntity<?> getAllPosition() {
		List<Position> listPositions = service.getAllPosition();

		List<PositionDTO> listPositionDTOs = new ArrayList<>();

		for (Position position : listPositions) {
			PositionDTO positionDTO = new PositionDTO();
			positionDTO.setId(position.getId());
			positionDTO.setName(position.getName());
			listPositionDTOs.add(positionDTO);
		}

		return new ResponseEntity<>(listPositionDTOs, HttpStatus.OK);
	}

	// Get Position By Id
	@GetMapping("{id}")
	public ResponseEntity<?> getPositionById(@PathVariable(name = "id") int idInput) {
		Position position = service.getPositionById(idInput);

		PositionDTO positionDTO = new PositionDTO();
		positionDTO.setId(position.getId());
		positionDTO.setName(position.getName());

		return new ResponseEntity<>(positionDTO, HttpStatus.OK);
	}

	// Get Position By Name
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getPositionByName(@PathVariable(name = "name") String namePos) {
		Position position = service.getPositionByName(namePos);

		PositionDTO positionDTO = new PositionDTO();
		positionDTO.setId(position.getId());
		positionDTO.setName(position.getName());

		return new ResponseEntity<>(positionDTO, HttpStatus.OK);
	}

}
