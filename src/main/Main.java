package main;

import java.io.IOException;

import controle.Controle;
import robos.Robo;
import terreno.Terreno;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner (System.in);
		Controle controle = Controle.instanciaControle();
		Terreno terreno = new Terreno();
		boolean sair = true;		
		
		controle.setarJogo(0, 0, 0);
		controle.setarJogo(0, 4, 1);
		controle.setarJogo(0, 7, 2);
		
		controle.setarJogo(1, 0, 4);
		controle.setarJogo(1, 4, 5);
		controle.setarJogo(1, 7, 5);
		int aux = 0;
		while(sair) 
		{
	
			int jogador = controle.getVezJogador() + 1;
			System.out.println("jogar :" + jogador );
			System.out.println("petroleo do jogador:"+ controle.getJogador(controle.getVezJogador()).getPetroleo());		
			System.out.println("robo:"+ controle.getJogador(controle.getVezJogador()).getVezdoRobo());				
			System.out.println("posição:"+ controle.getJogador(controle.getVezJogador()).getRobo().getPosicaox() + ","+controle.getJogador(controle.getVezJogador()).getRobo().getPosicaoy());		
			System.out.println("petroleo do robo:"+ controle.getJogador(controle.getVezJogador()).getRobo().getCarga());		
						
			
			boolean andarPerfurar = false; // true para andar e false para perfurar;
			char posicao = 'a';
			

			System.out.println("Andar ou furar? (Digite true para andar e false para furar");
			
			andarPerfurar= entrada.nextBoolean();
			
			if(andarPerfurar)
			{	
				System.out.println("Andar para frente = 'f'");			
				System.out.println("Andar para direita = 'd'");
				System.out.println("Andar para esquerda = 'e'");
				System.out.println("Andar para traz = 't'");
				posicao = entrada.next().charAt(0);
			}	
			
			
			controle.startGame(controle, terreno, andarPerfurar, posicao);
			
			System.out.println("'c' para continuar e  's' para sair ");
			char proximo = entrada.next().charAt(0);
			if(proximo == 's')
				sair = false;
		}
		int jogador = controle.getVezJogador() + 1;
		System.out.println("jogar :" + jogador );
		System.out.println("petroleo do jogador:"+ controle.getJogador(controle.getVezJogador()).getPetroleo());		
		controle.startGame(controle, terreno, true, 'a');
		jogador = controle.getVezJogador() + 1;
		System.out.println("jogar :" + jogador );
		System.out.println("petroleo do jogador:"+ controle.getJogador(controle.getVezJogador()).getPetroleo());		
		
		
	}

}
