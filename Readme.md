## Compilar
Na pasta raiz do projeto, executar a seguinte linha:
cd ./; JAVA_HOME=/usr/lib/jvm/jdk-21-oracle-x64 /usr/lib/apache-netbeans/java/maven/bin/mvn --no-transfer-progress clean install

## Executar
Na pasta raiz do projeto, executar a seguinte linha:
/usr/bin/env /usr/lib/jvm/jdk-21-oracle-x64/bin/java --enable-preview -XX:+ShowCodeDetailsInExceptionMessages -cp ./target/classes com.mycompany.campominado.CampoMinado 

