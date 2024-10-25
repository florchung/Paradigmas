package MarsRoverProject;

import java.util.Arrays;
import java.util.List;

public abstract class Message {
    public abstract void Execute(MarsRover rover);
    private static List<Message> availableMessages = Arrays.asList(
            new Forward(), new Backward(), new Left(), new Right(), new OpenUpperHatch(), new OpenLowerHatch(),
            new CloseHatch(), new AspirateAir(), new CollectSample()
    );

    public Message(char name) {
        this.name = name;
    }

    public char name;

    public boolean applies(char command) {
        return command == name;
    }

    public static Message getAvailableMessages(char letter) {
        return availableMessages.stream()
                .filter(message -> message.applies(letter))
                .findFirst().orElse(null);
    }
}
