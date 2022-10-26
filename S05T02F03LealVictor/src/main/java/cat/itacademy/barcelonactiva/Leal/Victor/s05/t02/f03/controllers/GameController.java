package cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.dto.PlayerDTO;

public interface GameController {
	
	public ResponseEntity<String> addPlayer(String name);
	public ResponseEntity<PlayerDTO> updatePlayer( PlayerDTO playerDTO);
	public ResponseEntity<String> playGame(int idPlayerDTO);
	public ResponseEntity<HttpStatus> deleteDiceRolls(int id);
	public ResponseEntity<List<PlayerDTO>> getAllPlayers();
	public ResponseEntity<List<DiceRollDTO>> getAllDiceRolls(int idPlayerDTO);
	public ResponseEntity<Float> getAverageRanking();
	public ResponseEntity<PlayerDTO> getWorstPlayer();
	public ResponseEntity<PlayerDTO> getBestPlayer();
	public ResponseEntity<List<PlayerDTO>> getAverageRankingList();

}
