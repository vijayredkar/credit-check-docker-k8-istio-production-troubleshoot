
echo "                        "
echo "------------------ Start Mongo deploy --------------------------"


cd /c/Vijay/Java/projects/kyc-k8-docker-istio/networking


echo "                        "
echo "------------------  kubectl create ns mongo --------------------------"
kubectl create ns mongo

echo "                        "
echo "------------------kubectl label namespace mongo istio-injection=enabled--------------------------"
kubectl label namespace mongo istio-injection=enabled

echo "                        "
echo "------------------kubectl label namespace default istio-injection=enabled--------------------------"
kubectl label namespace default istio-injection=enabled

echo "                        "
echo "------------------  kubectl apply -f operations_mongo-deployment.yml --------------------------"
kubectl create -f operations_mongo-deployment.yml   -n mongo


echo "                        "
echo "------------------ Completed Mongo deploy --------------------------"


echo "                        "
echo "------------------ Check POD status. Ensure all Mongo PODs 2/2 --------------------------"

#kubectl get svc --all-namespaces
#kubectl get serviceaccounts  --all-namespaces

echo "                        "
echo "------------------ kubectl get pods --all-namespaces --------------------------"
kubectl get pods --all-namespaces


#echo "                        "
#echo "------------------ Update KYC Advanced application.properties Mongo URI spring.data.mongodb.uri=mongodb://mongo-nodeport-svc.mongo:27017/kyc --------------------------"


#echo "                        "
#echo "------------------ minikube ip --------------------------"
#minikube ip


#echo "                        "
#echo "------------------ get Mongo PORT -  minikube service --url mongo-nodeport-svc --------------------------"
#minikube service --url mongo-nodeport-svc -n mongo









