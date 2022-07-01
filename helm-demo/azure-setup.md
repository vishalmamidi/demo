https://github.com/Azure/k8s-set-context

## Configure deployment credentials:
  
### Configure a service principal with a secret:

For using any credentials like Azure Service Principal, Publish Profile etc add them as [secrets](https://help.github.com/en/articles/virtual-environments-for-github-actions#creating-and-using-secrets-encrypted-variables) in the GitHub repository and then use them in the workflow.


Follow the steps to configure Azure Service Principal with a secret:
  * Define a new secret under your repository settings, Add secret menu
  * Store the output of the below [az cli](https://docs.microsoft.com/en-us/cli/azure/?view=azure-cli-latest) command as the value of secret variable, for example 'AZURE_CREDENTIALS'
```bash  
   az ad sp create-for-rbac --name "myApp" --role contributor \
                            --scopes /subscriptions/{subscription-id}/resourceGroups/{resource-group} \
                            --sdk-auth
                            
  # Replace {subscription-id}, {resource-group} with the subscription, resource group details
  # The command should output a JSON object similar to this:
 
  {
    "clientId": "<GUID>",
    "clientSecret": "<STRING>",
    "subscriptionId": "<GUID>",
    "tenantId": "<GUID>",
    "resourceManagerEndpointUrl": "<URL>"
    (...)
  }



-------------------------------------------------------

azure credentials

https://github.com/Azure/login#configure-a-service-principal-with-a-secret

https://docs.github.com/en/actions/deployment/deploying-to-your-cloud-provider/deploying-to-azure/deploying-to-azure-kubernetes-service

service principle 

az ad sp create-for-rbac --name



--------------------------------------------------------

### access locally 
az login

get tenant from aad

az login --tenant 

az account list

az account set --subscription 702ae382-d65f-4137-8dc7-9976161aa7cf

az aks get-credentials --resource-group my_group --name demo-aks


--------------------------------------------------------
