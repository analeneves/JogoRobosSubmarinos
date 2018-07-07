
package robos;

import java.util.ArrayList;
import java.util.HashMap;

import terreno.Celula;
import terreno.Terreno;

public class Robo {
	
	public static int robo;
	private int posicaox;
	private int posicaoy;
	private float pressao;
	private float gradiente;
	private int tempo; 
	private int carga;
	private float profundidade;
	
	private boolean flagD = false;
	private boolean flagE = false;
	
	
	public int getPosicaox() {
		return posicaox;
	}
	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}
	
	public int getPosicaoy() {
		return posicaoy;
	}
	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}
	public float getPressao() {
		return pressao;
	}
	public void setPressao(float pressao) {
		this.pressao = pressao;
	}
	public float getGradiente() {
		return gradiente;
	}
	public void setGradiente(float gradiente) {
		this.gradiente = gradiente;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	public float getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}
	
	
	public String getPosXY() {
		String posXY;
		posXY = "("+ getPosicaox()+","+getPosicaoy()+")";
		return posXY;
	}
	
	public HashMap<String,String> sensoriamento(){
		HashMap<String,String> dados = new HashMap<String,String>();
		dados.put("posicao", getPosXY());
		dados.put("pressao", Float.toString(getPressao()));
		dados.put("gradiente", Float.toString(getGradiente()));
		dados.put("tempo", Integer.toString(tempo));
		return dados;
	}
	
	public void movimentacao(String comando) {
		switch (comando) {
			case "anda":
				
				if(( flagE == false ) && ( flagD == false ) && ( getPosicaoy() > 0 )) {
					setPosicaoy( getPosicaoy() - 1);
				}else if( ( flagE == false ) && ( flagD == true ) && ( getPosicaoy() < 7 ) ) {
					setPosicaox( getPosicaox() + 1);
				}else if( ( flagE == true ) && ( flagD == false ) && ( getPosicaoy() < 7 ) ) {
					setPosicaoy( getPosicaoy() + 1);
				}else if( ( flagE == true ) && ( flagD == true ) && ( getPosicaoy() > 0 ) ) {
					setPosicaox( getPosicaox() - 1);
				}
				
				break;
				
			case "direita":
				if(( flagE == false ) && ( flagD == false )) {
					flagD = true;
				}else if( ( flagE == false ) && ( flagD == true ) ) {
					flagE = true;
					flagD = false;
				}else if( ( flagE == true ) && ( flagD == false ) ) {
					flagD = true;
				}else if( ( flagE == true ) && ( flagD == true ) && ( getPosicaoy() > 0 ) ) {
					flagD = false;
					flagE = false;
				}
				
				break;
				
			case "esquerda":
				
				if(( flagE == false ) && ( flagD == false )) {
					flagD = true;
					flagE = true;
				}else if( ( flagE == false ) && ( flagD == true ) ) {
					flagE = false;
					flagD = false;
				}else if( ( flagE == true ) && ( flagD == false ) ) {
					flagD = true;
					flagE = false;
				}else if( ( flagE == true ) && ( flagD == true ) && ( getPosicaoy() > 0 ) ) {
					flagD = false;
					flagE = true;
				}
				
				break;
		}
	}
	
	
	public void prospecta( Terreno terreno) {

		terreno.bloqueiaRegiao(getPosicaox(), getPosicaoy());
		while(terreno.getTerrenoPetroleo(getPosicaox(), getPosicaoy())> 0){
			
			this.carga = this.carga + 1;	
			terreno.decrescePetroleoLocal(getPosicaox(), getPosicaoy());
			
		}

	
	}

}