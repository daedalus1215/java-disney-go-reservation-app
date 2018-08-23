import Adapter.InfoLoggerAdapter;
import WebPageEssentials.Factory.ReservationResolverFactory;
import WebPageEssentials.Requestor.PageRequestor;
import WebPageEssentials.Requestor.Factory.PageRequestorFactoryForOhana;
import WebPageEssentials.ReservationResolver;
import com.gargoylesoftware.htmlunit.html.*;
import config.UserCredentialConfig;


import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {
        String subject = "testing now";
        String body = "testing body now";
        InfoLoggerAdapter logger = new InfoLoggerAdapter();
        sendFromGMail(logger, UserCredentialConfig.USERNAME, UserCredentialConfig.PASSWORD, UserCredentialConfig.RECIPIENT, subject, body);
    }

    private static void sendFromGMail(InfoLoggerAdapter logger, String from, String pass, String to, String subject, String body) {

        try {
            PageRequestor pageRequestor = (new PageRequestorFactoryForOhana()).createPageRequestor();
            HtmlPage page = pageRequestor.getPage();

            ReservationResolver reservationResolver = new ReservationResolverFactory().createReservationResolver();





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

//            webClient.waitForBackgroundJavaScript(10 * 1000);


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
