package corbit;

import corbit.segdep.SRParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dhiller on 3/19/14.
 */
public class PerformanceTesting {

    public void performanceTest() throws IOException {
        //substitute some large file here(we have a proprietary file we can't release so sorry :( )
        String property = System.getProperty("user.dir");
        System.out.println("prop=" + property);
        FileReader reader = new FileReader("src/test/resources/tweets.txt");
        BufferedReader r = new BufferedReader(reader);

        List<String> chineseSnippets = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            Map result = mapper.readValue(line, Map.class);
            String original = (String) result.get("tweet");
            chineseSnippets.add(original);
        }

        SRParser parser = new SRParser();
    }

}
