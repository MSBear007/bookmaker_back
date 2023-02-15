package shared.project.broker.service.parser;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings(value = "")
@Service
public class Googler {
    
    private WebClient client;

    Googler() {
        try (final WebClient client_ = new WebClient()) {
            client_.getOptions().setJavaScriptEnabled(false);
            client_.getOptions().setCssEnabled(false);
            this.client = client_;
        }
        catch (Exception exc) {
            log.error("Cannot initialize browser", exc);
        }
    }
    
    private String make_google_url(String team1, String team2, String sports_name, String tournament_name, Date date, String url) {
        StringBuilder to_google = new StringBuilder("https://google.com/search?q=");
        if (team1 != null) to_google.append(team1);
        if (team2 != null) to_google.append("-").append(team2);
        to_google.append("+");
        if (sports_name != null) to_google.append(sports_name)
            .append("+");
        if (tournament_name != null) to_google.append(tournament_name)
            .append("+");
        if (date != null) to_google.append(date.toString())
            .append("+");
        
        to_google
            .append("site%3a")
            .append(url);
        return to_google.toString();
    }

    public ArrayList<String> googleMatch(String team1, String team2, String sports_name, String tournament_name, Date date, String url) throws Exception {
        final HtmlPage google_search = client.getPage(make_google_url(team1, team2, sports_name, tournament_name, date, url));
        final String parsed = google_search.asXml();
        ArrayList<String> urls = all_url_links_in_html(url, new StringBuilder(parsed));
        for (String s: urls) {
            log.info(s);
        }
        return urls;
    }

    private ArrayList<String> all_url_links_in_html(String url, StringBuilder parsed_xml) {
        ArrayList<String> subss = new ArrayList<>();
        int index = 0;
        int link_index = 0;
        StringBuilder str_to_add;
        while (true) {
            index = parsed_xml.indexOf("<a href=\"/url?q=", index);
            if (index == -1) break;
            link_index = index + "a href=\"/url?q=".length() + 1;
            str_to_add = new StringBuilder();
            while (parsed_xml.charAt(link_index) != '\"' && parsed_xml.charAt(link_index) != ';') {
                str_to_add.append(parsed_xml.charAt(link_index));
                link_index++;
            }
            subss.add(str_to_add.toString().substring(0, str_to_add.length() - 4)); // this is kind of google search urls magic
            index += 1;
        }
        return subss;
    }


}
