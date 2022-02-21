package ru.learnup.vtb.spring.opera.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Opera {
    private String name;
    private String desc;
    private String ageCategory;
    private int numberTickets;
    private final List<Ticket> soldTickets; //  список проданных билетов

    @Override
    public String toString() {
        return "Опера " + name +
                ". Возрастная категория " + ageCategory +
                ". Автор, описание " + desc +
                ". Всего билетов " + numberTickets;
    }

    public void buyTicket() {
        int sz = soldTickets.size();
        if (sz <= numberTickets - 1) {
            Ticket ticket = new Ticket(++sz, true);
            soldTickets.add(ticket);
            System.out.println(ticket.toString());
        } //else {
        //  System.out.println("Все билеты проданы");
        //}
    }

    public void returnTicket() {
        if (soldTickets.isEmpty()) {
            //System.out.println("Нет проданных билетов, нельзя вернуть");
            return;
        }
        int sz = soldTickets.size();
        soldTickets.remove(sz - 1);
        System.out.println("Возвращен билет № " + sz);
    }
}