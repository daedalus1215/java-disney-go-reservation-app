package disney.reservation.notification.domain.WebPageEssentials.Reference;

public class HtmlElementReferrer {
    public final String DINING_RESERVATION_DATE_XPATH   = "//*[@id=\"time_DetailHoursDatePicker_date\"]";
    public final String DATE_ID_XPATH                   = "//*[@id=\"diningAvailabilityForm-searchDate\"]";
    public final String TIME_ID_XPATH                   = "//*[@id=\"diningAvailabilityForm-searchTime\"]";
    public final String PARTY_SIZE_XPATH                = "//*[@id=\"partySize\"]";
    public final String SEARCH_TIME_BTN_ID              = "dineAvailSearchButton";

    public final String FIRST_AVAILABLE_TIME_ELEMENT_XPATH = "//*[@id=\"timesContainer\"]/div[2]/div[1]";
    public final String FIRST_AVAILABLE_TIME_ELEMENT_ID = "#timesContainer > div.ctaAvailableTimesContainer > div:nth-child(1)";
}
