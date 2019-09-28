package ichen.test;

import java.util.UUID;

public class TestUUID {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String str = uuid.toString().replace("-", "");
        System.out.println(str);
    }
}
