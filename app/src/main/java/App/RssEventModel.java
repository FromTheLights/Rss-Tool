package App;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class RssEventModel {
    private String title;
    private String link;
    private String guid;
    private String date;
    private String description;
    private static ArrayList<RssEventModel> rssEvents = new ArrayList<>();
    private static ArrayList<RssEventListener> listeners = new ArrayList<>();

    public RssEventModel(String title, String link, String guid, String date, String description) {
        this.title = title;
        this.link = link;
        this.guid = guid;
        this.date = date;
        this.description = description;
    }

    public static void parseSource(String url) {
        SAXBuilder sax = new SAXBuilder();
        Document doc = new Document();

        try {
            doc = sax.build(url);
        } catch (Exception e) {
            System.out.println("Error opening URL"); // can be handled better
        }

        List<Element> items = doc.getRootElement().getChild("channel").getChildren("item");

        for (Element item : items) {
            rssEvents.add(
                    new RssEventModel(item.getChildText("title"), item.getChildText("link"), item.getChildText("guid"),
                            item.getChildText("pubDate"), item.getChildText("description")));
        }
    }



    public static void Save(String path, String name) {
        Element rss = new Element("rss");
        Element channel = new Element("channel");
        Document document = new Document(rss);

        rss.setAttribute("version", "2.0");
        rss.addContent(channel);

        for (RssEventModel rssEvent : rssEvents) {
            Element item = new Element("item");

            Element title = new Element("title");
            title.setText(rssEvent.getTitle());
            item.addContent(title);

            Element link = new Element("link");
            link.setText(rssEvent.getLink());
            item.addContent(link);

            Element guid = new Element("guid");
            guid.setText(rssEvent.getGuid());
            item.addContent(guid);

            Element pubDate = new Element("pubDate");
            pubDate.setText(rssEvent.getDate());
            item.addContent(pubDate);

            Element description = new Element("description");
            description.setText(rssEvent.getDescription());
            item.addContent(description);

            channel.addContent(item);
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(document, new FileWriter(path + "/"
                    + name + ".xml"));
        } catch (IOException e) {
            System.out.println("Error creating file");
        }
    }

    //private static Document convertInDocument(String path, String name) {}

    public static void Add(String title, String link, String guid, String date, String description) {
        rssEvents.add(new RssEventModel(title, link, guid, date, description));
        notifyListeners();
    }

    public void modify(String title, String link, String guid, String date,
            String description) {
        this.setTitle(title);
        this.setLink(link);
        this.setGuid(guid);
        this.setDate(date);
        this.setDescription(description);
        notifyListeners();

    }

    public void remove() {
        rssEvents.remove(this);
        notifyListeners();
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getGuid() {
        return guid;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ArrayList<RssEventModel> getEvents() {
        return rssEvents;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static void addListener(RssEventListener listener) {
        listeners.add(listener);
    }
    public static void notifyListeners() {
        for (RssEventListener listener : listeners) {
            listener.onChange();
        }
    }
}
