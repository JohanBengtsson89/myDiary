import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiaryEntries {
    private User user;
    private String title;
    private String entry;
    private LocalDate date = LocalDate.now();

    private static List<DiaryEntries> temporary = new ArrayList<>();
    private static List<DiaryEntries> listOfEntries = new ArrayList<>();

    public static void addEntry (DiaryEntries newEntry) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File filePath = new File("src/main/resources/entries.json");
        Path path = Paths.get("src/main/resources/entries.json");

        temporary = List.of(mapper.readValue(path.toFile(), DiaryEntries[].class));
        listOfEntries.addAll(temporary);
        listOfEntries.add(newEntry);

        mapper.writeValue(path.toFile(), listOfEntries);
        /*String filePath = ("src/main/resources/" + newEntry.getUser() +".json");
        mapper.writeValue(Paths.get(filePath).toFile(), newEntry);*/
    }

    public DiaryEntries(User user, String title, LocalDate date, String entry) {
        this.user = user;
        this.title = title;
        this.date = date;
        this.entry = entry;
    }

    public DiaryEntries() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
