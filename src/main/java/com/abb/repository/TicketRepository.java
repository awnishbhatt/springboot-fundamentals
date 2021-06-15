package com.abb.repository;

import com.abb.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
