
import {ReservationForm} from "./Form/ReservationForm";
import $ from "jquery";
import {ReservationEventJSONWriter} from "../../Reservation/ReservationEventJSONWriter";
// var resForm = require("./Form/ReservationForm");


$(document).ready(function () {
    new ReservationForm(new ReservationEventJSONWriter());
    // resForm.init();
});

// resForm.init;