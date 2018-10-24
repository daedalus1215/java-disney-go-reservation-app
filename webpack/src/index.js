import {calendar} from "../node_modules/@progress/kendo-ui/js/kendo.calendar.js";

console.log("hi");

$("#calendar").kendoCalendar({
    selectable: "multiple",
    weekNumber: true,
    disableDates: ["we", "sa"]
});
