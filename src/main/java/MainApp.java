import Adapter.InfoLoggerAdapter;
import Adapter.MailerAdapter;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import config.UserCredentialConfig;

import javax.mail.*;
import javax.mail.internet.*;

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
            System.out.println("Connecting to the dining resort");
            HtmlPage page = webClient.getPage("https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/");
            System.out.println("Connected");

            System.out.println("Grabbing first field");
            // Date Calendar Input field
            HtmlInput dateCalendarField = page.getFirstByXPath("//*[@id=\"diningAvailabilityForm-searchDate\"]");
            dateCalendarField.setValueAttribute("09/18/2018");
            System.out.println("set the first field " + dateCalendarField.getTextContent());


            System.out.println("Grabbing second field");
            // Time Drop down field
            HtmlSelect timeSelectField = page.getFirstByXPath("//*[@id=\"diningAvailabilityForm-searchTime\"]");
            HtmlOption option = timeSelectField.getOptionByValue("80000714");
            timeSelectField.setSelectedAttribute(option, true);
            System.out.println("set the second field " + option.getText());


            // Party Size Drop down field
            HtmlSelect partySizeSelectField = page.getFirstByXPath("//*[@id=\"partySize\"]");
            HtmlOption partySizeOption = partySizeSelectField.getOptionByValue("4");
            partySizeSelectField.setSelectedAttribute(partySizeOption, true);

            HtmlButton findTableButton =
                    page.getElementByName("findTableButton");
            page=findTableButton.click();

            HtmlDivision resultStatsDiv =
                    page.getFirstByXPath("/html/body/div[1]/div[2]/div[4]/div/div/div[4]/div[2]/span/div[2]/div[4]/div[2]/span[1]");

            String textResults = resultStatsDiv.getTextContent();

            System.out.println(resultStatsDiv.asText()); // About 309,000 results

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
