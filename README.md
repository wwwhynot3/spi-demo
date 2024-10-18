## Description
This is a simple Java SPI demo to demonstrate the usage of Java SPI.
<!-------------------------->
这是一个简单的Java SPI Demo，用于演示Java SPI的使用方法。

-----
## What is SPI
The Service Provider Interface (SPI) in Java allows for dynamic loading of implementation classes at runtime.   
This mechanism works by creating a file in the `META-INF/services` directory, named after the `fully qualified interface name`.   
The file contains the `fully qualified names of the implementation classes, each on a new line`. By reading this file, Java can dynamically load the implementation classes.    
In essence, SPI uses the fully qualified interface name to locate the implementation class names, and then uses reflection to instantiate these classes.   
This process relies on conventions (such as storing the file in META-INF/services with the full interface name as the filename and the implementation class names as the file content) and reflection (dynamically loading classes using their fully qualified names).  
<!-------------------------->
ServiceProviderInterface（SPI）是Java提供的一种服务提供接口，通过SPI可以实现在运行时动态加载实现类，而不需要在编译时就将实现类加载到项目中。SPI的实现机制是接口实现模块在`META-INF/services`目录下创建一个以`接口全限定名`为名字的文件，文件内容为`实现类的全限定名（多个实现的换行存储）`，通过读取这个文件，可以动态加载实现类。  
SPI的本质是通过接口的全限定名找到实现类的全限定名，然后通过反射机制实例化实现类，即约定（约定存储位置为META-INF/service与接口为文件名实现类为文件内容）与反射（通过全限定名动态加载类）。  

-----
## Prerequisites

- JDK 21 (There are JDK9+ functions in com.wwwhynot3.LogFactory, you can also modify this syntax and change the JDK version in Pom.xml)  
- Maven
<!-------------------------->
- JDK 21（com.wwwhynot3.LogFactory中存在JDK9+函数，亦可修改此语法并在Pom.xml中修改JDK版本）
- Maven

-----
## How to run this example

### Directly Run the Packaged Sample
The packaged logger-service.jar and logger-provider-interface.jar already exist in the lib directory, you can directly run the Main class in the spi module.
<!-------------------------->
在lib中已经存在打包好的logger-service.jar 与 logger-provider-interface.jar，可以直接执行spi模块中的Main类。

### Modify the Code and Run
After modifying the code, you can:
1. Execute `mvn package` in the `logger-provider-interface` module, and copy `logger-provider-interface/target/logger-provider-interface-0.1.jar` to `logger-service/lib` and `spi/lib`
2. Execute `mvn package` in the `logger-service` module, and copy `logger-service/target/logger-service-0.1.jar` to `spi/lib`
3. Ensure that the `pom.xml` in the `spi` module has already included the `logger-service` and `logger-provider-interface` modules, and that the modules are up to date, then directly run the Main class in the `spi` module  
<!-------------------------->
1. 在 `logger-provider-interface` 模块中执行 `mvn package`, 将 `logger-provider-interface/target/logger-provider-interface-0.1.jar` 复制到` logger-service/lib` 与 `spi/lib` 中
2. 在 `logger-service` 模块中执行 `mvn package`, 将 `logger-service/target/logger-service-0.1.jar` 复制到 `spi/lib` 中 
3. 在确保 `spi` 模块中的 `pom.xml` 中已经引入了 `logger-service` 与 `logger-provider-interface` 两个模块，并且模块是最新的后，直接执行 `spi` 模块中的 `Main` 类即可

-----
you can run the following commands to achieve this:
```shell
    cd spi-demo
    current_path=$(pwd)
    cd $current_path/logger-provider-interface && mvn package
    cp $current_path/logger-provider-interface/target/logger-provider-interface-0.1.jar $current_path/logger-service/lib/
    cp $current_path/logger-provider-interface/target/logger-provider-interface-0.1.jar $current_path/spi/lib
    cd $current_path/logger-service && mvn package
    cp $current_path/logger-service/target/logger-service-0.1.jar $current_path/spi/lib
    cd $current_path/spi && mvn compile && java -cp lib/logger-provider-interface-0.1.jar:lib/logger-service-0.1.jar:target/classes com.wwwhynot3.Main
```

