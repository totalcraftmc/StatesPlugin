# StatesPlugin
чтобы развернуть сервер необходимо скачать jar файл
https://papermc.io/downloads/paper
```
java -jar paper-example.jar -nogui
```
создастся файл eula.txt. В нем 
```
eula=true
```
запускаем сервер для генерации мира

```
java -jar paper-example.jar -nogui
```
в server.properties
```
online-mode=false
```

для работы с бд заполнить resources/META_INF/persistence.xml
