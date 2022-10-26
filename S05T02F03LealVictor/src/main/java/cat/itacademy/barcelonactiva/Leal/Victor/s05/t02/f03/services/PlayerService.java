package cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.services;

import java.util.List;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.dto.PlayerDTO;


public interface PlayerService {
	
	public List <PlayerDTO> getAllPlayers();
	public PlayerDTO getPlayerById(int id);
	public void save(PlayerDTO playerDTO);
	public void update(PlayerDTO playerDTO);
	public void delete(int id);
	public PlayerDTO getWinner();
	public PlayerDTO getLoser();
	public float getTotalAverage();
	public boolean findPlayerByName(String name);
}
