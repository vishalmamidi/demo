# Run in local 


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
or 

## build and tag
```
docker build -t vishalmamidi/demo-rest .
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

# Deploy the Application to Kubernetes

## generated YAML

```bash
kubectl create deployment demo-rest --image=vishalmamidi/demo-rest --dry-run=client -o=yaml > deployment.yaml
```

```bash
echo --- >> deployment.yaml
```

```bash
kubectl create service clusterip demo-rest --tcp=8080:8080 --dry-run=client  -o=yaml >> deployment.yaml
```

## apply generated YAML

```bash
kubectl apply -f deployment.yaml
```

## check if application is running

```bash
kubectl get all
```

## port forward

```bash
kubectl port-forward service/demo-rest 8080:8080
```


