package pb3;

import com.google.protobuf.Descriptors;
import helloworld.Helloworld;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Drive2 {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Drive2.class);

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Helloworld.Inner inner = Helloworld.Inner.newBuilder().setI32(111).build();
        Helloworld.Outer outer = Helloworld.Outer.newBuilder().setInner(inner).build();
        show(outer.getAllFields());

        System.out.println("---");
        show(Helloworld.Outer.getDefaultInstance().getAllFields());
    }

    private static void show(Map<Descriptors.FieldDescriptor, Object> map) {
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            logger.info("{} {}", entry.getKey(), entry.getValue());
        }
    }
}
