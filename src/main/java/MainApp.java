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
            HtmlPage page = webClient.getPage("https://disneyworld.disney.go.com/dining/polynesian-resort/ohana/");


            // Date Calendar Input field
            HtmlInput dateCalendarField = page.getElementByName("searchDate");
            dateCalendarField.setValueAttribute("09/18/2018");


            // Time Drop down field
            HtmlSelect timeSelectField = page.getElementByName("searchTime");
            HtmlOption option = timeSelectField.getOptionByValue("Dinner");
            timeSelectField.setSelectedAttribute(option, true);


            // Party Size Drop down field
            HtmlSelect partySizeSelectField = page.getElementByName("partySize");
            HtmlOption partySizeOption = partySizeSelectField.getOptionByValue("4");
            partySizeSelectField.setSelectedAttribute(partySizeOption, true);

            HtmlSubmitInput findTableButton =
                    page.getElementByName("findTableButton"); // sometimes it's "btnK"
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
