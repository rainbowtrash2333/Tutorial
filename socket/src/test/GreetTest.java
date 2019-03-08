package test;

import org.junit.Assert;
import socket.Greet.GreetClient;

/**
 * @author Twikura
 * @create 2019/3/7 23:28
 */
public class GreetTest {
    @org.junit.Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws Exception{
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        Assert.assertEquals("hello client", response);
    }
}
