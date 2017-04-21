//import com.google.common.collect.BiMap;
//import com.google.common.collect.HashBiMap;
//
//import javax.tools.FileObject;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Scanner;
//
///**
// * Created by parsa on 3/28/2017.
// */
//public class Bitmap {
//    public static void main(String[] args) {
//
//
//        ArrayList<Integer> arraychat=new ArrayList<>();
//        BiMap<Integer, Integer> biMap = HashBiMap.create();
//        Scanner scanner=new Scanner(System.in);
//
//
//        while (true) {
//            System.out.println("id");
//            arraychat.add(scanner.nextInt());
//            if (arraychat.size() > 1) {
//                biMap.put(arraychat.get(0), arraychat.get(1));
//                System.out.println(arraychat.get(0) + " vasl shod be" + arraychat.get(1));
//                arraychat.remove(0);
//                arraychat.remove(0);
//
//            }
//
////
//            int a;
//            System.out.println("dastor");
//            a = scanner.nextInt();
//            if (a == 0) {
//
//                int b = scanner.nextInt();
//                if (biMap.get(b) != null) {
//                    System.out.println(b + "partner= " + biMap.get(b));
//                } else if (biMap.inverse().get(b) != null) {
//                    System.out.println(b + "partner= " + biMap.inverse().get(b));
//                } else {
//                    System.out.println("not found");
//                }
//
//
//            }
//            if (a == 1) {
//
//                int b = scanner.nextInt();
//
//                if (biMap.inverse().get(b) != null) {
//                    System.out.println(b + "partner= " + biMap.inverse().get(b)+"paak shod");
//                    biMap.inverse().forcePut(b, null);
//                    biMap.inverse().forcePut(null,null);
//                }else if (biMap.get(b) != null){
//                    System.out.println(b + "partner= " + biMap.get(b)+"paak shod");
//                    biMap.forcePut(b, null);
//                    biMap.forcePut(null,null);
//                }else{
//                    System.out.println("too saf nabood");
//                }
//
//            }
//        }
////        System.out.println("9 = " + biMap.get(9));
////        System.out.println("8 = " + biMap.inverse().get(2));
////
////        biMap.forcePut(6,null);
////        biMap.forcePut(null,null);
////
////        biMap.forcePut(4,null);
////        biMap.forcePut(null,null);
////        System.out.println(biMap.get(6));
//
//
//    }
//}
