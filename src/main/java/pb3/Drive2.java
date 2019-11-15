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
                .putMap1("r1", Helloworld.HelloReply.newBuilder().setMessage("msg11").build())
                .putMap1("r2", Helloworld.HelloReply.newBuilder().setMessage("msg12").build())
                .putMap2("r1map2", 12)
                .putMap3("r1map3", Helloworld.Corpus.IMAGES)
                .addCorpusList(Helloworld.Corpus.IMAGES)
                .addCorpusList(Helloworld.Corpus.LOCAL)
                .addCorpusList(Helloworld.Corpus.NEWS)
                .build();

        Helloworld.Item item2 = Helloworld.Item.newBuilder()
                .setS("oneofstring")
                .setCorpus(Helloworld.Corpus.IMAGES)
                .setId(1)
                .setName("name1")
                .putMap1("r2", Helloworld.HelloReply.newBuilder().setMessage("msg2").build())
                .putMap1("r22", Helloworld.HelloReply.newBuilder().setMessage("msg22").build())
                .putMap2("r2map2", 22)
                .putMap3("r3map3", Helloworld.Corpus.LOCAL)
                .addCorpusList(Helloworld.Corpus.IMAGES)
                .addCorpusList(Helloworld.Corpus.LOCAL)
                .addCorpusList(Helloworld.Corpus.NEWS)
                .build();

        Helloworld.Inner inner = Helloworld.Inner.newBuilder()
                .setI32(111)
                .addItemList(item1)
                .addItemList(item2)
                .build();

        Helloworld.Middle middle = Helloworld.Middle.newBuilder().setInner(inner).build();
        Helloworld.Outer outer = Helloworld.Outer.newBuilder().setMiddle(middle).build();
        System.out.println(outer);
        walk33(outer, "outer");

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

    /**
     * root is a message wrapper.
     * it's not of primitive types.
     * so its 'name' is needed so that the path to specific field can be shown.
     * <p>
     * parent is the path name that contains every parent message type.
     * if any container has been encountered, it show the container's name as well.
     *
     * @param root
     * @param prefix
     */
    private static void walk33(GeneratedMessageV3 root, String prefix) {
        if (root == null) {
            return;
        }
        //extract current wrapper class's name, and concatenate it with parent path

        //transverse all the fields of current object
        //recursively going inside sub objects if it is not a protobuf3 message type
        //otherwise invoke related callbacks
        Map<Descriptors.FieldDescriptor, Object> map = root.getAllFields();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = entry.getKey();
            String fieldName = fieldDescriptor.getName();
            Descriptors.FieldDescriptor.Type type = fieldDescriptor.getType();
            if (type != Descriptors.FieldDescriptor.Type.MESSAGE) {
                logger.info("{} value : {}", fieldStatsName(prefix, fieldName), entry.getValue());
                continue;
            }

            //if this is a list (map in protobuf is represented with a list of MapEntries)
            Object value = entry.getValue();
            if (value instanceof List) {
                List list = (List) value;
                if (list.isEmpty()) {
                    //should not get here?
                    System.out.println("empty list");
                    continue;
                }

                Object first = list.get(0);
                //check if this is actually a map
                //i.e. map<xx, xx>
                if (first instanceof MapEntry) {
                    MapEntry e = (MapEntry) first;
                    logger.info("{} size : {}", fieldName, list.size());
                    //map<x, GeneratedMessageV3>
                    if (e.getValue() instanceof GeneratedMessageV3) {

                        for (Object o : list) {
                            MapEntry inner = (MapEntry) o;
                            //key is always of primitive types
//                            logger.info("{} : {}", inner.getKey());

                            walk33((GeneratedMessageV3) inner.getValue(),
//                                    mapValueStatsName(prefix, fieldName, inner.getKey())
                                    fieldStatsName(prefix, fieldName)
                            );
                        }
                        continue;
                    }

                    //map<x, primitive type>
                    logger.info("{} size : {}", fieldStatsName(prefix, fieldName), list.size());
                    continue;
                }

                //ordinary protobuf3 object
                //i.e. list<GeneratedMessageV3>
                if (first instanceof GeneratedMessageV3) {
                    for (Object o : list) {
                        walk33((GeneratedMessageV3) o, fieldStatsName(prefix, fieldName));
                    }
                    continue;
                }

                //primitive type
                //i.e. list<primitive types>
                logger.info("{} size : {}", fieldStatsName(prefix, fieldName), list.size());
                continue;
            }

            //this field is a single protobuf3 message type
            if (value instanceof GeneratedMessageV3) {
                GeneratedMessageV3 msg = (GeneratedMessageV3) value;
                walk33(msg, fieldStatsName(prefix, fieldName));
            }
        }
    }

    private static String fieldStatsName(String prefix, String fieldName) {
        return prefix + "." + fieldName;
    }

    private static String mapValueStatsName(String prefix, String fieldName, Object key) {
        return prefix + "." + fieldName + "." + key;
    }

    //string of relative path is enough
    static class Context {
        public String path;
    }
}
