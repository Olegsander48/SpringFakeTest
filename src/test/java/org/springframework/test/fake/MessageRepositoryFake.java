package org.springframework.test.fake;

import java.util.Optional;

public class MessageRepositoryFake
        extends CrudRepositoryFake<Message, Integer>
        implements MessageRepository {

    public Optional<Message> findByName(String name) {
        return memory.values().stream()
                .filter(message -> message.getName().equals(name))
                .findFirst();
    }
}