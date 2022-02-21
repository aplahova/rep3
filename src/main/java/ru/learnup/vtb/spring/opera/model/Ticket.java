package ru.learnup.vtb.spring.opera.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ticket {
    private int ticketNo = 0;
    private Boolean sold = false;

    @Override
    public String toString() {
        String s = (sold) ? " продан " : " в наличии ";
        return "Билет № " + ticketNo + s;
    }

}