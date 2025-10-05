import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class PrivateMessageService {
    
    private final SimpMessagingTemplate messagingTemplate;

    public PrivateMessageService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendPrivateMessage(String username, String message) {
        messagingTemplate.convertAndSendToUser(username, "/queue/messages", message);
    }
}