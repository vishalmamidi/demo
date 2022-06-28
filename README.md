# Run in local 


# Run Azure CLI

```
docker run -it --rm --entrypoint /bin/sh mcr.microsoft.com/azure-cli:latest
```

# Login to Azure

```
az login
```

# Create Storage

```
AZURE_BACKUP_RESOURCE_GROUP=velero
AZURE_STORAGE_ACCOUNT_NAME=veleromarcel
BLOB_CONTAINER=mycluster
AZURE_BACKUP_SUBSCRIPTION_ID=

# set subscription
az account set --subscription $AZURE_BACKUP_SUBSCRIPTION_ID
# resource group
az group create -n $AZURE_BACKUP_RESOURCE_GROUP --location WestUS

# storage account
az storage account create \
    --name $AZURE_STORAGE_ACCOUNT_NAME \
    --resource-group $AZURE_BACKUP_RESOURCE_GROUP \
    --sku Standard_GRS

# get key
AZURE_STORAGE_ACCOUNT_ACCESS_KEY=`az storage account keys list --account-name $AZURE_STORAGE_ACCOUNT_NAME --query "[?keyName == 'key1'].value" -o tsv`

# blob container
az storage container create -n $BLOB_CONTAINER \
  --public-access off \
  --account-name $AZURE_STORAGE_ACCOUNT_NAME \
  --account-key $AZURE_STORAGE_ACCOUNT_ACCESS_KEY

```

# Export variables

Let's export these variables into our Velero container <br/>
<br/>
Copy and paste this to the velero container:
```

printf "export BLOB_CONTAINER=$BLOB_CONTAINER \nexport AZURE_BACKUP_RESOURCE_GROUP=$AZURE_BACKUP_RESOURCE_GROUP \nexport AZURE_STORAGE_ACCOUNT_NAME=$AZURE_STORAGE_ACCOUNT_NAME \nexport AZURE_STORAGE_ACCOUNT_ACCESS_KEY=$AZURE_STORAGE_ACCOUNT_ACCESS_KEY \nexport AZURE_BACKUP_SUBSCRIPTION_ID=$AZURE_BACKUP_SUBSCRIPTION_ID\n"
```



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


