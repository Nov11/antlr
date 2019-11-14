package pb3;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MapEntry;
import helloworld.Helloworld;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class Drive2 {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Drive2.class);

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Helloworld.Item item1 = Helloworld.Item.newBuilder()
                .setB(true)
                .setCorpus(Helloworld.Corpus.IMAGES)
                .setId(1)
                .setName("name1")
                .putMap("r1", Helloworld.HelloReply.newBuilder().setMessage("msg").build())
                .build();

        Helloworld.Item item2 = Helloworld.Item.newBuilder()
                .setS("oneofstring")
                .setCorpus(Helloworld.Corpus.IMAGES)
                .setId(1)
                .setName("name1")
                .putMap("r1", Helloworld.HelloReply.newBuilder().setMessage("msg").build())
                .build();

        Helloworld.Inner inner = Helloworld.Inner.newBuilder()
                .setI32(111)
                .addItemList(item1)
                .addItemList(item2)
                .build();

        Helloworld.Middle middle = Helloworld.Middle.newBuilder().setInner(inner).build();
        Helloworld.Outer outer = Helloworld.Outer.newBuilder().setMiddle(middle).build();
        System.out.println(outer);
        walk33(outer);
//        show(outer.getAllFields());

        System.out.println("---");
//        show(Helloworld.Outer.getDefaultInstance().getAllFields());
    }

    private static void walk21(Object object) {
        if (object instanceof List) {
            List list = (List) object;


        }
    }


    private static void show(Map<Descriptors.FieldDescriptor, Object> map) {
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            logger.info("{} -> ", entry.getKey());
            Object obj = entry.getValue();
        }
    }

    private static String makeUpName(String prefix, String current) {
        return StringUtils.isEmpty(prefix) ? current : prefix + "." + current;
    }

    private static void walkList(List list) {
        for (Object msg : list) {
            //map
            if (msg instanceof MapEntry) {
                MapEntry e = (MapEntry) msg;
//                logger.info("{}", fieldName);
//                        logger.info("{}", makeUpName(prefix, fieldName));
                GeneratedMessageV3 v = (GeneratedMessageV3) e.getValue();
                walk(v);
                continue;
            }
            GeneratedMessageV3 v = (GeneratedMessageV3) msg;
            walkObject(v);
        }
    }

    private static void walk(Object root) {
        if (root instanceof MapEntry) {
            MapEntry mapEntry = (MapEntry) root;

            return;
        }

        if (root instanceof List) {
            List list = (List) root;
            for (Object obj : list) {
                walk(obj);
            }
            return;
        }

        if (root instanceof com.google.protobuf.Enum) {
            System.out.println(root);
            return;
        }

        //primitive

    }

    private static void walkObject(GeneratedMessageV3 root) {
        if (root == null) {
            return;
        }

        Descriptors.Descriptor descriptor = root.getDescriptorForType();
//        logger.info("{}", descriptor.getFullName());
        String prefix = descriptor.getFullName();


        Map<Descriptors.FieldDescriptor, Object> map = root.getAllFields();

//        if (MapUtils.isEmpty(map)) {
//            logger.info("{}.{}", prefix, root.get);
//            return;
//        }

        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            String fieldName = entry.getKey().getName();
            Object value = entry.getValue();

//            logger.info("{}", makeUpName(prefix, fieldName));

            logger.info("{}", fieldName);

            //dfs
            if (value instanceof List) {
                List list = (List) value;

                return;
            }

            if (value instanceof GeneratedMessageV3) {
                GeneratedMessageV3 msg = (GeneratedMessageV3) value;
                walk(msg);
            }
        }
    }

//    private static void walk(GeneratedMessageV3 root, String prefix) {
//        if (root == null) {
//            return;
//        }
//
//        Map<Descriptors.FieldDescriptor, Object> map = root.getAllFields();
//
////        if (MapUtils.isEmpty(map)) {
////            logger.info("{}.{}", prefix, root.get);
////            return;
////        }
//
//        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
//            String fieldName = entry.getKey().getName();
//            Object value = entry.getValue();
//
//            logger.info("{}", makeUpName(prefix, fieldName));
//
//            //dfs
//            if (value instanceof List) {
//                List list = (List) value;
//                for (Object msg : list) {
//                    if (msg instanceof MapEntry) {
//                        MapEntry e = (MapEntry) msg;
//                        logger.info("{}", makeUpName(prefix, fieldName));
//                        GeneratedMessageV3 v = (GeneratedMessageV3) e.getValue();
//                        walk(v, );
//                        continue;
//                    }
//                    GeneratedMessageV3 v = (GeneratedMessageV3) msg;
//                    walk(v);
//                }
//                return;
//            }
//
//            if (value instanceof GeneratedMessageV3) {
//                GeneratedMessageV3 msg = (GeneratedMessageV3) value;
//                walk(msg);
//            }
//        }
//    }

    private static void walk33(GeneratedMessageV3 root) {
        if (root == null) {
            return;
        }
        Map<Descriptors.FieldDescriptor, Object> map = root.getAllFields();

        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor.Type type = entry.getKey().getType();
//            logger.info("{} - type : {}", entry.getKey().getFullName(), type);
            if (type != Descriptors.FieldDescriptor.Type.MESSAGE) {
                logger.info("field : {} value : {}", entry.getKey().getFullName(), entry.getValue());
                continue;
            }

            Object value = entry.getValue();
            if (value instanceof List) {
                List list = (List) value;
                if (list.isEmpty()) {
                    System.out.println("empty list");
                    continue;
                }

                Object first = list.get(0);
                if (first instanceof MapEntry) {
                    //this is a map
                    MapEntry e = (MapEntry) first;
                    //map<x, GeneratedMessageV3>
                    if (e.getValue() instanceof GeneratedMessageV3) {
                        for (Object o : list) {
                            MapEntry inner = (MapEntry) o;
                            logger.info("key : {}", inner.getKey());
                            walk33((GeneratedMessageV3) inner.getValue());
                        }
                    }
                    continue;
                }

                //ordinary protobuf3 object
                if (first instanceof GeneratedMessageV3) {
                    for (Object o : list) {
                        walk33((GeneratedMessageV3) o);
                    }
                    continue;
                }
                //primitive type
                logger.info("list of {} size : {}", first.getClass(), list.size());
                continue;
            }

            if (value instanceof GeneratedMessageV3) {
                GeneratedMessageV3 msg = (GeneratedMessageV3) value;
                walk33(msg);
            }
        }
    }
}
