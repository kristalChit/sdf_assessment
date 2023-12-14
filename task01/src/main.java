package sdf.assessment.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static final int COL_APP = 0;
    public static final int COL_CATEGORY = 1;
    public static final int COL_RATING = 2;

    public static void main (String[] args) throws IOException {

        if (args.length <= 0) {
            System.err.println("Missing CSV");
            System.exit(1); 
        
            System.out.printf("Processing %s\n", args[0]);
        
        try (FileReader fr = new FileReader(args[0])) {
            BufferedReader br = new BufferedReader (fr);
            Map<String, List<App>> classified = br.lines()
                .skip(1)
                .map(line -> line.trim().replaceAll("^\\sa-zA-Z)-9]","").split(",").toLowerCase)
                .map(Lines -> new App(columns[COL_APP], columns[COL_CATEGORY], Double.parsedouble (columns[COL_RATING])))
                .collect(Collectors.groupingBy(app -> app.getCategory()));
}
        int lineCount=0;
        for (String key:categorize.keySet()){
            lineCount += (Categorised.get(key)).size();
            List<App> discarded = new ArrayList<>();
            List<App> approved = new ArrayList<>();
            Double highest = 0.0;
            String highestApp = "";
            Double lowest = 0.0;
            String lowestApp = "";
            Double totalRating = 0.0;
            int appCount = 0;
            for (Apps app:categorized.get(key)){
                Double rating = app.getRating();
                if(rating.isNaN()){
                        discarded.add(app);
                        continue;
                } else {
                        approved.add(app);

                } if(rating>highest){
                        highest = rating;
                        highestApp = app.getApp();

                } if(rating<lowest){
                        lowest = rating;
                        lowestApp = app.getApp();
                
                } total += rating;
            }
            Double average = total/approved.size();  
               
            System.out.println("Category: %s%n", catagory);
            System.out.printf("Highest: %s, %3.2f%n" + highestApp, highestRating);
            System.out.printf("Lowest: %s, %3.2f%n" + lowestApp, loweestRating);
            System.out.printf("Average %3.2f%n" + average);
            System.out.printf("Count: %d%n" + approved);
            System.out.printf("Discarded: %d%n" + discarded);
        }
        System.out.printf("Total lines in file: %d%n",lineCount);
           
        }
        br.close();
    }
}
         
