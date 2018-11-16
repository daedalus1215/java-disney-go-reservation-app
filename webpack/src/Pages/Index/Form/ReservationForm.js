import $ from 'jquery';
import 'kendo-ui';


export class ReservationForm {

    constructor(ReservationWriter) {
        this.eventName = null;
        this.dates = [];
        this.url = null;
        this.partySize = null;
        this.time = null;
        this.ReservationWriter = ReservationWriter;

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

        $("#add_btn").on("click", this.processForm);
    }


    processForm(event) {
        let self = this;

        ReservationForm.setEventName(self);
        ReservationForm.setDates(self);
        ReservationForm.setUrl(self);
        ReservationForm.setPartySize(self);
        ReservationForm.setTime(self);
        self.ReservationWriter.writeReservation(
            self.eventName,
            self.dates,
            self.url,
            self.partySize,
            self.time
        )
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