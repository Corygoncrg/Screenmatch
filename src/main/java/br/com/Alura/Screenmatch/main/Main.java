package br.com.Alura.Screenmatch.main;


import br.com.Alura.Screenmatch.model.Episode;
import br.com.Alura.Screenmatch.model.EpisodeData;
import br.com.Alura.Screenmatch.model.SeasonData;
import br.com.Alura.Screenmatch.service.ConsumeApi;
import br.com.Alura.Screenmatch.service.ConvertData;
import br.com.Alura.Screenmatch.model.SeriesData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    Scanner input  = new Scanner(System.in);
    private final String ADDRESS = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=suaApiKey";
    ConsumeApi consume = new ConsumeApi();
    ConvertData converter = new ConvertData();
    public void showMenu() {
        System.out.println("Type the series you want to research.");
        String seriesName = input.nextLine();
        String json = consume.obtainInfo(ADDRESS + seriesName.replace(" ", "+") + API_KEY);
        SeriesData data = converter.getData(json, SeriesData.class);
        System.out.println(data);

        List<SeasonData> seasons = new ArrayList<>();

                for (int i = 1; i<= data.totalSeasons(); i++)
        {
            json = consume.obtainInfo(ADDRESS + seriesName.replace(" ", "+") + "&season=" + i +API_KEY);
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            seasons.add(seasonData);
        }
        seasons.forEach(System.out::println);
//                for (int i = 0; i < data.totalSeasons(); i++){
//                    List<EpisodeData> episodeSeason = seasons.get(i).episodes();
//                    for (int j = 0; j < episodeSeason.size(); j++){
//                        System.out.println(episodeSeason.get(j).title());
//                    }
//                    seasons.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));
List<EpisodeData> episodeData = seasons.stream()
        .flatMap(s -> s.episodes().stream())
        .collect(Collectors.toList());

        System.out.println("Top 5 episodes\n");

episodeData.stream()
        .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
        .sorted(Comparator.comparing(EpisodeData::rating).reversed())
        .limit(5)
        .forEach(System.out::println);

List<Episode> episodes = seasons.stream()
        .flatMap(s -> s.episodes().stream()
        .map(d -> new Episode(s.season(), d)))
        .collect(Collectors.toList());
episodes.forEach(System.out::println);
                }
    }

