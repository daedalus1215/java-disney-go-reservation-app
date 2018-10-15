package disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser;

import disney.reservation.notification.Adapter.Logger.InfoLoggerAdapter;
import disney.reservation.notification.Adapter.Logger.Logger;
import disney.reservation.notification.WebPageEssentials.Reservation.DataMapper.Parser.Exception.ReservationparserException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;


public class ReservationParserImpl implements ReservationParser {
    private ArrayList<JSONObject> dataHolder = new ArrayList<>();
    private Logger loggerAdapter = null;

    public ReservationParserImpl(Logger loggerAdapter) {
        this.loggerAdapter = loggerAdapter;
    }


    public ArrayList<JSONObject> parse(String directoryName) {
            try {
                File dir = new File(directoryName);
                return parseJsons(dir);

            } catch (Exception ex) {
                this.loggerAdapter.info(ex.getMessage());
            } catch (ReservationparserException e) {
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
    private ArrayList<JSONObject> parseJsons(File targetDirectory) throws IOException, ParseException, ReservationparserException {
        File[] jsonFiles = colateJsonFilesInDirectory(targetDirectory);


        for (File jsonFile: jsonFiles) {
            Object obj = null;
            obj = new JSONParser().parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
            dataHolder.add(jsonObject);
        }

        return dataHolder;
    }


    private File[] colateJsonFilesInDirectory(File dir) throws ReservationparserException {
        File[] jsonFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".json");
            }
        });

        if (jsonFiles == null) {
            throw new ReservationparserException("No json files in: " + dir.getAbsoluteFile().toString());
        }

        return jsonFiles;
    }
}
