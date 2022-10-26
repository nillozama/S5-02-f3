package cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.domain.DiceRoll;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.repository.DiceRollRepository;


@Service
public class DiceRollServiceImpl implements DiceRollService{
	
	@Autowired
	private DiceRollRepository drRepository;
	@Autowired
	ModelMapper modelMapper;


	@Override
	public List<DiceRollDTO> getAllDiceRolls() {
		
		List <DiceRoll> allPlays=new ArrayList<DiceRoll>();
		drRepository.findAll().forEach(dr->allPlays.add(dr));
		List <DiceRollDTO> allPlaysDTO=new ArrayList<DiceRollDTO>();
		
		if(!allPlays.isEmpty()) {
			
			allPlays.forEach(dr->allPlaysDTO.add(modelMapper.map(dr,DiceRollDTO.class)));
		}
		
		return allPlaysDTO;
	}

	@Override
	public List<DiceRollDTO> findByPlayer(int id) {
		
		List <DiceRoll> playerPlays=new ArrayList<DiceRoll>();
		
		//drRepository.findByPlayer(id).forEach(dr->playerPlays.add(dr));
		drRepository.findPlaysByPlayer(id).forEach(dr->playerPlays.add(drRepository.findById(dr).get()));
		List <DiceRollDTO> playerPlaysDTO=new ArrayList<DiceRollDTO>();
		
		
		if(!playerPlays.isEmpty()) {
			
			playerPlays.forEach(dr->playerPlaysDTO.add(modelMapper.map(dr,DiceRollDTO.class)));	
		}
		
		return playerPlaysDTO;
		
	}
	
	@Override
	public void saveOrUpdate(DiceRollDTO diceRollDTO) {
		
		DiceRoll diceRoll=modelMapper.map(diceRollDTO, DiceRoll.class);
		drRepository.save(diceRoll);

	}

	@Override
	public void deleteAllPlaysByPlayer(int id) {
		
		drRepository.findPlaysByPlayer(id).forEach(dr->drRepository.deleteById(dr));
	}

	@Override
	public DiceRollDTO playGame() {

		return null;
	}

	@Override
	public float getTotalAverage() {
		
		float totalAverage= Math.round(drRepository.selectWinnersDiceRolls()*10000)/drRepository.selectDiceRolls();
		
		return totalAverage/100;

	}
}
