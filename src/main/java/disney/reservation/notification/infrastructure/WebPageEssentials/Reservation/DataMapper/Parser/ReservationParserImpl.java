package disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser;

import disney.reservation.notification.infrastructure.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationParserException;
import disney.reservation.notification.domain.log.Logger;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReservationParserImpl implements ReservationParser {
    private ArrayList<JSONObject> dataHolder = new ArrayList<>();
    private Logger loggerAdapter;

    public ReservationParserImpl(Logger loggerAdapter) {
        this.loggerAdapter = loggerAdapter;
    }


    public ArrayList<JSONObject> parse(String directoryName) {
            try {
                File dir = new File(directoryName);
                return parseJsons(dir);

            } catch (Exception ex) {
                this.loggerAdapter.info(ex.getMessage());
            } catch (ReservationParserException e) {
                this.loggerAdapter.info(e.getMessage());
            }
            return null;
    }


    /**
     *  Add the JSONObject's returned from the JSONParse to the dataHolder,
     *  then return the dataHolder of json representations of reservations.
     *
     * @param targetDirectory
     * @return dataHolder
     */
    private ArrayList<JSONObject> parseJsons(File targetDirectory) throws IOException, ParseException, ReservationParserException {
        File[] jsonFiles = colateJsonFilesInDirectory(targetDirectory);


        for (File jsonFile: jsonFiles) {
            Object obj = null;
            obj = new JSONParser().parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
            dataHolder.add(jsonObject);
        }

        return dataHolder;
    }


    private File[] colateJsonFilesInDirectory(File dir) throws ReservationParserException {
        File[] jsonFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".json");
            }
        });

        if (jsonFiles == null) {
            throw new ReservationParserException("No json files in: " + dir.getAbsoluteFile().toString());
        }

        return jsonFiles;
    }
}
