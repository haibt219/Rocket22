package net.luvina.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import net.luvina.entity.Position;

public interface IPositionRepository extends JpaRepository<Position, Integer> {

	public Position findByName(String name);
}
