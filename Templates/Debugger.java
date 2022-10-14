package Templates;

public class Debugger {
    public static <T extends  Number> void print(T[][][] arr){
        System.out.println("3d matrix = {");
        for(T[][] ele: arr)
            print(ele);
        System.out.println("}");
    }
    public static <T extends Number> void print(T[][] arr){
        System.out.println("matrix = {");
        for(T[] ele: arr)
            print(ele);
        System.out.println("}");
    }
    public static <T extends Number> void print(T[] arr){
        System.out.print("arr= {");
        for(T ele: arr)
            System.out.print(ele+", ");
        System.out.println("}");
    }
}
