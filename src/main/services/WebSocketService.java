package main.services;
@Service
public class WebSocketService {
    
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(String username, String message) {
        messagingTemplate.convertAndSendToUser(username, "/queue/reply", message);
    }
}
