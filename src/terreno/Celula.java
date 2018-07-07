package terreno;



public class Celula {
	
	private boolean trava; 				//true ta prospectando false nao ta
	private float pressaoSubterranea; 	//intervalo [0,1]
	private float profundidade;			//intervalo [0,1]
	private float coeficienteDeErro;	//intervalo [0,0.1]
	private int petroleo;				//intervalo [0,5]
	
	public Celula(float pressaoSubterranea, float profundidade,
			float coeficienteDeErro, int petroleo){
		this.pressaoSubterranea = pressaoSubterranea;
		this.profundidade = profundidade;
		this.coeficienteDeErro = coeficienteDeErro;
		this.petroleo = petroleo;
	}
	
	
	public int getPetroleo() {
		return petroleo;
	}
	public void setPetroleo(int petroleo) {
		this.petroleo = petroleo;
	}
	public boolean isTrava() {
		return trava;
	}
	public void setTrava(boolean trava) {
		this.trava = trava;
	}
	public float getPressaoSubterranea() {
		return pressaoSubterranea;
	}
	public void setPressaoSubterranea(float pressaoSubterranea) {
		this.pressaoSubterranea = pressaoSubterranea;
	}
	public float getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}
	public float getCoeficienteDeErro() {
		return coeficienteDeErro;
	}
	public void setCoeficienteDeErro(float coeficienteDeErro) {
		this.coeficienteDeErro = coeficienteDeErro;
	}
	public void decrescePetroleo() {
		this.petroleo = this.petroleo - 1;
	}

}
