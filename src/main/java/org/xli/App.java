package org.xli;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
import org.xli.tutorial.AddressBookProtos;
import org.xli.tutorial.AddressBookProtos.Person;
import org.xli.tutorial.AddressBookProtosElse;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        // 填充数据到message
        Person john = Person.newBuilder()
            .setId(1234)
            .setName("John Doe")
            .setEmail("jdoe@example.com")
            .addPhones(
                    Person.PhoneNumber.newBuilder()
                            .setNumber("555-4321")
                            .setType(Person.PhoneType.HOME)
            ).build();

        // 输出二进制后的数据
        System.out.println(john.toByteString().toStringUtf8());
        System.out.println("================================");
        System.out.println(john.toString());
        System.out.println("================================");

        // 使用Any类型并输出
        AddressBookProtosElse.AddressBook addressBook =
                AddressBookProtosElse.AddressBook.newBuilder()
                        .addDetails(Any.pack( AddressBookProtos.Person.newBuilder()
                                .setId(122)
                                .setEmail("127")
                                .setName("Wangwu")
                                .build()
                                ))
                        .addDetails(Any.pack( AddressBookProtos.Person.newBuilder()
                                .setId(222)
                                .setEmail("333")
                                .setName("Lisi")
                                .build()))
                .build();

        System.out.println(addressBook.toString());
    }
}
