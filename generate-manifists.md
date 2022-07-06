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
