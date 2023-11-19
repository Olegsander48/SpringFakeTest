package org.springframework.test.fake;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageServiceTest {

    @Test
    public void whenFindByName() {
        var message = new Message();
        message.setId(1);
        message.setName("SpringFakeTest");
        var service = new MessageService(new MessageRepositoryFake());
        service.save(message);
        var finded = service.findByName(message.getName());
        assertThat(finded.isPresent()).isTrue();
    }
}
