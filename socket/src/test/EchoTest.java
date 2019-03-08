package test;

import org.junit.*;
import socket.Greet.GreetClient;

/**
 * @author Twikura
 * @create 2019/3/7 23:39
 */
public class EchoTest {

    private GreetClient client;
    @Before
    public void setup() throws Exception {
        client = new GreetClient();
        client.startConnection("127.0.0.1", 4444);
    }
    @After
    public void tearDown()throws Exception  {
        client.stopConnection();
    }
    @Test
    public void givenClient_whenServerEchosMessage_thenCorrect() throws Exception {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
        String resp4 = client.sendMessage(".");

        Assert.assertEquals("hello", resp1);
        Assert.assertEquals("world", resp2);
        Assert.assertEquals("!", resp3);
        Assert.assertEquals("good bye", resp4);
    }
}
