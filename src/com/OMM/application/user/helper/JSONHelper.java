package com.OMM.application.user.helper;

import java.util.List;

import com.OMM.application.user.model.CotaParlamentar;
import com.OMM.application.user.model.Parlamentar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONHelper {
	public static List<Parlamentar> listaParlamentarFromJSON(String str) {
		Gson gson = new Gson();
		List<Parlamentar> lista = gson.fromJson(str,
				new TypeToken<List<Parlamentar>>() {
				}.getType());
		return lista;
	}

	public static List<CotaParlamentar> listaCotaParlamentarFromJSON(String str) {
		Gson gson = new Gson();
		List<CotaParlamentar> lista = gson.fromJson(str,
				new TypeToken<List<CotaParlamentar>>() {
				}.getType());
		return lista;
	}
}
