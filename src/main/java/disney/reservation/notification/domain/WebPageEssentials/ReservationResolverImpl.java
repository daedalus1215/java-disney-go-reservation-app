package disney.reservation.notification.domain.WebPageEssentials;


import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import disney.reservation.notification.domain.WebPageEssentials.Reference.HtmlElementReferrer;
import disney.reservation.notification.domain.WebPageEssentials.Requestor.PageRequestorInterface;
import disney.reservation.notification.domain.log.Logger;
import disney.reservation.notification.domain.mail.Mailer;
import disney.reservation.notification.domain.reservations.value_objects.Event;
import java.io.IOException;
import java.util.List;
import org.w3c.dom.html.HTMLDivElement;


public class ReservationResolverImpl implements ReservationResolver {

    private final Mailer mailer;
    private final HtmlElementReferrer htmlElementReferrer;
    private final Logger logger;


    public ReservationResolverImpl(Mailer mailer, HtmlElementReferrer htmlElementReferrer,
        Logger logger) {
        this.mailer = mailer;
        this.htmlElementReferrer = htmlElementReferrer;
        this.logger = logger;
    }


    public void checkForAvailabilityAndEmail(List<Event> events, PageRequestorInterface requestor) {
        System.out.println("ReservationResolverImpl.checkForAvailabilityAndEmail");
        events.forEach(event -> {
            this.tryToConnectToEventsWebpage(requestor, event.getUrl());
            this.setDateFieldForReservation(requestor, event.getDate());
            this.setTimeFieldForReservation(requestor, event.getTime());
            this.setPartySizeForReservation(requestor, event.getPartySize());
            this.submitForm(requestor);

            try {
                this.sendMessage(ofNullable(
                    requireNonNull(getReservationIfAvailable(requestor)).getTextContent())
                    .orElse("Issue with getting the title on the reservation"));

            } catch (Exception e) {
                this.logger.info("NO, current availabilities around: "
                    + "\n Reservation Name: " + event.getName()
                    + "\n Event Date: " + event.getDate()
                    + "\n Event Time: " + event.getTime()
                    + "\n Seating: " + event.getPartySize());
            } finally {
                requestor.close();
            }
        });
    }

    private void tryToConnectToEventsWebpage(PageRequestorInterface requestor, String url) {
        try {
            requestor.visitWebPage(url);
        } catch (IOException exception) {
            logger.info("WebClient issue with connecting to: ".concat(url));
        }
    }

    private void setDateFieldForReservation(PageRequestorInterface requestor, String date) {
        try {
            final HtmlInput dateCalendarField = (HtmlInput) requestor
                .getElementByXPath(this.htmlElementReferrer.DATE_ID_XPATH);
            dateCalendarField.setValueAttribute(date);
        } catch (Exception e) {
            logger.info("WebClient issue with getting date field: ".concat(e.getMessage()));
        }
    }

    private void setTimeFieldForReservation(PageRequestorInterface requestor, String time) {
        try {
            final HtmlSelect timeSelectField = (HtmlSelect) requestor
                .getElementByXPath(this.htmlElementReferrer.TIME_ID_XPATH);
            final HtmlOption option = timeSelectField.getOptionByValue(time);
            timeSelectField.setSelectedAttribute(option, true);
        } catch (Exception e) {
            logger.info("WebClient issue with getting time field: ".concat(e.getMessage()));
        }
    }

    private void setPartySizeForReservation(PageRequestorInterface requestor, int partySize) {
        try {
            final HtmlSelect partySizeSelectField = (HtmlSelect) requestor
                .getElementByXPath(this.htmlElementReferrer.PARTY_SIZE_XPATH);
            final HtmlOption partySizeOption = partySizeSelectField
                .getOptionByValue(Integer.toString(partySize));
            partySizeSelectField.setSelectedAttribute(partySizeOption, true);
        } catch (Exception e) {
            logger.info("WebClient issue with getting partySize field: ".concat(e.getMessage()));
        }
    }

    private void submitForm(PageRequestorInterface requestor) {
        try {
            requestor.getElementById(this.htmlElementReferrer.SEARCH_TIME_BTN_ID)
                .click();
        } catch (Exception e) {
            logger.info("WebClient issue with submitting the form");
        }
    }

    /**
     * Wait 10 seconds for the page load, then check to see if the dining reservation info title div
     * is set, if it is than we know we can set a reservation.
     *
     * @param requestor
     * @return
     */
    private HTMLDivElement getReservationIfAvailable(PageRequestorInterface requestor) {
        final String firstAvailableElementXpath = htmlElementReferrer.FIRST_AVAILABLE_TIME_ELEMENT_ID;
        try {
            final HTMLDivElement diningReservationInfoTitleDiv = (HTMLDivElement) requestor
                .getElementById(firstAvailableElementXpath);
            if (diningReservationInfoTitleDiv != null) {
                return diningReservationInfoTitleDiv;
            } else {
                logger.info("Issue with getting the dining reservation info title div!!");
            }
        } catch (Exception e) {
            logger.info(
                "Issue getting the dining reservation info title div: ".concat(e.getMessage()));
        }
        return null;
    }

    private void sendMessage(String title) throws Exception {
        logger.info("ReservationEntity potential alert: ".concat(title));
        mailer.setSubjectAndBody("ReservationEntity potential alert: ",
            "For the day and time: ".concat(title)
        );
        mailer.sendMessage();
    }
}
