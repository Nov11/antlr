package pb;

import com.google.protobuf.Descriptors;
import helloworld.Helloworld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PbFieldWalker {
    private static final Logger logger = LoggerFactory.getLogger(PbFieldWalker.class);

    public static void main(String[] args) {
        Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().build();
        Map<Descriptors.FieldDescriptor, Object> map = request.getAllFields();

        for (Map.Entry<Descriptors.FieldDescriptor, Object> e : map.entrySet()) {
            logger.info("{} {}", e.getKey(), e.getValue());
        }
    }
}
