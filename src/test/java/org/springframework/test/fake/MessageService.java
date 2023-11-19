package org.springframework.test.fake;

import java.util.Optional;

public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Optional<Message> findByName(String name) {
        return messageRepository.findByName(name);
    }

    public void save(Message message) {
        messageRepository.save(message);
    }
}
