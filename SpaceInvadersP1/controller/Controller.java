package controller;


import java.util.Scanner;
import java.util.Random;

import logic.Game;
import utils.GamePrinter;


public class Controller {
	
	//Atributos
	private Game game;
	private Scanner in;
	private GamePrinter g;
	
	//Constructor
	public Controller(Game g) {
		this.game = g;
		this.in = new Scanner(System.in);
		this.g = new GamePrinter(game, 8, 9);
	}
	//Metodos
	public void run() {
		String[] command;
		while(!game.winCondition() && !game.loseCondition()) {
			this.g = new GamePrinter(game, 8, 9);
			this.game.info();
			System.out.print(g);
			System.out.print("Command > ");
			command = in.nextLine().toLowerCase().split(" ");
			if(!command[0].isEmpty()) {
				if(command[0].charAt(0) == 'r' && command.length == 1) {
					game = new Game(game.getDifficulty().toString(), game.getSeed());
				}
				else{
					while(!this.game.selectCommand(command)) {
					System.out.print("Comando erroneo, vuelva a introducirlo");
					command = in.nextLine().toLowerCase().split(" ");
					}
				}
				if(command[0].charAt(0) != 'l' && command[0].charAt(0) != 'h') {
					game.update();
				}	
			}
			else {
				game.update();
			}
		}
		if(game.winCondition()) {
			this.g = new GamePrinter(game, 8, 9);
			this.game.info();
			System.out.print(g);
			System.out.print("Player wins!!!!\r\n" + "Points: " + game.getPoints());
		}
		if(game.loseCondition()) {
			this.g = new GamePrinter(game, 8, 9);
			this.game.info();
			System.out.print(g);
			System.out.print("Aliens win :(");
		}
	}
	
}