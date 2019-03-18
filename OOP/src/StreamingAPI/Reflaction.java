package StreamingAPI;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflaction {
    private String name = "vasyok";
    private int age;

    public static void main(String[] args) {
        Reflaction reflaction = new Reflaction();
        int age = reflaction.getAge();
        String name = null;
        print(reflaction);
        try {
            Field field = reflaction.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(reflaction, (String) "new value");
            name = (String) field.get(reflaction);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        print(reflaction);
    }
    public static void print(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("print");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private void print(){
        System.out.println(age + " " + name);
    }
}