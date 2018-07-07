package controle;

import robos.Robo;
import terreno.Terreno;

public class Players {

	private Robo robos[];
	private int vezRobo;
	private int petroleo;
	private boolean terminou;	
	
	public Players()
	{
		this.robos	= new Robo[3];
		for(int i = 0; i < 3 ; i++)
		{
			this.robos[i]	= new Robo();
		}
		int petroleo;
		vezRobo = 0;
		
	}
	
	public int getVezdoRobo()
	{
		return this.vezRobo;
	}
	
	public boolean setPetroleo(int petroleo)
	{
		this.petroleo = petroleo;
		return true;
	}
	public boolean setVezdoRobo()
	{
		if (this.vezRobo == 2)
		{
			this.vezRobo = 0;
		} else {
			this.vezRobo++;
		}
		return true;
	}
	
	public boolean getTerminou()
	{
		return this.terminou;
	}
	
	public boolean jogar(Controle controle,Terreno terreno, boolean andarPerfurar, char posicao)
	{

		
		if(andarPerfurar)
		{
			if(posicao == 'f')
			{
				robos[vezRobo].movimentacao("anda");	
				this.setVezdoRobo();
				return true;
			}
			if(posicao == 't')
			{
				robos[vezRobo].movimentacao("direita");	
				robos[vezRobo].movimentacao("direita");	
				robos[vezRobo].movimentacao("anda");	
				this.setVezdoRobo();
				return true;
			}
			if(posicao == 'd')
			{
				robos[vezRobo].movimentacao("direita");	
				robos[vezRobo].movimentacao("anda");	
				this.setVezdoRobo();
				return true;
			}			
			if(posicao == 'd')
			{
				robos[vezRobo].movimentacao("esquerda");	
				robos[vezRobo].movimentacao("anda");	
				this.setVezdoRobo();
				return true;
			}			
		}else{
			
			if(terreno.podeProspectar(robos[vezRobo].getPosicaox(),robos[vezRobo].getPosicaoy()))
			{
				robos[vezRobo].prospecta(terreno);
				int aux = controle.getJogador(controle.getVezJogador()).getRobo().getCarga() + controle.getJogador(controle.getVezJogador()).getPetroleo();
				controle.getJogador(controle.getVezJogador()).setPetroleo(aux);
				
				this.setVezdoRobo();
				return true;
			}
			
			
		}
		
		return true;
	}
	
	
	
	public void setTerminou(boolean terminou)
	{
		this.terminou = terminou;
	}
	
	public Robo getRobo()
	{	
		return this.robos[this.vezRobo];
	}
	
	public Robo getProximoRobo()
	{
		int aux = getVezdoRobo();
		setVezdoRobo();
		
		return this.robos[aux];
	}
	
	public int getPetroleo()
	{
		return petroleo;
	}
	
}
