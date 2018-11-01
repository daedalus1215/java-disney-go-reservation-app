import $ from 'jquery';
import 'kendo-ui';


export class ReservationForm {
    constructor() {
        this.dates = new Array();
        this.time = null;

        let self = this;

        $("#numeric").kendoNumericTextBox();

        $("#calendar").kendoCalendar({
            selectable: "multiple",
            weekNumber: true,
            change: self.initCalendar
        });

        $("#timepicker").kendoTimePicker({
            dateInput: true
        });


        $("#addBtn").kendoButton({
            icon: "check",
            click: this.processForm
        });
    }

    init() {
        this.dates = new Array();
        this.time = null;

        let self = this;

        $("#numeric").kendoNumericTextBox();

        $("#calendar").kendoCalendar({
            selectable: "multiple",
            weekNumber: true,
            change: self.initCalendar
        });

        $("#timepicker").kendoTimePicker({
            dateInput: true
        });


        $("#addBtn").kendoButton({
            icon: "check",
            click: this.processForm
        });
    }



    /**
     * clear the dates on the ReservationForm, before we repopulate.
     * @param {_Event} e
     */
      initCalendar(e) {
        let self = this;

        self.dates = new Array();

        e._selectDates.forEach(function (d) {
            let date = kendo.toString(d, 'd');
            self.dates.push(date);
            console.log("Change :: " + date);
        });
    }


    processForm(e) {
        let timePicked = '';
    }


}