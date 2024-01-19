package br.com.Alura.Screenmatch;

import br.com.Alura.Screenmatch.main.Main;
import br.com.Alura.Screenmatch.model.EpisodeData;
import br.com.Alura.Screenmatch.model.SeasonData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();



	}
}