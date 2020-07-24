package com.oocl.cultivation;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Objects;

/**
 * @author Jenkin
 * @date 2020/7/25 - 0:20
 */
public class Ticket {
    private int id;

    public Ticket(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
