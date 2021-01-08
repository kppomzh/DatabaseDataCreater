package NetworkUtils;

import Utils.Factorys.getEnvRecordFactory;
import com.facebook.presto.jdbc.internal.jackson.core.type.TypeReference;
import com.facebook.presto.jdbc.internal.jackson.databind.ObjectMapper;
import dataStructure.RuntimeEnvironment;
import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class JsonProtocol implements Protocol<RuntimeEnvironment> {
    @Override
    public RuntimeEnvironment decode(ByteBuffer readBuffer, AioSession aioSession) {
        byte length = readBuffer.get(readBuffer.position());
        if (length+1 < readBuffer.remaining()) {
            return null;
        }
        byte[] b = new byte[readBuffer.get()];
        readBuffer.get(b);

        return getEnvRecordFactory.getRuntimeEnv(decodeJson(new String(b)));
    }

    private Map<String,String> decodeJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> res;
        try {
            res = mapper.readValue(json,new TypeReference<Map<String, String>>(){});
        } catch (IOException e) {
            res=new HashMap<>();
        }
        return res;
    }
}
