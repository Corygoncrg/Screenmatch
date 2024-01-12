package br.com.Alura.Screenmatch;

import br.com.Alura.Screenmatch.Service.ConsumeApi;
import br.com.Alura.Screenmatch.Service.ConvertData;
import br.com.Alura.Screenmatch.model.SeriesData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumeApi consumeApi = new ConsumeApi();
		String json = consumeApi.obtainInfo("http://www.omdbapi.com/?t=supernatural&apikey=b9b5453b");
		System.out.println(json);
		ConvertData converter = new ConvertData();
		SeriesData data = converter.getData(json, SeriesData.class);
		System.out.println(data);
	}
}