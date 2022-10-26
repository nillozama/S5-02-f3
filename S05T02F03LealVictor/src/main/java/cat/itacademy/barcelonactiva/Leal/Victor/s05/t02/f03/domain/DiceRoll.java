package cat.itacademy.barcelonactiva.Leal.Victor.s05.t02.f03.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="tiradas")
public class DiceRoll {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	@Column (name="puntuacion")
	private byte score;
	@Column (name="mano_ganadora")
	private boolean winningRoll;
	@Column (name="mensaje")
	private String message;
	@Column (name="valor_dado_1")
	private int dice1;
	@Column (name="valor_dado_2")
	private int dice2;
	@JsonIgnore
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="jugador_id")
	Player player;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte getScore() {
		return score;
	}
	public void setScore(byte score) {
		this.score = score;
	}
	public boolean getWinningRoll() {
		return winningRoll;
	}
	public void setWinningRoll(boolean winningRoll) {
		this.winningRoll = winningRoll;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getDice1() {
		return dice1;
	}
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	public int getDice2() {
		return dice2;
	}
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	
}

