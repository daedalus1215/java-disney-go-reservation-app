import $ from 'jquery';
import 'kendo-ui';
import { ReservationEventJSONWriter } from '../../../Reservation/ReservationEventJSONWriter';


export class ReservationForm {

    constructor() {
        this.eventName = null;
        this.dates = [];
        this.url = null;
        this.partySize = null;
        this.time = null;
        
        let self = this;

        $("#party_size").kendoNumericTextBox();


        $("#calendar").kendoCalendar({
            selectable: "multiple",
            weekNumber: true,
        });

        $("#time_picker").kendoTimePicker({
            dateInput: true,
        });



        $("#add_btn").kendoButton({
            icon: "check"
        });

        $("#add_btn").on("click", ReservationForm.processForm);
    }


    static processForm(event) {
        let reservationEventWriter = new ReservationEventJSONWriter();

        ReservationForm.setEventName(self);
        ReservationForm.setDates(self);
        ReservationForm.setUrl(self);
        ReservationForm.setPartySize(self);
        ReservationForm.setTime(self);
        reservationEventWriter.writeReservation(
            self.eventName,
            self.dates,
            self.url,
            self.partySize,
            self.time
        );
    }


    static setDates(resFormContext) {
        resFormContext.dates = new Array();

        var calendar = $("#calendar").data("kendoCalendar");
        var dates = calendar.selectDates();

        dates.forEach(function(d) {
            let date = kendo.toString(d, 'd');
            resFormContext.dates.push(date);
        });

        console.log(resFormContext.dates);
    }

    static setEventName(resFormContext) {
        resFormContext.eventName = $("#event_name").val();
    }

    static setUrl(resFormContext) {
        resFormContext.url = $("#url").val();
    }

    static setPartySize(resFormContext) {
        resFormContext.partySize = $("#party_size").val();
    }

    static setTime(resFormContext) {
        resFormContext.time = $("#time_picker").val();
    }

}