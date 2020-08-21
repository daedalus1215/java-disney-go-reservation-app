package disney.reservation.notification.infrastructure.WebPageEssentials.Reference;

public class HtmlElementReferrer {

    public final String DINING_RESERVATION_DATE_XPATH = "//*[@id=\"time_DetailHoursDatePicker_date\"]";
    public final String DATE_ID_XPATH = "//*[contains(@id=\"diningAvailabilityForm-searchDate\")]";
    public final String TIME_ID_XPATH = "//*[@id=\"diningAvailabilityForm-searchTime\"]";
    public final String PARTY_SIZE_XPATH = "//*[@id=\"partySize\"]";
    public final String SEARCH_TIME_BTN_ID = "dineAvailSearchButton";

    public final String FIRST_AVAILABLE_TIME_ELEMENT_XPATH = "//*[@id=\"timesContainer\"]/div[2]/div[1]";
    public final String FIRST_AVAILABLE_TIME_ELEMENT_ID = "#timesContainer > div.ctaAvailableTimesContainer > div:nth-child(1)";


    public final String DATE_SELECTOR = "\"#diningAvailabilityForm-searchDate\"";
    public final String TIME_SELECTOR = "\"#searchTime-wrapper > div.select-toggle.hoverable\"";
    public final String PARTY_SELECTOR = "\"#partySize-wrapper > div.select-toggle.hoverable\"";
}