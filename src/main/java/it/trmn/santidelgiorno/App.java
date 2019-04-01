package it.trmn.santidelgiorno;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hornetq.utils.json.JSONArray;
import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Hello world!
 *
 */
public class App {
	private static String baseUrl = "https://www.chiesacattolica.it/santo-del-giorno/?data-liturgia=";
	static Calendar date;
	static SimpleDateFormat formatter;
	static JSONObject json;
	static JSONArray array;
	

	public static void main(String[] args) throws JSONException {
		json = new JSONObject();
		System.out.println("Hello World!");
		formatter = new SimpleDateFormat("yyyyMMdd");
		date = Calendar.getInstance();
		Calendar endDate = (Calendar) date.clone();
		endDate.add(Calendar.DAY_OF_MONTH, 19);
		date.set(2019, 0, 0);
		
		while (date.before(endDate)) {

			getData();
		}

		System.out.println(json);
	}

	private static void getData() {

		date.add(Calendar.DAY_OF_MONTH, 1);

		String data = formatter.format(date.getTime());
		try {
			

			JSONObject item = new JSONObject();

			Document doc = Jsoup.connect(baseUrl + data).get();
			Element santoDelGiorno = doc.getElementsByClass("cci_content_single_title").get(0);
			item.put("santo", santoDelGiorno.text());
			Element altriSanti = doc.getElementsByClass("cci-santo-del-giorno-altri-santi-container").size() > 0 ? doc.getElementsByClass("cci-santo-del-giorno-altri-santi-container").get(0) : null;

			if(altriSanti!=null){
				item.put("altri", altriSanti.text().replaceAll("Altri Santi ", "").split("; "));
			}

			json.put(data.substring(4, 8) ,item);
			
			System.out.println(data.substring(4, 8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
