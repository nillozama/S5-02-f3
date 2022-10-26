package cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.services;

import java.util.List;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.dto.DiceRollDTO;

public interface DiceRollService {
	
	public List <DiceRollDTO> getAllDiceRolls();
	public List<DiceRollDTO> findByPlayer(int id);
	public void saveOrUpdate(DiceRollDTO diceRollDTO);
	public void deleteAllPlaysByPlayer(int id);
	public DiceRollDTO playGame();
	public float getTotalAverage();

}
