package terreno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class Terreno {
	private Celula[][] terreno;
	public Terreno() throws IOException {
		
		terreno = new Celula[8][8];
		JSONParser parser = new JSONParser();
		try {
			
			String pressaoSubterranea;
			String coeficienteDeErro;
			String profundidade;
			String petroleo;
			JSONObject celulaI;
			Object obj = parser.parse(new FileReader("terreno1.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray celula = (JSONArray) jsonObject.get("celula");
			
			Iterator<?> i = celula.iterator();
			int in = 0;
			int j = 0;
			while (i.hasNext()) {
	            celulaI = (JSONObject) i.next();
	            
	            pressaoSubterranea = (String) celulaI.get("pressaoSubterranea");
	            //System.out.println(pressaoSubterranea);
	            
	            coeficienteDeErro = (String) celulaI.get("coeficienteDeErro");
	            //System.out.println(coeficienteDeErro);
	            
	            profundidade = (String) celulaI.get("profundidade");
	            //System.out.println(profundidade);
	            
	            petroleo = (String) celulaI.get("petroleo");
	            //System.out.println(petroleo);
	            
	            terreno[in][j] = new Celula(Float.parseFloat(pressaoSubterranea), Float.parseFloat(coeficienteDeErro), Float.parseFloat(profundidade), Integer.parseInt(petroleo));
	            j++;
	            if(j == 8) {
	            	j = 0;
	            	in++;
	            }
			}
			
			 
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }	
      
	}
	
	public void imprimeTerreno() {
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0; j < 8 ; j++) {
				System.out.print(terreno[i][j].getPressaoSubterranea() + " ");
				System.out.print(terreno[i][j].getCoeficienteDeErro()  + " ");
				System.out.print(terreno[i][j].getProfundidade()  + " ");
				System.out.print(terreno[i][j].getPetroleo()  + " ");
				System.out.print(" ");
			}
			System.out.println("\n");
		}
	}
	
	public void bloqueiaRegiao(int x, int y){
		terreno[x][y].setTrava(true);
		if( y == 0 && x == 0 ){
			terreno[x+1][y].setTrava(true);
			terreno[x][y+1].setTrava(true);
			
		}else if( y == 0 && x == 7 ){
			terreno[x-1][y].setTrava(true);
			terreno[x][y+1].setTrava(true);
			
		}else if( y == 7 && x == 0 ){
			terreno[x+1][y].setTrava(true);
			terreno[x][y-1].setTrava(true);
			
		}else if( y == 7 && x == 7 ){
			terreno[x-1][y].setTrava(true);
			terreno[x][y-1].setTrava(true);
			
		}else if( y == 0 && x != 7 && x != 0 ){
			terreno[x-1][y].setTrava(true);
			terreno[x+1][y].setTrava(true);
			terreno[x][y+1].setTrava(true);
			
		}else if( x == 0 && y != 7 && y != 0 ){
			terreno[x][y-1].setTrava(true);
			terreno[x+1][y].setTrava(true);
			terreno[x][y+1].setTrava(true);
			
		}else if( y == 7 && x != 7 && x != 0 ){
			terreno[x-1][y].setTrava(true);
			terreno[x][y-1].setTrava(true);
			terreno[x+1][y].setTrava(true);
			
		}else if( x == 7 && y != 7 && y != 0 ){
			terreno[x][y-1].setTrava(true);
			terreno[x-1][y].setTrava(true);
			terreno[x][y+1].setTrava(true);
			
		}else if( y != 0 && y != 7  && x != 0 && x != 7 ){
			terreno[x+1][y].setTrava(true);
			terreno[x][y-1].setTrava(true);
			terreno[x][y+1].setTrava(true);
			terreno[x-1][y].setTrava(true);
		}
	}

	public Celula[][] getTerreno() {
		return terreno;
	}

	public int getTerrenoPetroleo(int x, int y) {
		return terreno[x][y].getPetroleo();
	}

	public void setTerreno(Celula[][] terreno) {
		this.terreno = terreno;
	}
	
	public void decrescePetroleoLocal(int x, int y){
		terreno[x][y].decrescePetroleo();
	}

	public boolean podeProspectar(int x, int y){
		if(terreno[x][y].isTrava())
		{
			return false;
		}
			return true;
	}
	
	
	
}
