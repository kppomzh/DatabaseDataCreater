package NetworkUtils;

import main.control.network.NetworkStart;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

public class InsertProcessor implements MessageProcessor {
    private NetworkStart backGround;

    public InsertProcessor(NetworkStart callback){
        backGround=callback;
    }

    @Override
    public void process(AioSession aioSession, Object o) {

    }

    @Override
    public void stateEvent(AioSession aioSession, StateMachineEnum stateMachineEnum, Throwable throwable) {

    }
}
