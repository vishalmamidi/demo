# README 


## build jar 
```
./gradlew build
```
```
./mvnw package
```
```
mvn clean install
```

## build local container image 

```
docker build -t demo-rest .
```
## check local images
```
docker images
```

## tag container image 
```
sudo docker tag demo-rest vishalmamidi/demo-rest
```
## push tagged container image
```
sudo docker push vishalmamidi/demo-rest
```

## run container image 
```
sudo docker run -p 8080:8080 vishalmamidi/demo-rest
```

## check and stop container 
```
sudo docker ps 
```
```
sudo docker stop $(sudo docker ps -q --filter ancestor=vishalmamidi/demo-rest )
```

or if you know container id 

```
sudo docker stop <container-id>
```


