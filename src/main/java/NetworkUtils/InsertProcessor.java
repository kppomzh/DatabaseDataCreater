package NetworkUtils;

import main.control.network.NetworkStart;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.util.Map;

public class InsertProcessor implements MessageProcessor<Map<String, String>> {
    private NetworkStart backGround;

    public InsertProcessor(NetworkStart backGround){
        this.backGround=backGround;
    }

    @Override
    public void process(AioSession aioSession, Map<String,String> jsonConfig) {
        String SQLString=jsonConfig.get("SQL");
    }

    @Override
    public void stateEvent(AioSession aioSession, StateMachineEnum stateMachineEnum, Throwable throwable) {

    }
}
