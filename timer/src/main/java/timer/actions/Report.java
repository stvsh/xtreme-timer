package timer.actions;

import timer.base.TimerApp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;

public class Report extends Actions {

    public Report() {
        this.action = this.getClass().getSimpleName().toLowerCase();
        this.help = "Report {from:yyyy-mm-dd} {to:yyyy-mm-dd}";
    }

    @Override
    protected void perform(String[] input, TimerApp app) {
        createReport(app, input);
    }

    private void createReport(TimerApp app, String[] input) {
        if (input.length == 1) {
            app.createReport(null, null, "default.csv");
        } else {
            LocalDate date = LocalDate.parse(input[1]);
            Instant start = date.atStartOfDay(TimeZone.getDefault().toZoneId()).toInstant();
            LocalDate date2 = LocalDate.parse(input[2]);
            Instant stop = date2.plusDays(1).atStartOfDay(TimeZone.getDefault().toZoneId()).toInstant();
            if (input.length == 3) {
                app.createReport(start, stop, "default.csv");
            } else {
                app.createReport(start, stop, input[3]);
            }
        }
    }
}
