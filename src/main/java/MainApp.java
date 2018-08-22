import Adapter.InfoLoggerAdapter;
import Adapter.MailerAdapter;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLElement;
import config.UserCredentialConfig;
import org.w3c.dom.html.HTMLDivElement;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        String subject = "testing now";
        String body = "testing body now";
        InfoLoggerAdapter logger = new InfoLoggerAdapter();
        sendFromGMail(logger, UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT, subject, body);
    }

    private static void sendFromGMail(InfoLoggerAdapter logger, String from, String pass, String to, String subject, String body) {

        try {
            WebClient webClient = new WebClient();
            String url = "https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/";
            System.out.println("Loading page now: " + url);
            HtmlPage page = webClient.getPage("https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/");
            webClient.waitForBackgroundJavaScript(5 * 1000);

            ArrayList<HtmlHeading3> d = (ArrayList) page.getByXPath("/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/div[1]/h3");
            for (int i = 0; i < d.size(); i++) {
                System.out.println(d.get(i).asText());
            }


            System.out.println("Grabbing first field");
            // Date Calendar Input field
            HtmlInput dateCalendarField = page.getFirstByXPath("//*[@id=\"diningAvailabilityForm-searchDate\"]");
            dateCalendarField.setValueAttribute("09/18/2018");
            System.out.println("set the first field " + dateCalendarField.asText());


            System.out.println("Grabbing second field");
            // Time Drop down field
            HtmlSelect timeSelectField = page.getFirstByXPath("//*[@id=\"diningAvailabilityForm-searchTime\"]");
            HtmlOption option = timeSelectField.getOptionByValue("80000714");
            timeSelectField.setSelectedAttribute(option, true);
            System.out.println("set the second field " + option.asText());


            // Party Size Drop down field
            HtmlSelect partySizeSelectField = page.getFirstByXPath("//*[@id=\"partySize\"]");
            HtmlOption partySizeOption = partySizeSelectField.getOptionByValue("4");
            partySizeSelectField.setSelectedAttribute(partySizeOption, true);

            HtmlButton findTableButton = (HtmlButton) page.getElementById("dineAvailSearchButton");
            System.out.println("clicking on the submit button");
            findTableButton.click();

            webClient.waitForBackgroundJavaScript(10 * 1000);


            String time_DetailHoursDatePicker_date = "time_DetailHoursDatePicker_date";
            HtmlSpan titleNotAvailable = (HtmlSpan) page.getElementById(time_DetailHoursDatePicker_date);

            System.out.println("Info title" + titleNotAvailable.asText());


            String diningReservationInfoTitle = "/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/span/div[2]/div[4]/div[2]/span[1]";
            ArrayList<HtmlSpan> diningReservationInfoTitleDiv = (ArrayList) page.getByXPath(diningReservationInfoTitle);
            for(int i = 0; i < diningReservationInfoTitleDiv.size(); i++) {
                System.out.println("dining reservation info title div: " + diningReservationInfoTitleDiv.get(i).asText());
            }

            //            MailerAdapter mailer = new MailerAdapter(from, pass, to);
//            mailer.setSubjectAndBody(subject, body);
//            mailer.sendMessage();
//
//        } catch (AddressException ae) {
//            logger.info("Address Exception thrown: " + ae.getMessage());
//            ae.printStackTrace();
//        } catch (MessagingException me) {
//            logger.info("Message Exception thrown: " + me.getMessage());
//            me.printStackTrace();
        } catch (Exception e) {
            logger.info("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }

        logger.info("Finished.");
    }


}
