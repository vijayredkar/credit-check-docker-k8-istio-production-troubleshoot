
echo "                        "
echo "------------------ Start Kafka deploy --------------------------"


cd /c/Vijay/Java/projects/minikube-kafka-cluster

echo "                        "
echo "------------------kubectl apply -f 00-namespace/--------------------------"
kubectl apply -f 00-namespace/

echo "                        "
echo "------------------kubectl label namespace kafka-ca1 istio-injection=enabled--------------------------"
kubectl label namespace kafka-ca1 istio-injection=enabled

echo "                        "
echo "------------------kubectl label namespace default istio-injection=enabled--------------------------"
kubectl label namespace default istio-injection=enabled

echo "                        "
echo "------------------kubectl apply -f 01-zookeeper/--------------------------"
kubectl apply -f 01-zookeeper/

echo "                        "
echo "------------------kubectl apply -f 02-kafka/--------------------------"
kubectl apply -f 02-kafka/




echo "                        "
echo "------------------ Completed Kafka deploy --------------------------"

echo "                        "
echo "------------------ Check POD status. Ensure all Kafka PODs 2/2 --------------------------"

#kubectl get svc --all-namespaces
#kubectl get serviceaccounts  --all-namespaces

echo "                        "
echo "------------------ kubectl get pods --all-namespaces --------------------------"
kubectl get pods --all-namespaces

