package controle;

import terreno.Terreno;

public class Controle 
{
	
	static Controle controle = new Controle(); 
	public Players jogador[];
	private int vezJogador;
	
	private Controle ()
	{
		this.jogador	= new Players[2];
		for(int i=0; i < 2 ; i++)
		{
			this.jogador[i] = new Players();
		}
		vezJogador = 0;
	}
	
	public void setarJogo(int aux, int x, int y)
	{
		this.jogador[aux].getRobo().setPosicaox(x);
		this.jogador[aux].getRobo().setPosicaoy(y);				
		
		this.jogador[aux].setVezdoRobo();				
	}
	
	public static Controle instanciaControle()
	{
		return controle;
	}

	public int getVezJogador()
	{
		return this.vezJogador;
	}
	
	public Players getJogador(int aux)
	{
		return this.jogador[aux];
	}
	
	public static Controle getControle() {
		return controle;
	}

	public static void setControle(Controle controle) {
		Controle.controle = controle;
	}

	public Players getJogador1(int x) {
		return jogador[x];
	}

	public void setJogador(Players[] jogador) {
		this.jogador = jogador;
	}

	public void setVezJogador(int vezJogador) {
		this.vezJogador = vezJogador;
	}

	public void setVezJogador()
	{
		if(vezJogador== 0)
		{	
			this.vezJogador = 1;
		}else {
			
			this.vezJogador = 0;
		}
	}
	
	
	
	public boolean startGame(Controle controle, Terreno terreno,boolean andarPerfurar, char posicao )
	{
			
		controle.jogador[controle.getVezJogador()].jogar(controle, terreno ,andarPerfurar ,posicao);

		setVezJogador();
			
		return true;
	
	}








}
