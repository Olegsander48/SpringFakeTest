package org.springframework.test.fake;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    Optional<Message> findByName(String name);
}