package test;

import org.junit.Assert;
import org.junit.Test;
import socket.Greet.GreetClient;

/**
 * @author Twikura
 * @create 2019/3/8 8:50
 */
public class MultiTest {
    @Test
    public void givenClient1_whenServerResponds_thenCorrect () throws Exception {
        GreetClient client1 = new GreetClient();
        client1.startConnection("127.0.0.1", 5555);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage(".");

        Assert.assertEquals(msg1, "hello");
        Assert.assertEquals(msg2, "world");
        Assert.assertEquals(terminate, "bye");
    }

    @Test
    public void givenClient2_whenServerResponds_thenCorrect () throws Exception {
        GreetClient client2 = new GreetClient();
        client2.startConnection("127.0.0.1", 5555);
        String msg1 = client2.sendMessage("hello");
        String msg2 = client2.sendMessage("world");
        String terminate = client2.sendMessage(".");

        Assert.assertEquals(msg1, "hello");
        Assert.assertEquals(msg2, "world");
        Assert.assertEquals(terminate, "bye");
    }
    
}
