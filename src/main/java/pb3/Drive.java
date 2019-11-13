//package pb3;
//
//import com.google.protobuf.Descriptors;
//import com.google.protobuf.GeneratedMessageV3;
//import helloworld.Helloworld;
//import org.apache.commons.lang3.reflect.FieldUtils;
//import org.apache.commons.lang3.reflect.MethodUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Drive {
//    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Drive.class);
//
//    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().setName("name").build();
////        Map<Descriptors.FieldDescriptor, Object> map = request.getAllFields();
////        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
////            logger.info("{} {}", entry.getKey(), entry.getValue());
////        }
//
////        Descriptors.FieldDescriptor fieldDescriptor = new Descriptors.FieldDescriptor();
////        request.getField(Helloworld.HelloRequest.NAME_FIELD_NUMBER);
//
////        Field field = FieldUtils.getDeclaredField(Helloworld.class, "internal_static_helloworld_HelloRequest_fieldAccessorTable", true);
//
//        com.google.protobuf.GeneratedMessageV3.FieldAccessorTable table = (GeneratedMessageV3.FieldAccessorTable) MethodUtils.invokeMethod(request, true, "internalGetFieldAccessorTable");
////                = (com.google.protobuf.GeneratedMessageV3.FieldAccessorTable) field.get(null);
//        Field field = FieldUtils.getDeclaredField(GeneratedMessageV3.FieldAccessorTable.class, "descriptor");
//        Descriptors.Descriptor descriptor = (Descriptors.Descriptor) field.get(request);
////        List<Descriptors.FieldDescriptor> fields = descriptor.getFields();
//        Map<Descriptors.FieldDescriptor, Object> map = getAllFieldsMutable(descriptor, false);
//        logger.info("table : {}", table);
//    }
//
//    private static Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(
//            Descriptors.Descriptor descriptor,
//            boolean getBytesForString) {
//        final TreeMap<Descriptors.FieldDescriptor, Object> result =
//                new TreeMap<Descriptors.FieldDescriptor, Object>();
//        final List<Descriptors.FieldDescriptor> fields = descriptor.getFields();
//
//        for (int i = 0; i < fields.size(); i++) {
//            Descriptors.FieldDescriptor field = fields.get(i);
//            final Descriptors.OneofDescriptor oneofDescriptor = field.getContainingOneof();
//
//            /*
//             * If the field is part of a Oneof, then at maximum one field in the Oneof is set
//             * and it is not repeated. There is no need to iterate through the others.
//             */
//            if (oneofDescriptor != null) {
//                // Skip other fields in the Oneof we know are not set
//                i += oneofDescriptor.getFieldCount() - 1;
//                if (!hasOneof(oneofDescriptor)) {
//                    // If no field is set in the Oneof, skip all the fields in the Oneof
//                    continue;
//                }
//                // Get the pointer to the only field which is set in the Oneof
//                field = getOneofFieldDescriptor(oneofDescriptor);
//            } else {
//                // If we are not in a Oneof, we need to check if the field is set and if it is repeated
//                if (field.isRepeated()) {
//                    final List<?> value = (List<?>) getField(field);
//                    if (!value.isEmpty()) {
//                        result.put(field, value);
//                    }
//                    continue;
//                }
//                if (!hasField(field)) {
//                    continue;
//                }
//            }
//            // Add the field to the map
//            if (getBytesForString && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
//                result.put(field, getFieldRaw(field));
//            } else {
//                result.put(field, getField(field));
//            }
//        }
//        return result;
//    }
//}
