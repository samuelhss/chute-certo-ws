package br.bepid.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	
	public static void main(String[] args) {
		try {
			System.out.println(getTitleJsoup("http://globoesporte.globo.com/futebol/brasileirao-serie-a/"));
		} catch (IOException e) {
			System.out.println("ERRO");
			e.printStackTrace();			
		}
	}
	
	public static String getTitle(String address) throws IOException {
	    URL url = new URL(address);
	    BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));

	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            int start = line.indexOf("<title>");
	            int end = line.indexOf("</title>");

	            if (start != -1) {
	                return line.substring(start + "<title>".length(), end);
	            }
	        }

	        return "";
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	public static String getTitleJsoup(String adress) throws IOException {
		Document doc = Jsoup.connect(adress).get();
		Elements mainArticleContent = doc.getElementsByClass("placar-equipe");
		
		return mainArticleContent.html();
	}

}
