package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entity.*;

public class LeerEscribirPDA {

	public void crearPDA(PDA pda) {
		System.out.println("Escribiendo archivo JSON");
		JSONObject obj = new JSONObject();
		obj.put("nombre", pda.getNombre());
		obj.put("actual", this.crearEstado(pda.getActual()));

		JSONArray estados = new JSONArray();
		for (int i = 0; i < pda.getEstados().length; i++) {
			estados.add(this.crearEstado(pda.getEstados()[i]));
		}
		obj.put("estados", estados);

		obj.put("pila", pda.getPila());

		JSONArray reglas = new JSONArray();
		for (int i = 0; i < pda.getReglas().length; i++) {
			reglas.add(this.crearRegla(pda.getReglas()[i]));
			System.out.println(pda.getReglas()[i].toString());
		}
		obj.put("reglas", reglas);
		System.out.println("tamaño de reglas vector: " + pda.getReglas().length);

		try {

			FileWriter file = new FileWriter("JSON\\" + pda.getNombre() + ".json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj + "\nTerminada la escritura del archivo JSON");

	}

	public JSONObject crearEstado(Estado estado) {
		JSONObject e = new JSONObject();

		e.put("nombre", estado.getEstado());
		e.put("inicial", estado.isInicial());
		e.put("acept", estado.isAcept());

		return e;
	}

	public JSONObject crearRegla(Regla regla) {
		JSONObject e = new JSONObject();

		e.put("estadoActual", this.crearEstado((regla.getEstadoActual())));
		e.put("lectura", regla.getLectura());
		e.put("pila", regla.getPila());
		e.put("estadoSiguiente", this.crearEstado(regla.getEstadoSiguiente()));
		e.put("orden", regla.getOrden());
		e.put("apilar", regla.getApilar());

		return e;
	}

	public PDA leerPDA(String nombre) {

		System.out.println("Leyendo archivo JSON");
		PDA aux = new PDA();
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("JSON\\" + nombre + ".json")) {

			Object obj = jsonParser.parse(reader);

			JSONObject pda = (JSONObject) obj;

			JSONArray estados = new JSONArray();
			estados = (JSONArray) pda.get("estados");
			Estado[] est = new Estado[estados.size()];
			int sizee = estados.size();
			for (int i = 0; i < sizee; i++) {
				JSONObject estado = (JSONObject) estados.get(i);
				est[i] = new Estado((String) estado.get("nombre"), (boolean) estado.get("inicial"),
						(boolean) estado.get("acept"));
			}

			JSONArray reglas = new JSONArray();
			reglas = (JSONArray) pda.get("reglas");
			Regla[] reg = new Regla[reglas.size()];
			int sizer = reglas.size();
			for (int i = 0; i < sizer; i++) {
				JSONObject regla = (JSONObject) reglas.get(i);

				long orden = (long) regla.get("orden");

				JSONObject actual_ = (JSONObject) regla.get("estadoActual");
				Estado actual = new Estado((String) actual_.get("nombre"), (boolean) actual_.get("inicial"),
						(boolean) actual_.get("acept"));
				
				JSONObject siguiente_ = (JSONObject) regla.get("estadoSiguiente");
				Estado siguiente = new Estado((String) siguiente_.get("nombre"), (boolean) siguiente_.get("inicial"),
						(boolean) siguiente_.get("acept"));
				
				reg[i] = new Regla(actual, (String) regla.get("lectura"), (String) regla.get("pila"), siguiente,
						(int) orden, (String) regla.get("apilar"));
				System.out.println(reg[i].toString() + "..." + i);
			}

			System.out.println("tamaño de reglas json: " + reglas.size());

			aux = new PDA((String) pda.get("nombre"), est, new Pila(), reg);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Archivo JSON leído \nAutómata creado");
		return aux;
	}
	
	public void borrarPDA(String nombre) {
		File json = new File("JSON\\" + nombre + ".json");
		if(json.delete()) {
			System.out.println("Archivo" + nombre + ".json eliminado");
		} else {
			System.out.println(nombre + ".json no pudo ser eliminado");
		}
	}

}
